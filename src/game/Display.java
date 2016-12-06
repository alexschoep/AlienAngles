package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel{
	
	Protractor protractor;
	Game game;
	private boolean protractorVisible = false;
	
	public Display(Game game) {
		setOpaque(true);
		this.game = game;
		protractor = new Protractor();
		setBackground(Color.BLACK); 
	}
	
	//sets protractor visible
	public void protractorVisible(boolean visible) {
		protractorVisible = visible;
	}
	
	//draw component function
	//draws protractor, alien, and missile
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		if (protractorVisible) {
			protractor.draw(g);
		}
		if (game.getControlPanel().getProgress() - 1 < Game.numLevels) {
			game.getLevels().get(game.getControlPanel().getProgress() - 1).getAlien().draw(g);
			game.getLevels().get(game.getControlPanel().getProgress() - 1).getMissile().draw(g);
		}

	}
}
