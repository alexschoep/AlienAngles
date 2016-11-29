package game;

public class Missile {
	private double xPos;
	private double yPos;
	private boolean missileHit;
	
	public Missile() {
		xPos = 0;
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
	
	public void draw() {
	}
}
