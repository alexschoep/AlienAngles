package game;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel{
	Protractor protractor;
	Game game;
	private boolean protractorVisible = false;
	
	public Display(Game game) {
		this.game = game;
		protractor = new Protractor();
	}
	
	public void protractorVisible(boolean visible) {
		protractorVisible = visible;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		if (protractorVisible) {
			protractor.draw(g);
		}
		game.getLevels().get(game.getControlPanel().getProgress()).getAlien().draw(g);
		game.getLevels().get(game.getControlPanel().getProgress()).getMissile().draw(g);

	}
}
