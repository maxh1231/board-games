package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * @author
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
	 * 
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
	 * 
	 * @param btnText
	 * @return JButton
	 */
	private JButton newSubmitBtn(String btnText) {
		JButton submitBtn = new JButton(btnText);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (submitBtn.getText().equals("Yes")) {
					// save to file
					saveScore(winner);
				} else {
					System.out.println("No");
					// home screen
				}
				
				TicTacToeClient newGame = new TicTacToeClient();
				removeAll();
				add(newGame, BorderLayout.CENTER);
                revalidate();
                repaint();
			}
		});
		return submitBtn;
	}

	/**
	 * Notifies which player that won, using the winner field
	 * 
	 * @return JLabel
	 */
	private JLabel newWinnerLbl() {
		JLabel winnerLbl = new JLabel("Congrats " + winner + "! Would you like to save your score?");
		winnerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return winnerLbl;
	}

	/**
	 * Saves a new line in leader board file or increments an existing name's number of wins
	 * @param winner
	 */
	private void saveScore(String winner) {
		boolean hasMatch = false;
		// Specify the file name, be wary of absolute path
		String fileName = "C:\\Users\\maxhu\\Desktop\\School\\fall2023\\csis1410\\BoardGames\\src\\client\\tttLeaderboard.txt";

		// Read all lines from the file into a list
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			String name = line.substring(0, line.indexOf(" "));
			int wins = Character.getNumericValue(line.charAt(line.length() - 1));
			
			if (winner.toLowerCase().equals(name.toLowerCase())) {
				System.out.println("true");
				lines.set(i, name + " " + Integer.toString(wins + 1));
				hasMatch = true;
			}
		}
		
		if (!hasMatch) {
			lines.add(winner + " 1");
		}		
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
