package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JFrame{
	public static final int tolerance = 5;
	public static final int gameRadius = 300;
	public static final int numLevels = 5;
	public static Game instance;
	private ArrayList<Level> levels;
	private Quiz quiz;
	private ControlPanel controlPanel;
	private Protractor protractor;
	private Display display;
	
	public static Game getInstance() {
		return instance;
	}
	
	public Game() {
		display = new Display(this);
		
		newBackground();
		setSize(900, 900);
		setTitle("Alien Angles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		levels = new ArrayList<Level>();
		controlPanel = new ControlPanel(this);
		
		for (int i = 0; i < numLevels; i++) {
			levels.add(new Level(this, i+1));
		}
		
		quiz = new Quiz(this);
		protractor = new Protractor();
		
		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(display, BorderLayout.CENTER);
		
		setVisible(true);
		repaint();
	}
	
	public void newBackground() {
		BufferedImage image = null;
		Random rand = new Random();
		String imageString;
		int randInt = Math.abs(rand.nextInt()% 5) + 1;
		switch (randInt) {
			case 1:  imageString = "/levelOne.jpg";
				break;
			case 2:  imageString = "/levelTwo.jpg";
				break;
			case 3:  imageString = "/levelThree.jpg";
				break;
			case 4:  imageString = "/levelFour.jpg";
				break;
			case 5:  imageString = "/levelFive.jpg";
				break;
			default: imageString = "/levelOne.jpg";
				break;
		}
		try {
			image = ImageIO.read(getClass().getResource(imageString));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel background = new JLabel(new ImageIcon(image));
		background.setLayout(new BorderLayout());
		background.setOpaque(true);
		this.setContentPane(background);
		//gives a new background to the panel
	}
	
	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	public ControlPanel getControlPanel() {
		return controlPanel;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void quizSetVisible(boolean visible) {
		quiz.setVisible(visible);
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
	}
}
