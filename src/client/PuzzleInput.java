package client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Sahak I.
 */
public class PuzzleInput extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textUsername;

    /**
     * Create the panel.
     */
    public PuzzleInput() {
        setLayout(new BorderLayout());

        JPanel PuzzleInputPane = new JPanel();
        PuzzleInputPane.setBackground(Color.LIGHT_GRAY);

        add(PuzzleInputPane, BorderLayout.CENTER);

        JPanel pane = new JPanel();
        pane.setBackground(Color.LIGHT_GRAY);
        PuzzleInputPane.add(pane);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Monospaced", Font.BOLD, 17));
        pane.add(lblUsername);

        textUsername = new JTextField();
        pane.add(textUsername);
        textUsername.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PuzzleGame game = new PuzzleGame();
                removeAll();
				add(game, BorderLayout.CENTER);
				revalidate();
				repaint();
            }
        });
        PuzzleInputPane.add(btnSubmit);
    }
}