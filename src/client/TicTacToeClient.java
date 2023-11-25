package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author maxhu
 */
public class TicTacToeClient extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Menu for TicTacToe Game options
	 */
	public TicTacToeClient() {
		setLayout(new BorderLayout());
		
		JPanel menuPane = new JPanel();
		menuPane.setLayout(new GridLayout(0, 1));
		
		JLabel gameIcon = newGameIcon();
		add(gameIcon, BorderLayout.CENTER);
		
		
		JButton playBtn = newPlayBtn();
		JButton playAiBtn = newPlayAIBtn();
		JButton scoresBtn = newScoresBtn();
		menuPane.add(playBtn);
		menuPane.add(playAiBtn);
		menuPane.add(scoresBtn);
		add(menuPane, BorderLayout.WEST);
	}

	/**
	 * Button for player vs player
	 * @return JButton
	 */
	private JButton newPlayBtn() {
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel inputPlayers = new PlayerInput();
                removeAll();
                add(inputPlayers, BorderLayout.CENTER);
                revalidate();
                repaint();
			}
		});
		return btnNewButton;
	}
	
	/**
	 * Button for player vs AI
	 * @return JButton
	 */
	private JButton newPlayAIBtn() {
		JButton playAiBtn = new JButton("Play (AI)");
		return playAiBtn;
	}
	
	/**
	 * Button to view scores
	 * @return JButton
	 */
	private JButton newScoresBtn() {
		JButton scoresBtn = new JButton("Scores");
		return scoresBtn;
	}

	/**
	 * Image for Tic Tac Toe
	 * @return JLabel
	 */
	private JLabel newGameIcon() {
		JLabel gameIcon = new JLabel();
		ImageIcon image = new ImageIcon(getClass().getResource("/client/images/tic-tac-toe.png"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(150, 128, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		gameIcon.setIcon(image);
		return gameIcon;
	}

}
