package MancalaProject;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
public class Pit implements Icon
{
	private int size;
	private Borad style;
	private int stones;
	public Pit(int size, Borad style, int stones)
	{
		this.size = size;
		this.style = style;
		this.stones = stones;
	}
	public void addStones(int stones)
	{
		this.stones += stones;
	}
	public int getstones()
	{
		return stones;
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
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		style.drawpits(g2, x, y, stones, size);
	}
}
