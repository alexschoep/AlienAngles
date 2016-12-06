package game;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel{
	Protractor protractor;
	Game game;
	
	public Display(Game game) {
		this.game = game;
		protractor = new Protractor();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		protractor.draw(g);
		game.getLevels().get(0).getAlien().draw(g);
		game.getLevels().get(0).getMissile().draw(g);
	}
}
