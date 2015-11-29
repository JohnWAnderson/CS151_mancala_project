package MancalaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class classic implements Borad
{
	private Stone Stone;
	@Override
	public void drawbigpits(Graphics2D g2, int x, int y, int stones, int size) {
		 Ellipse2D.Double pit = new Ellipse2D.Double(x,y,size/2,size);
		 g2.draw(pit);
			for(int i = 0; i < stones; i ++)
			 {
				 Ellipse2D.Double temp = new Ellipse2D.Double(stonespot(), stonespot(), 10, 10);
				 g2.setColor(Stone.stonecolor());
				 g2.fill(temp);
			 }
		String temp = String.valueOf(stones);
		g2.setColor(Color.BLACK);
		g2.drawString(temp, x, y);
	}

	@Override
	public void drawpits(Graphics2D g2, int x, int y, int stones, int size) {
		 Ellipse2D.Double pit = new Ellipse2D.Double(x,y,size,size);
		 g2.draw(pit);
		for(int i = 0; i < stones; i ++)
		 {
			 Ellipse2D.Double temp = new Ellipse2D.Double(stonespot(), stonespot(), 10, 10);
			 g2.setColor(Stone.stonecolor());
			 g2.fill(temp);
		 }
			String temp = String.valueOf(stones);
			g2.setColor(Color.BLACK);
			g2.drawString(temp, x, y);
	}

	@Override
	public int stonespot() 
	{
		Random random = new Random();
		int temp = random.nextInt(((50-25) +1) +0);
		return temp;
	}

	



}
