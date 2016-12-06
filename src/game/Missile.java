package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Missile{
	private double xPos;
	private double yPos;
	private boolean missileHit;
	private String imageString;
	private BufferedImage image = null;
	
	public Missile() {
		super();
		imageString = "/missile.png";
		
		try {
			image = ImageIO.read(getClass().getResource(imageString));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		xPos = Game.gameRadius;
		yPos = 0;
	}
	
	public double getXPos() {
		return xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
	
	protected void changePosition(int angle) {
		xPos += Math.cos(Math.toRadians(angle));
		yPos += Math.sin(Math.toRadians(angle));
	}
	
	public boolean missileHit() {
		return missileHit;
	}
	
	protected void detonate() {
		missileHit = true;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, ((int)xPos + 130), (900 - (int)yPos - 450), null); 
	}
}
