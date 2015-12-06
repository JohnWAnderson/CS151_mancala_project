package MancalaProject;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
/**
 * This class is the class that is the icons for the bigpit
 * It holds the player and the amount of stoens.
 * It gets the size needed and also the style that the user inputs using onf of the board types
 * @author John Anderson
 * @author Christopher Dal Porto
 * @author Andy Nguyen
 * @version 1.0
 */
public class BigPit implements Icon
{
	private int player;
	private Borad style;
	private int size;
	private int stones;
	/**
	 * makes the big pit form the input
	 * @param size size of the pit
	 * @param style the style that will be used for the pit
	 * @param stones the amount of stones in the pit
	 * @param Player what player pit is controled
	 */
	public BigPit(int size , Borad style, int stones, int Player)
	{
		this.size = size;
		this.style = style;
		this.stones = stones;
		this.player = Player;
	}
	public BigPit() {
		
	}
	/**
	 * Cloning method making copy of elements to be stored in tempList in model
	 * @return bigPit object created
	 */
	public BigPit clone() {
		BigPit bp = new BigPit();
		bp.player = player;
		bp.style = style;
		bp.size = size;
		bp.stones = stones;
		return bp;
	}
	/**
	 *  checks to see if player 1's turn
	 * @return true||false  true if player 1's turn else false
	 */
	public boolean player1()
	{
		return player == 1;
	}
	/**
	 * adds more stones into the bigpit
	 * @param stones the amount of stones to add into the pit
	 */
	public void addStones(int stones)
	{
		this.stones += stones;
	}
	/**
	 * returns the amount of stones in the pit currently
	 * @return stones  the amount of stones in the pit
	 */
	public int getstones()
	{
		return stones;
	}
	/**
	 *  returns the pits height
	 * @return size the height of the bigpit
	 */
	@Override
	public int getIconHeight() {
		return size;
	}
	/**
	 * returns the width of the bigpit
	 * @return size/2 the width of the bigpit
	 */
	@Override
	public int getIconWidth() {
		return size/2;
	}
	/**
	 * draws the pit according the the style requested by user and uses the stratagy borad to draw
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		style.drawbigpits(g2, x, y, stones, size);
	}
}