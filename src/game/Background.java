package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Background extends JFrame {
	public Background() {
		setTitle("Background");
	    setSize(400,400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    setLayout(new BorderLayout());
	    setContentPane(new JLabel(new ImageIcon("/images/levelOne.jpg")));
	    setLayout(new FlowLayout());
	    setVisible(true);
	   }
}

