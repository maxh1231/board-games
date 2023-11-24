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

/**
 * @author maxhu
 */
public class PlayerInput extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel player1Pane;
	private JPanel player2Pane;
	private JTextField player1Name;
	private JTextField player2Name;
	
	/**
	 * Create the panel.
	 */
	public PlayerInput() {
		setLayout(new BorderLayout());
		
		JPanel inputPane = new JPanel();
//		inputPane.setLayout(new GridLayout(0, 1));
		
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
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(0, 1));
		
		player1Name = newPlayer1Name();
		JLabel player1Lbl = newPlayer1Lbl();
		
		pane.add(player1Lbl);
		pane.add(player1Name);
		
		return pane;
		
	}
	
	/**
	 * Input for player1
	 * @return JTextField
	 */
	private JTextField newPlayer1Name() {
		JTextField player1Name = new JTextField();
		player1Name.setHorizontalAlignment(SwingConstants.CENTER);
		return player1Name;
	}
	
	/**
	 * player 1 label
	 * @return JLabel
	 */
	private JLabel newPlayer1Lbl() {
		JLabel player1Lbl = new JLabel();
		player1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		player1Lbl.setText("Player 1 Name:");
		return player1Lbl;
	}
	
	/**
	 * Player2 label
	 * @return JPanel
	 */
	private JPanel newPlayer2Pane() {
		 JPanel pane = new JPanel();
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
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
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
		});
		return submit;
	}
}
