package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Alien{
	//set a hitDistance as a form of tolerance
	public static final double hitDistance = Game.gameRadius*Math.sin(Math.toRadians(Game.tolerance));
	private double xPos;
	private double yPos;
	private boolean alive = true;
	private String imageString;
	private BufferedImage image = null;
	
	public Alien(int angle) {
		//points to our image for our alien
		imageString = "/alien.png";
		
		try {
			image = ImageIO.read(getClass().getResource(imageString));
		} catch (IOException e1) {
			//print the error
			e1.printStackTrace();
		}
		//this updates the position to be based on radial geometry
		this.xPos = Game.gameRadius*Math.cos(Math.toRadians((double) angle)) + Game.gameRadius;
		this.yPos = Game.gameRadius*Math.sin(Math.toRadians((double) angle));
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, ((int)xPos + 110), (900 - (int)yPos - 500), null);
	}
	
	public double getXPos() {
		return xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public boolean checkHit(double x, double y) {
		//return (Math.abs(xPos - x) < hitDistance) && (Math.abs(yPos - y) < hitDistance);
		return Math.sqrt((Math.abs(xPos - x)*Math.abs(xPos - x)) + (Math.abs(yPos - y)*Math.abs(yPos - y))) < hitDistance;
	}
	
	protected void killAlien() {
		alive = false;
	}
	
//	public void paintComponent(Graphics g) {
//		int x = (int) xPos;
//		int y = (int) yPos;
//		g.drawImage(image, 50, 50, null); 
//	}
}
