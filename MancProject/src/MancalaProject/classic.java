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
/**
 * the classic board that uses circles and has blue colors.
 * this uses the stratagy pattern form the board interface and the stratagy
 * @author John Anderson
 * @author Christopher Dalporto
 * @author Andy Nguyen
 *
 */
public class classic implements Borad
{
	/**
	 * draws the big mancala pit
	 */
	@Override
	public void drawbigpits(Graphics2D g2, int x, int y, int stones, int size) {
		 Ellipse2D.Double pit = new Ellipse2D.Double(x,y,size/2,size);
		 g2.setColor(Color.BLACK);
		 g2.fill(pit);
			for(int i = 0; i < stones; i ++)
			 {
				Ellipse2D.Double temp = new Ellipse2D.Double(bigstonesspot()+15, bigstonesspot()+60, 15, 15);
				 g2.setColor(Color.BLUE);
				 g2.fill(temp);
			 }
		String temp = String.valueOf(stones);
		g2.setColor(Color.BLACK);
		g2.drawString(temp, x, y+15);
	}
	/**
	 * draws the small pits 
	 */
	@Override
	public void drawpits(Graphics2D g2, int x, int y, int stones, int size) {
		 Ellipse2D.Double pit = new Ellipse2D.Double(x,y,size,size);
		 g2.setColor(Color.BLACK);
		 g2.fill(pit);
		for(int i = 0; i < stones; i ++)
		 {
			 Ellipse2D.Double temp = new Ellipse2D.Double(stonespot()+25, stonespot()+30, 15, 15);
			 g2.setColor(Color.BLUE);
			 g2.fill(temp);
		 }
			String temp = String.valueOf(stones);
			g2.setColor(Color.BLACK);
			g2.drawString(temp, x, y);
	}
	/**
	 * picks a random number for the spot of the stones in the pits
	 * @return temp a random number
	 */
	@Override
	public int stonespot() 
	{
		Random random = new Random();
		int temp = random.nextInt(((50-25) +1) +0);
		return temp;
	}
	/**
	 * picks a random number for the spot of the stones in the bigpits
	 * @return temp a random number
	 */
	@Override
	public int bigstonesspot() {
		Random random = new Random();
		int temp = random.nextInt(((50-0) +1) +0);
		return temp;
	}
	


}
