package client;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Sahak I. 
 */
public class PuzzleInput extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel UserPane;
	private JTextField UserName;
	private JTextField textUsername;
	
	
	/**
	 * Create the panel.
	 */
	public PuzzleInput() {
		setLayout(new BorderLayout());
		
		JPanel PuzzleInputPane = new JPanel();
		
		add(PuzzleInputPane, BorderLayout.CENTER);
		
		JPanel pane = new JPanel();
		PuzzleInputPane.add(pane);
		
		JLabel lblUsername = new JLabel("Username:");
		pane.add(lblUsername);
		
		textUsername = new JTextField();
		pane.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel PuzzlePanel = new PuzzlePanel();
            removeAll();
            add(PuzzlePanel, BorderLayout.CENTER);
            repaint();
		}
	});
		PuzzleInputPane.add(btnSubmit);
	}
}
