package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

/**
 * @author Max Humpherys
 */
public class PlayerInput extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel player1Pane;
	private JPanel player2Pane;
	private JTextField player1Name;
	private JTextField player2Name;
	private boolean singlePlayer = false;
	private JPanel pane_1;
	private JPanel pane;

	/**
	 * Single parameter constructor for if user selects play vs AI
	 * @param singlePlayer
	 */
	public PlayerInput(boolean singlePlayer) {
		this.singlePlayer = true;
		setLayout(new BorderLayout());

		JPanel inputPane = new JPanel();
		inputPane.setBackground(Color.LIGHT_GRAY);

		player1Pane = newPlayer1Pane();

		inputPane.add(player1Pane);

		JButton submitBtn = newSubmitBtn();

		add(inputPane, BorderLayout.CENTER);
		add(submitBtn, BorderLayout.SOUTH);
	}

	/**
	 * Default constructor for player vs player
	 */
	public PlayerInput() {
		setLayout(new BorderLayout());

		JPanel inputPane = new JPanel();
		inputPane.setBackground(Color.LIGHT_GRAY);

		player1Pane = newPlayer1Pane();
		player2Pane = newPlayer2Pane();
		
		inputPane.add(player1Pane);
		inputPane.add(player2Pane);

		JButton submitBtn = newSubmitBtn();

		add(inputPane, BorderLayout.CENTER);
		add(submitBtn, BorderLayout.SOUTH);
	}

	/**
	 * Accepts input from player1
	 * @return JPanel
	 */
	private JPanel newPlayer1Pane() {
		pane_1 = new JPanel();
		pane_1.setLayout(new GridLayout(0, 1));

		player1Name = newPlayer1Name();
		JLabel player1Lbl = newPlayer1Lbl();

		pane_1.add(player1Lbl);
		pane_1.add(player1Name);

		return pane_1;

	}

	/**
	 * Input for player1
	 * @return JTextField
	 */
	private JTextField newPlayer1Name() {
		JTextField player1Name = new JTextField();
		player1Name.setHorizontalAlignment(SwingConstants.LEFT);
		return player1Name;
	}

	/**
	 * player 1 label
	 * @return JLabel
	 */
	private JLabel newPlayer1Lbl() {
		JLabel player1Lbl = new JLabel();
		player1Lbl.setOpaque(true);
		player1Lbl.setBackground(Color.LIGHT_GRAY);
		player1Lbl.setFont(new Font("Monospaced", Font.BOLD, 17));
		player1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		player1Lbl.setText("Player 1 Name:");
		return player1Lbl;
	}

	/**
	 * Player2 label
	 * @return JPanel
	 */
	private JPanel newPlayer2Pane() {
		pane = new JPanel();
		pane.setLayout(new GridLayout(0, 1));

		player2Name = newPlayer2Name();
		JLabel player2Lbl = newPlayer2Lbl();

		pane.add(player2Lbl);
		pane.add(player2Name);

		return pane;
	}

	/**
	 * Accepts input from player2
	 * @return JTextField
	 */
	private JTextField newPlayer2Name() {
		JTextField player2Name = new JTextField();
		player2Name.setHorizontalAlignment(SwingConstants.CENTER);

		return player2Name;
	}

	/**
	 * Player2 label
	 * @return JLabel
	 */
	private JLabel newPlayer2Lbl() {
		JLabel player2Lbl = new JLabel();
		player2Lbl.setOpaque(true);
		player2Lbl.setBackground(Color.LIGHT_GRAY);
		player2Lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		player2Lbl.setFont(new Font("Monospaced", Font.BOLD, 17));
		player2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		player2Lbl.setText("Player 2 Name:");
		return player2Lbl;
	}

	/**
	 * Submits input from both user
	 * @return JButton
	 */
	private JButton newSubmitBtn() {
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Monospaced", Font.BOLD, 17));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (singlePlayer) {
					if (player1Name.getText().equals("")) {
						System.out.println("invalid input");
						// handle error better
					} else {
						JPanel initGame = new TicTacToeGame(player1Name.getText());
						removeAll();
						add(initGame, BorderLayout.CENTER);
						revalidate();
						repaint();
					}
				} else {
					if (player1Name.getText().equals("") || player1Name.getText().equals("")) {
						System.out.println("invalid input");
						// handle error better
					} else {
						JPanel initGame = new TicTacToeGame(player1Name.getText(), player2Name.getText());
						removeAll();
						add(initGame, BorderLayout.CENTER);
						revalidate();
						repaint();
					}
				}
			}
		});
		return submit;
	}
}
