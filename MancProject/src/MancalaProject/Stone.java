package MancalaProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.Icon;

public class Stone implements Icon {
	private int x;
	private int y;
	private final int size = 10;
	public Stone(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Color stonecolor() {
		Random color = new Random();
		int x = color.nextInt();
		int y = color.nextInt();
		int z = color.nextInt();
		Color temp = new Color(x,y,z);
		return temp;
	}

	@Override
	public int getIconHeight() {
		return size;
	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		Graphics2D g2 = (Graphics2D)g;
		Ellipse2D.Double thestone = new Ellipse2D.Double(this.x,this.y,size/2,size);
		g2.setColor(stonecolor());
		g2.fill(thestone);
	}
}
