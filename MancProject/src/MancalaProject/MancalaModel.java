package MancalaProject;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel 
{
	private ArrayList<Pit> pits;   
	private ArrayList<Pit> tempPits;
	private ArrayList<BigPit> tempBigPits;
	private ArrayList<BigPit> bigPits;  // 0  is player 1    1 is player 2
	private Borad style;
	private ArrayList<ChangeListener> listeners;
	private int curPlayer; //variable to keep track of current player, see constructor for value meanings
	private int undo;
	
	public MancalaModel()
	{
		this.curPlayer = 1; // 1 for player 1, -1 for player 2
		pits = new ArrayList<Pit>();
		bigPits = new ArrayList<BigPit>();
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
		bigPits.add(bp);
	}
	public int getPlayerPitStones(int i)
	{
		return bigPits.get(i).getstones();
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
	public void saveUndo()
	{
		tempPits = pits;
		tempBigPits = bigPits;
	}
	public void undocalled()
	{
		pits = tempPits;
		bigPits = tempBigPits;
	}
	
	public void playerMove(int thePit)
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
		
		int selectedPit = thePit;
		int total = getStonesPit(selectedPit);
		int numPitsToAccess;
		int destinationPit;
		boolean isEmpty;
		if(this.curPlayer == 1)
		{
			if(selectedPit >= 0 && selectedPit <= 5)
			{
				
			}
			else if(selectedPit >= 6 && selectedPit <= 11)
			{
				
			}
		}
		else if(this.curPlayer == -1)
		{
			if(selectedPit >= 0 && selectedPit <= 5)
			{
				//its.get(index).isEmpty();
			}
			else if(selectedPit >= 6 && selectedPit <= 11) // Checks if selected Pit is on player B's (-1) side
			{
				// selectedPit is cleared in mouseListener;
				numPitsToAccess = selectedPit + total;
				if(numPitsToAccess > 11)
				{
					while(total > 0)
					{
						pits.get(selectedPit+1).addStones(1);
						total--;
						selectedPit++;
					}
					/*
					for(int p = 1; p <= total; p++)
					{
						int temp = p + selectedPit;
						pits.get(p + selectedPit)
					}
					*/
					bigPits.get(1).addStones(1);
				}
				else
				{
					
				}
			}
		}
		
		
		this.curPlayer = (this.curPlayer * -1); // alternate current player each time to negative and nonnegative num
		
		for (ChangeListener l : this.listeners) { // notify listeners (view)
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	public static int reachPit(int selectedPit)
	{
		return selectedPit;
		
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