import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Pit extends JComponent
{
	private static final long serialVersionUID = 4542933551792089953L;
	private int width;
	private int height;
	Pit(int width, int hight)
	{
		this.width = width;
		this.height = hight;
	} 
	public int getWidth()
	{
		return this.width;
	}
	public int getHight()
	{
		return this.height;
	}
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		Graphics g2 = (Graphics2D) g;
		g2.drawOval(0, 0, (int)(getWidth()) , (int)(getHeight()));
	}
}
