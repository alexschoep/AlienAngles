package game;

public class Level {
	public static final int tolerance = 10;
	private int levelAngle;
	private Alien alien;
	private Missile missile;
	
	public void setAngle(int angle) {
		//sets levelAngle for testing purposes
	}
	
	public Level() {
		//randomly sets an angle
		//initializes an alien and missile
	}
	
	public int getLevelAngle() {
		return levelAngle;
	}
	
	public Missile getMissile() {
		return missile;
	}
	
	public Alien getAlien() {
		return alien;
	}
	
	public void draw() {
		//draws the level
		//calls missile.draw and alien.draw
	}
	
	public void moveMissile() {
	}
}
