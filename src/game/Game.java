package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame{
	public static final int tolerance = 5;
	public static final int gameRadius = 300;
	public static final int numLevels = 5;
	public static Game instance;
	private ArrayList<Level> levels;
	private Quiz quiz;
	private ControlPanel controlPanel;
	
	public static Game getInstance() {
		return instance;
	}
	
	public Game() {
		newBackground();
		setSize(1000, 1000);
		setTitle("Alien Angles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		controlPanel = new ControlPanel();
		levels = new ArrayList<Level>();
		for (int i = 0; i < numLevels; i++) {
		levels.add(new Level(this));
		}
		
		quiz = new Quiz(this);
		//game constructor
	}
	
	public void newBackground() {
		BufferedImage image = null;
		Random rand = new Random();
		String imageString;
		int randInt = Math.abs(rand.nextInt()% 5) + 1;
		System.out.println(randInt);

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
	
	public void draw() {
		//calls draw for each level
		//calls draw for control panel
		//draws background
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		repaint();
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
	
	public static void main(String[] args) {
		Game game = new Game();
	}
}
