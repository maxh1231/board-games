package client;

import javax.swing.JPanel;

public class PuzzleGame extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PuzzleGame() {
        // setSize(400, 400); // Size might be set in the main frame
        add(new PuzzlePanel());
    }

    public static void main(String[] args) {
        PuzzleGame game = new PuzzleGame();
        game.setVisible(true);
    }
}
