package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * @author Max Humpherys
 */
public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel gameSelectPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Application's home menu, selecting which game to play
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(50, 50));
		setContentPane(contentPane);
		
		JLabel titleLbl = newTitleLbl();
		contentPane.add(titleLbl, BorderLayout.NORTH);
		
		gameSelectPane = newGameSelectPane();
		contentPane.add(gameSelectPane, BorderLayout.CENTER);
		
		JLabel placeHolderLbl = newPlaceholderLbl();
		contentPane.add(placeHolderLbl, BorderLayout.SOUTH);
	}
	
	/**
	 * Application's title 
	 * @return JLabel
	 */
	private JLabel newTitleLbl() {
		JLabel titleLbl = new JLabel("Board Games");
		titleLbl.setFont(new Font("Serif", Font.PLAIN, 18));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return titleLbl;
	}

	/**
	 * Panel for options to select game
	 * @return JPanel
	 */
	private JPanel newGameSelectPane() {
		JPanel gameSelectPane = new JPanel();
		GridLayout layout = new GridLayout(1, 0);
		layout.setHgap(25);
		layout.setVgap(25);
		gameSelectPane.setLayout(layout);
		
		JButton ticTacToeBtn = newTicTacToeBtn();
		JButton puzzleBtn = newPuzzleBtn();
		gameSelectPane.add(ticTacToeBtn);
		gameSelectPane.add(puzzleBtn);
		
		return gameSelectPane;
	}
	
	/**
	 * Button to select Tic Tac Toe game
	 * @return JButton
	 */
	private JButton newTicTacToeBtn() {
		JButton ticTacToeBtn = new JButton();
		ticTacToeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JPanel tic = new TicTacToeClient();
                contentPane.removeAll();
                contentPane.add(tic, BorderLayout.CENTER);
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
		
		ImageIcon image = new ImageIcon(getClass().getResource("/client/images/tic-tac-toe.png"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(150, 128, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		ticTacToeBtn.setIcon(image);
		
		return ticTacToeBtn;
	}

	/**
	 * Button to select Puzzle game
	 * @return JButton
	 */
	private JButton newPuzzleBtn() {
		JButton puzzleBtn = new JButton();
        puzzleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PuzzleGame puzzleGame = new PuzzleGame(); // Create an instance of your puzzle game
                contentPane.removeAll(); // Remove current content
                contentPane.add(puzzleGame, BorderLayout.CENTER); // Add the puzzle game panel
                contentPane.revalidate(); // Revalidate the content pane
                contentPane.repaint(); // Repaint the content pane
            }
        });

        // Set icon for puzzleBtn...
        ImageIcon image = new ImageIcon(getClass().getResource("/client/images/puzzle.png"));
        Image img = image.getImage();
        Image newImg = img.getScaledInstance(150, 128, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        puzzleBtn.setIcon(image);

        return puzzleBtn;
    }

	/**
	 * Used to format BorderLayouts
	 * @return JLabel
	 */
	private JLabel newPlaceholderLbl() {
		JLabel placeholderLbl = new JLabel();
		return placeholderLbl;
	}

}
