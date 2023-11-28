package client;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionListener;


public class PuzzlePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int emptyIndex; // Index of the empty space
    private List<ImageIcon> initialIcons; // To store the initial state of the puzzle
    private JPanel gridPanel; // Panel to hold the puzzle pieces
    private JButton solveButton; // Button to solve the puzzle
    private JTextField textField;

    public PuzzlePanel() {
        super(new BorderLayout()); // Use BorderLayout for the PuzzlePanel
        gridPanel = new JPanel(); // This will hold the puzzle pieces
        initialIcons = new ArrayList<>();
        initializePuzzle();
        add(gridPanel, BorderLayout.CENTER); // Add gridPanel to the center of PuzzlePanel
        gridPanel.setLayout(new BorderLayout(0, 0));
        
        textField = new JTextField();
        gridPanel.add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        solveButton = new JButton("Solve");
      
    
        solveButton.addActionListener(e -> solvePuzzle());
        add(solveButton, BorderLayout.SOUTH); // Add the solve button to the south of PuzzlePanel
    }

    private void initializePuzzle() {
        List<BufferedImage> pieces = ImageSplitter.splitImage("src/client/images/puzzle.png", 3, 3);

        // First, save the initial state before shuffling
        initialIcons = new ArrayList<>(pieces.size());
        for (BufferedImage piece : pieces) {
            initialIcons.add(new ImageIcon(piece));
        }

        // Now shuffle the pieces to start the game
        Collections.shuffle(pieces);

        for (int i = 0; i < pieces.size(); i++) {
            ImageIcon icon = new ImageIcon(pieces.get(i));
            JButton button = new JButton(icon);
            if (i < pieces.size() - 1) {
                button.setIcon(icon);
            } else {
                // The last button is the empty space
                button.setIcon(null); // Set the last button to have no icon
                button.setEnabled(false); // Disable the last button
                emptyIndex = i; // Set the empty space index
            }
            button.addActionListener(e -> buttonClicked(button));
            gridPanel.add(button); // Add button to the grid panel
        }
    }


    private boolean canMove(int clickedIndex) {
        // Calculate row and column of the clicked piece and the empty space
        int clickedRow = clickedIndex / 3;
        int clickedCol = clickedIndex % 3;
        int emptyRow = emptyIndex / 3;
        int emptyCol = emptyIndex % 3;

        // Check if the clicked piece is adjacent to the empty space
        return (clickedRow == emptyRow && Math.abs(clickedCol - emptyCol) == 1) ||
               (clickedCol == emptyCol && Math.abs(clickedRow - emptyRow) == 1);
    }

    private void swapButtons(int clickedIndex, int emptyIndex) {
        Component[] components = gridPanel.getComponents();

        JButton clickedButton = (JButton) components[clickedIndex];
        JButton emptyButton = (JButton) components[emptyIndex];

        // Swap icons
        Icon clickedIcon = clickedButton.getIcon();
        clickedButton.setIcon(emptyButton.getIcon());
        emptyButton.setIcon(clickedIcon);

        // Update the empty index
        this.emptyIndex = clickedIndex;

        // After swapping, the clicked button becomes the new empty space
        clickedButton.setEnabled(false);
        emptyButton.setEnabled(true); // The previous empty space becomes active
    }


    private void checkCompletion() {
        // Assuming all components in gridPanel are JButtons
        for (int i = 0; i < gridPanel.getComponentCount(); i++) {
            Component comp = gridPanel.getComponent(i);
            if (comp instanceof JButton) { // Check if the component is a JButton
                JButton button = (JButton) comp;
                Icon icon = button.getIcon();

                // The empty space will not have an icon, so check for null
                if (initialIcons.get(i) != null && !initialIcons.get(i).equals(icon)) {
                    return; // The puzzle is not yet solved
                }
            } else {
                // Handle the case where the component is not a JButton (should not happen if the grid only contains JButtons)
                System.out.println("Encountered a non-button component in the grid.");
            }
        }
        // Puzzle solved
        JOptionPane.showMessageDialog(this, "Puzzle Solved!");
    }

    private void solvePuzzle() {
        Component[] components = gridPanel.getComponents();

        // Reset each button to its initial icon
        for (int i = 0; i < components.length; i++) {
            JButton button = (JButton) components[i];
            button.setIcon(initialIcons.get(i));
            button.setEnabled(true);
        }

        // The last button is the empty space
        JButton emptyButton = (JButton) components[emptyIndex];
        emptyButton.setIcon(null);
        emptyButton.setEnabled(false);

        // Now check if the puzzle is solved
        checkCompletion();
    }
    private void buttonClicked(JButton button) {
        int clickedIndex = gridPanel.getComponentZOrder(button);
        if (canMove(clickedIndex)) {
            swapButtons(clickedIndex, emptyIndex);
            checkCompletion();
        }
    }
}