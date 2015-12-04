package MancalaProject;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel 
{
	private ArrayList<Pit> pits;   
	private ArrayList<Pit> temppits;
	private ArrayList<BigPit> tempbigpits;
	private ArrayList<BigPit> bigpits;  // 0  is player 1    1 is player 2
	private Borad style;
	private ArrayList<ChangeListener> listeners;
	private int curPlayer; //variable to keep track of current player, see constructor for value meanings
	private int undo;
	
	public MancalaModel()
	{
		this.curPlayer = 1; // 1 for player 1, -1 for player 2
		pits = new ArrayList<Pit>();
		bigpits = new ArrayList<BigPit>();
		listeners = new ArrayList<ChangeListener>();	
		undo = 3;
	}
	public int getPlayer() {
		return this.curPlayer;
	}
	public boolean player1Turn()
	{
		return this.curPlayer == 1;
	}
	public int pitsSize()
	{
		return pits.size();
	}
	public void setUndo()
	{
		this.undo = 3;
	}
	public void addBigPit(BigPit bp)
	{
		bigpits.add(bp);
	}
	public int getPlayerPitStones(int i)
	{
		return bigpits.get(i).getstones();
	}
	public int Undo()
	{
		this.undo *= -1;
		return this.undo;
	}
	public boolean checkUndo()
	{
		return (this.undo > 0);
	}
	public void setPlayer(int play) {
		this.curPlayer = play;
	}
	
	public void setStyle(Borad style) {
		this.style = style;
	}
	public Borad getStyle() {
		return style;
	}
	public int getStonesPit(int i)
	{
		return pits.get(i).getstones();
	}
	public void setStones(int number)
	{
		for(Pit p : pits)
		{
			p.addStones(number);
		}
		
		for (ChangeListener l : this.listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	public void clearPit(int i)
	{
		Pit temp = pits.get(i);
		temp.Clear();
	}
	public void undocalled()
	{
		pits = temppits;
		bigpits = tempbigpits;
	}
	
	public void playerMove(int selectedPit)
	{
		/* It looks like this method checks if access to bigPits are allowed, but it doesn't check which big pit to access
		 *  It has to know which big pit to  skip
		 */
		/*
		 * temppits = pits;
		 * tempbigpits = bigpits;
		boolean toAccessBigPit; // Checks if Big Pit will be accessed depending on the selected pit and # of stones in the selected pit.
		int numPitsToAccess;
		int total = getStonesPit(selectedPit);
		if(this.curPlayer == 1 && (selectedPit >= 0 && selectedPit <=5)) // Checks if selected pit is in the 1st row of center pits
		{
			numPitsToAccess = selectedPit - total;
			if(numPitsToAccess < 0) { toAccessBigPit = true; } // toAccessBigPit is true if Big Pit when # of pits accessed surpasses the player's Big pit.
	 
			for(int i = total; total > 0; i--)
			{
	 				
			}
		}
		else if(this.curPlayer == 1 && (selectedPit >= 6 && selectedPit <= 11)) // Checks if selected pit is in the 2nd row of center pits
		{
	 
		} */
		this.curPlayer = (this.curPlayer * -1); // alternate current player each time to negative and nonnegative num
		
		for (ChangeListener l : this.listeners) { // notify listeners (view)
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	public void attach(ChangeListener listener) {
		this.listeners.add(listener);

	}
	public void addChangeListener(ChangeListener listener)
	{
		listeners.add(listener);

	}
	public ArrayList<Pit> getPits()
	{
		return pits;
	}
	public void addPit(Pit temp)
	{
		pits.add(temp);
		
		for (ChangeListener l : this.listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
}
