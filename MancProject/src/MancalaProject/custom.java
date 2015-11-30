package MancalaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class custom implements Borad
{
	private Stone Stone;
	@Override
	public void drawbigpits(Graphics2D g2, int x, int y, int stones, int size)  {
		Rectangle2D.Double pit = new Rectangle2D.Double(0, 0, size/2 -5, size - 5);
		 g2.draw(pit);
			for(int i = 0; i < stones; i ++)
			 {
				 Ellipse2D.Double temp = new Ellipse2D.Double(stonespot(), stonespot(), 10, 10);
				 g2.setColor(Stone.stonecolor());
				 g2.fill(temp);
			 }
		String temp = String.valueOf(stones);
		g2.setColor(Color.BLACK);
		g2.drawString(temp, x+10, y+12);
	}

	@Override
	public void drawpits(Graphics2D g2, int x, int y, int stones, int size) {
		Rectangle2D.Double pit = new Rectangle2D.Double(0, 0, size, size);
		 g2.draw(pit);
			for(int i = 0; i < stones; i ++)
			 {
				 Ellipse2D.Double temp = new Ellipse2D.Double(stonespot(), stonespot(), 10, 10);
				 g2.setColor(Stone.stonecolor());
				 g2.fill(temp);
			 }
		String temp = String.valueOf(stones);
		g2.setColor(Color.BLACK);
		g2.drawString(temp, x+5, y-5);
	}

	@Override
	public int stonespot() 
	{
		Random random = new Random();
		int temp = random.nextInt(((50-25) +1) +0);
		return temp;
	}
}
