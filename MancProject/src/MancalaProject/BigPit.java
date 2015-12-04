package MancalaProject;

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
	/*
	 * @return true if player 1
	 * integer is either 1 or -1
	 */
	public boolean player1()
	{
		return player == 1;
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
		return size/2;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		style.drawbigpits(g2, x, y, stones, size);
	}
}
