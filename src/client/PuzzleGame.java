package client;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * @author Scott Stebbings
 */
public class PuzzleGame extends JPanel {

	private static final long serialVersionUID = 1L;

	public PuzzleGame() {
		setBackground(Color.LIGHT_GRAY);
		setSize(400, 400); // Size might be set in the main frame
		add(new PuzzlePanel());
	}
}
