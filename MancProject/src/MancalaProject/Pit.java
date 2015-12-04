	package MancalaProject;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import javax.swing.JComponent;
public class Pit implements Icon, MouseListener // implements mouseListener now
{
	private int size;
	private Borad style;
	private int stones;
	private int pitId;
	private MancalaModel model;
	
	public Pit(int size, Borad style, int stones, int id, MancalaModel mod) // constructor takes idNum for pit number and dataModel
	{
		this.size = size;
		this.style = style;
		this.stones = stones;
		this.pitId = id;
		this.model = mod;
	}
	public int getId() {
		return this.pitId;
	}
	public void addStones(int stones)
	{
		this.stones += stones;
	}
	public int getstones()
	{
		return stones;
	}
	public void Clear()
	{
		stones = 0;
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
	/**
	 * use mouse clicked
	 * @param arg0
	 */
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// this.model.clearPit(this.getId());   call
		System.out.println("Pit " + String.valueOf(this.getId()) + " has been pressed.");
		this.model.playerMove(this.getId());
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
	/**
	 * MousePressed method
	 * currently, it prints to console which pit was pressed and it starts andy's playerMove function
	 * The playerMove function in its current state causes a loop or error somewhere that seems to make
	 * the gui "hang," so I commented out the decision making code of the method for now until fixed
	 * @param arg0
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
	//	System.out.println("Pit " + String.valueOf(this.getId()) + " has been pressed.");
		//this.model.playerMove(this.getId());
		//this.model.clearPit(this.getId());
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
