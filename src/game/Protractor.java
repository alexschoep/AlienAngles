package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Protractor{
	
	private String imageString;
	private BufferedImage image = null;
	public Protractor() {
		imageString = "/protractor.png";
		
		try {
			image = ImageIO.read(getClass().getResource(imageString));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	
	public void draw(Graphics g) {
		g.drawImage(image, 150, 200, null); 
	}
}