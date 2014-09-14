import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	public int wrongGuesses;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		g2d.drawRect(50, 50, 15, 400);
		g2d.drawRect(50, 50, 200, 15);
		g2d.drawRect(150, 50, 15, 50);
		g2d.drawOval(135, 100, 45, 45);
		g2d.drawOval(142, 145, 30, 150);
		g2d.drawLine(145, 165, 120, 220);
		g2d.setColor(Color.red);
		g2d.fillRect(50, 50, 15, 400);
		g2d.fillRect(50, 50, 200, 15);
		g2d.fillRect(150, 50, 15, 50);
		g2d.fillOval(135, 100, 45, 45);
		g2d.fillOval(142, 145, 30, 150);
		g2d.drawString("Word goes here", 50, 500);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hangman v.1.00");
		Game game = new Game();
		
		frame.setSize(600, 600);
		frame.setLocation(700, 250);		
		frame.add(game);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
