package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Max Humpherys
 */
public class TicTacToeClient extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Menu for TicTacToe Game options
	 */
	public TicTacToeClient() {
		setLayout(new BorderLayout());
		
		JPanel menuPane = new JPanel();
		menuPane.setBackground(Color.LIGHT_GRAY);
		menuPane.setLayout(new GridLayout(0, 1, 10, 10));
		
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
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 17));
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
		playAiBtn.setFont(new Font("Monospaced", Font.BOLD, 17));
		playAiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel inputPlayer = new PlayerInput(true);
                removeAll();
                add(inputPlayer, BorderLayout.CENTER);
                revalidate();
                repaint();
			}
		});
		return playAiBtn;
	}
	
	/**
	 * Button to view scores
	 * @return JButton
	 */
	private JButton newScoresBtn() {
		JButton scoresBtn = new JButton("Scores");
		scoresBtn.setFont(new Font("Monospaced", Font.BOLD, 17));
		scoresBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel scoresScreen = new DisplayLeaderboard();
                removeAll();
                add(scoresScreen, BorderLayout.CENTER);
                revalidate();
                repaint();
			}
		});
		return scoresBtn;
	}

	/**
	 * Image for Tic Tac Toe
	 * @return JLabel
	 */
	private JLabel newGameIcon() {
		JLabel gameIcon = new JLabel();
		gameIcon.setOpaque(true);
		gameIcon.setBackground(Color.LIGHT_GRAY);
		gameIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = new ImageIcon(getClass().getResource("/client/images/tic-tac-toe.png"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(150, 128, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		gameIcon.setIcon(image);
		return gameIcon;
	}

}
