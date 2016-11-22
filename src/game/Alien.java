package game;

public class Alien {
	private double xPos;
	private double yPos;
	private boolean alive;
	
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
		return false;
	}
	
	public void killAlien() {
	}

	public void draw() {
	}
}
