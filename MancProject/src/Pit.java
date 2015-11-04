import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Pit extends JComponent
{
	private static final long serialVersionUID = 4542933551792089953L;
	Pit()
	{
		
	} 
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		Graphics g2 = (Graphics2D) g;
		g2.drawOval(0, 0, (int)(getWidth()* .8) , (int)(getHeight()/2));
		
	}
}
