package game;

import java.awt.Graphics;

public class Alien {
	public static final double hitDistance = Game.gameRadius*Math.sin(Math.toRadians(Game.tolerance));
	private double xPos;
	private double yPos;
	private boolean alive = true;
	
	public Alien(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
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

	public void draw(Graphics g) {
	}
}
