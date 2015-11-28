package MancalaProject;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
public class Pit implements Icon
{
	private static final long serialVersionUID = 4542933551792089953L;
	private int width;
	private int height;
	private String style;
	public Pit(int width, int height, String style)// styles
	{
		this.width = width;
		this.height = height;
		this.style = style;
	} 
	public int getWidth()
	{
		return this.width;
	}
	public int getHight()
	{
		return this.height;
	}
	@Override
	public int getIconHeight() {
		return height;
	}
	@Override
	public int getIconWidth() {
		return width;
	}	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
	    if(style == "normal")
	    {
	    	Ellipse2D.Double temp = new Ellipse2D.Double(x,y,width, height);
	    	g2.draw(temp);
	    }
	    else
	    {
	    	Rectangle2D.Double temp = new Rectangle2D.Double(x,y,width, height);
	    	g2.draw(temp);
	    }
	}
}