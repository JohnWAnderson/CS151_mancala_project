import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class BigPit implements Icon
{
	private int player;
	private Borad style;
	private int size;
	private int stones;
	public BigPit(int size , Borad style, int stones, int Player)
	{
		this.size = size;
		this.style = style;
		this.stones = stones;
		this.player = Player;
	}
	public boolean player1()
	{
		return player == 0;
	}
	
	@Override
	public int getIconHeight() {
		return size;
	}

	@Override
	public int getIconWidth() {
		return size/2;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		style.drawbigpits(g2, x, y, stones, size);
	}
}
