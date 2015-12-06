package MancalaProject;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
/**
 * uses the stratagy patteren to draw the pits
 * has all of the date information for the pit
 * @author John Anderson
 * @author Christopher Dal Porto
 * @author Andy Nguyen
 * @version 1.0
 */
public class Pit implements Icon, MouseListener
{
	private int size;
	private Borad style;
	private int stones;
	private MancalaModel model;
	private int pitId;
	/**
	 * builds the pit
	 * @param size size of the pit
	 * @param style style to use
	 * @param stones amount of stones to draw
	 * @param id of the pit
	 * @param mod the model information
	 */
	public Pit(int size, Borad style, int stones, int id, MancalaModel mod)
	{
		this.size = size;
		this.style = style;
		this.stones = stones;
		this.model = mod;
		this.pitId = id;
	}
	/**
	 * holder
	 */
	public  Pit() {
		
	}
	/**
	 * clones everything in the pit to be stored in tempPit list in model
	 * @return pit Object copy created
	 */
	public Pit clone() {
		Pit p = new Pit();
		p.size = size;
		p.style = style;
		p.stones = stones;
		p.model = model;
		p.pitId = pitId;
		return p;
		
	}
	/**
	 *  gets the id of the pit
	 * @return pitId  the id of the pit
	 */
	public int getId()
	{
		return this.pitId;
	}
	/**
	 * adds stones to the amount of stones
	 * @param stones amount to add
	 */
	public void addStones(int stones)
	{
		this.stones += stones;
	}
	/**
	 * gets the amount of stones in the pit
	 * @return stones the amount of stones in the pit
	 */
	public int getstones()
	{
		return stones;
	}
	/**
	 * sets the amount of stones equal to zero
	 */
	public void Clear()
	{
		stones = 0;
	}
	/**
	 * checks if the pits is empty 
	 * @return boolean T if empty F if not empty 
	 */
	public boolean isEmpty()
	{
		if(stones == 0) return true;
		else return false;
	}
	/**
	 * gets the height of the pit
	 * @return size the height
	 */
	@Override
	public int getIconHeight() {
		return size;
	}
	/**
	 * gets the width of the pit
	 * @return size the width
	 */
	@Override
	public int getIconWidth() {
		return size;
	}
	/**
		 * sends information to the model for what pit is clicked
		 * @param arg
		 */
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			if (!model.gameEnded()) {
			if(this.getId() <= 5 && model.player2Turn() == true)
			{
				int tempStones = this.model.getStonesPit(this.getId());
				this.model.saveUndo(); 
				this.model.playerMove(this.getId(), tempStones);
			}
			else if(this.getId() >= 6 && model.player2Turn() == false)
			{
				int tempStones = this.model.getStonesPit(this.getId());
				this.model.saveUndo();
				this.model.playerMove(this.getId(), tempStones);
			}
			} else {
				//System.out.println("Game over, player with most stones wins.");
			}
			model.checkWin();
			
		}
		@Override
	public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub	
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
		} 
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		/**
		 * paints the icon using the stratagy pattern
		 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		style.drawpits(g2, x, y, stones, size);
	}
}