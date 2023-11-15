package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JPanel gameSelectPane = newGameSelectPane();
		contentPane.add(gameSelectPane, BorderLayout.CENTER);
		
		JLabel placeHolderLbl = newPlaceholderLbl();
		contentPane.add(placeHolderLbl, BorderLayout.SOUTH);
	}
	
	private JLabel newTitleLbl() {
		JLabel titleLbl = new JLabel("Board Games");
		titleLbl.setFont(new Font("Serif", Font.PLAIN, 18));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return titleLbl;
	}

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

	private JButton newPuzzleBtn() {
		JButton puzzleBtn = new JButton();
		return puzzleBtn;
	}

	private JButton newTicTacToeBtn() {
		JButton ticTacToeBtn = new JButton();
		return ticTacToeBtn;
	}

	private JLabel newPlaceholderLbl() {
		JLabel placeholderLbl = new JLabel();
		return placeholderLbl;
	}

}
