package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

/**
 * @author Max Humpherys
 */
public class DisplayLeaderboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DisplayLeaderboard() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());

		JPanel menuPane = new JPanel();
		menuPane.setBackground(Color.LIGHT_GRAY);
		menuPane.setLayout(new GridLayout(0, 1, 10, 10));

		JLabel headerLbl = newHeaderLbl();
		add(headerLbl, BorderLayout.NORTH);

		JPanel leaderPane = newLeaderPanel();
		add(leaderPane, BorderLayout.CENTER);

		JButton playBtn = newPlayBtn();
		JButton playAiBtn = newPlayAIBtn();
		JButton scoresBtn = newHomeBtn();
		menuPane.add(playBtn);
		menuPane.add(playAiBtn);
		menuPane.add(scoresBtn);
		add(menuPane, BorderLayout.WEST);
	}

	/**
	 * Screen Header Label
	 * 
	 * @return JLabel
	 */
	private JLabel newHeaderLbl() {
		// Find better way to align label. Perhaps placing it in BorderLayout.CENTER
		JLabel header = new JLabel("      Leaderboard");
		header.setFont(new Font("Monospaced", Font.BOLD, 32));
		header.setHorizontalAlignment(SwingConstants.CENTER);

		return header;
	}

	/**
	 * Player vs Player button
	 * 
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
	 * 
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
	 * Button to return home
	 * 
	 * @return JButton
	 */
	private JButton newHomeBtn() {
		JButton scoresBtn = new JButton("Home");
		scoresBtn.setFont(new Font("Monospaced", Font.BOLD, 17));
		scoresBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel tic = new TicTacToeClient();
				removeAll();
				add(tic, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		return scoresBtn;
	}

	/**
	 * Reads from leaderboard file, creating labels for each line
	 * 
	 * @return JLabel
	 */
	private JPanel newLeaderPanel() {
		JPanel newPanel = new JPanel();
		newPanel.setBackground(Color.LIGHT_GRAY);

		String fileName = "C:\\Users\\maxhu\\Desktop\\School\\fall2023\\csis1410\\BoardGames\\src\\client\\tttLeaderboard.txt";

		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		newPanel.setLayout(new GridLayout(lines.size(), 1));

		Collections.sort(lines, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int num1 = Integer.parseInt(s1.split(" ")[1]);
				int num2 = Integer.parseInt(s2.split(" ")[1]);

				return Integer.compare(num2, num1);
			}
		});

		for (String s : lines) {
			String name = s.substring(0, s.indexOf(" "));
			int wins = Character.getNumericValue(s.charAt(s.length() - 1));

			JLabel lbl = newLblCol(name + "     |      " + wins);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			newPanel.add(lbl);
		}

		return newPanel;
	}

	/**
	 * Label for each Leaderboard line
	 * 
	 * @param text
	 * @return JLabel
	 */
	private JLabel newLblCol(String text) {
		JLabel newCol = new JLabel(text);
		newCol.setFont(new Font("Monospaced", Font.BOLD, 17));

		return newCol;
	}

}
