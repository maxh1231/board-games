package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author maxhu
 */
public class TicTacToeWinner extends JPanel {

	private static final long serialVersionUID = 1L;
	private String winner;

	/**
	 * Notifies user of win and prompts to save score
	 */
	public TicTacToeWinner(String winner) {
		this.winner = winner;
		
		setLayout(new BorderLayout());
		
		JLabel winnerLbl = newWinnerLbl();
		JPanel btnPane = newBtnPane();
		
		add(winnerLbl, BorderLayout.CENTER);
		add(btnPane, BorderLayout.SOUTH);
		
		
	}
	
	/**
	 * JPanel for Yes and No buttons on prompts
	 * @return JPanel
	 */
	private JPanel newBtnPane() {
		JPanel btnPane = new JPanel();
		setLayout(new GridLayout(0, 1));
		
		JButton yesBtn = newSubmitBtn("Yes");
		JButton noBtn = newSubmitBtn("No");
		
		btnPane.add(yesBtn);
		btnPane.add(noBtn);
		
		return btnPane;
	}
	
	/**
	 * Accepts a string to represent the buttons text
	 * @param btnText
	 * @return JButton
	 */
	private JButton newSubmitBtn(String btnText) {
		JButton submitBtn = new JButton(btnText);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (submitBtn.getText().equals("Yes")) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		});
		return submitBtn;
	}
	
	/**
	 * Notifies which player that won, using the winner field
	 * @return JLabel
	 */
	private JLabel newWinnerLbl() {
		JLabel winnerLbl = new JLabel("Congrats " + winner + "! Would you like to save your score?");
		winnerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return winnerLbl;
	}

}
