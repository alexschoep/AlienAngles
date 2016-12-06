package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Alien{
	
	public static final double hitDistance = Game.gameRadius*Math.sin(Math.toRadians(Game.tolerance));
	private double xPos;
	private double yPos;
	private boolean alive = true;
	private String imageString;
	private BufferedImage image = null;
	
	public Alien(int angle) {
		imageString = "/alien.png";
		
		try {
			image = ImageIO.read(getClass().getResource(imageString));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.xPos = Game.gameRadius*Math.cos(Math.toRadians((double) angle)) + Game.gameRadius;
		this.yPos = Game.gameRadius*Math.sin(Math.toRadians((double) angle));
	}
	
	public void draw(Graphics g) {
		System.out.println("dfhcwghw");
		g.drawImage(image, (int) xPos, (int) yPos, null);
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
	
	public void paintComponent(Graphics g) {
		int x = (int) xPos;
		int y = (int) yPos;
		g.drawImage(image, 50, 50, null); 
	}
}
