package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeWinner extends JPanel {

	private static final long serialVersionUID = 1L;
	private String winner;

	/**
	 * Create the panel.
	 */
	public TicTacToeWinner(String winner) {
		this.winner = winner;
		
		setLayout(new BorderLayout());
		
		JLabel winnerLbl = newWinnerLbl();
		JPanel btnPane = newBtnPane();
		
		add(winnerLbl, BorderLayout.CENTER);
		add(btnPane, BorderLayout.SOUTH);
		
		
	}
	
	private JPanel newBtnPane() {
		JPanel btnPane = new JPanel();
		setLayout(new GridLayout(0, 1));
		
		JButton yesBtn = newSubmitBtn("Yes");
		JButton noBtn = newSubmitBtn("No");
		
		btnPane.add(yesBtn);
		btnPane.add(noBtn);
		
		return btnPane;
	}
	
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
	
	private JLabel newWinnerLbl() {
		JLabel winnerLbl = new JLabel("Congrats " + winner + "! Would you like to save your score?");
		winnerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return winnerLbl;
	}

}
