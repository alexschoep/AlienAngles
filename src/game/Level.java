package game;

public class Level {
	private int levelAngle;
	private Alien alien;
	private Missile missile;
	private boolean passFail;
	private int precision;
	
	public void setAngle(int angle) {
		//sets levelAngle for testing purposes
	}
	
	public Level() {
		levelAngle = 0;
		alien = new Alien();
		missile = new Missile();
		//randomly sets an angle
		//initializes an alien and missile
	}
	
	public int getLevelAngle() {
		return levelAngle;
	}
	
	public int getPrecision() {
		return precision;
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
	
	public void moveMissile(int angle) {
		return;
	}

	public boolean isPassFail() {
		return passFail;
	}

	public void setPassFail(boolean passFail) {
		this.passFail = passFail;
	}
}
