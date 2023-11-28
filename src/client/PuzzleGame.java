package client;

import javax.swing.JPanel;


public class PuzzleGame extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PuzzleGame() {
         //setSize(600, 600); // Size might be set in the main frame
        
    }

    public static void main(String[] args) {
        PuzzleGame game = new PuzzleGame();
        game.setVisible(true);
    }
}
