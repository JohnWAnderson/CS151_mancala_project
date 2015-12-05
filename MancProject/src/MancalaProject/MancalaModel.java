package MancalaProject;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * 
 * @author John Anderson
 * @author 
 * @author
 *
 */
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
	public void undoplayer()
	{
		curPlayer *= -1;
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
	public void undocalled()
	{
		pits = tempPits;
		bigPits = tempBigPits;
	}
	public void saveUndo()
	{
		tempPits = pits;
		tempBigPits = bigPits;
	}
	public void playerMove(int thePit, int theStones)
	{
		tempPits = pits;
		tempBigPits = bigPits;
		int selectedPit = thePit;
		int total = theStones;
		int pitToAccess = 0;
		int nextPit = 0;
		if(this.curPlayer == 1)
		{
			if(selectedPit >=0 && selectedPit <= 5 )
			{
				pitToAccess = selectedPit - total;
				boolean isStoneAddedInBigPit = false;
				if(pitToAccess < 0)
				{
					bigPits.get(0).addStones(1);
					while(total > 0)
					{
						if(selectedPit <= 0 && selectedPit >= 5)
							nextPit = pits.indexOf(selectedPit-1);
						else
							nextPit = 0;
						
						if(nextPit > 0 && !isStoneAddedInBigPit)
						{
							pits.get(selectedPit -1).addStones(1);
							total--;
							selectedPit--;
						}
						else if(nextPit == 0 && !isStoneAddedInBigPit)
						{
							isStoneAddedInBigPit = true;
							total--;
							selectedPit =5;
						}
						else if(isStoneAddedInBigPit)
						{
							pits.get(selectedPit).addStones(1);
							total--;
							selectedPit++;
						}
					}
				}
		
				
				
				else if(pitToAccess >= 0)
				{
					while(total > 0)
					{
						pits.get(selectedPit-1).addStones(1);
						total--;
						selectedPit--;
					}
				}
			}
		}
		else if(this.curPlayer == -1)
		{
			if(selectedPit >= 6 && selectedPit <= 11) // Checks if selected Pit is on player B's (-1) side
			{
				// selectedPit is cleared in mouseListener;
				pitToAccess = selectedPit + total;
				//System.out.println("pitToAccess: " + pitToAccess);
				boolean isStoneAddedInBigPit = false;

				if(pitToAccess > 11)
				{
					bigPits.get(1).addStones(1);
					
					
					while(total > 0)
					{
						if(selectedPit >= 6 && selectedPit <= 10)
							nextPit = pits.indexOf(selectedPit+1);
						else // else if(selectedPit == 11)
						{
							nextPit = 11;
						}	
						
						if(nextPit < 11 && !isStoneAddedInBigPit)
						{
							pits.get(selectedPit+1).addStones(1);
							total--;
							selectedPit++;
						}
						else if(nextPit == 11 && !isStoneAddedInBigPit)
						{
							isStoneAddedInBigPit = true;
							total--; // add stone into BigPit
							selectedPit = 6; // iterate selectedPit to pits index 6
						}
						else if(isStoneAddedInBigPit)
						{
							pits.get(selectedPit-1).addStones(1);
							total--;
							selectedPit--;
						}
					}
					// Check if selectedPit is Empty. If True, playerMove(selectedPit)
					//boolean isPitEmpty = pits.get(selectedPit).isEmpty();
					
					//if(!isPitEmpty) { playerMove(selectedPit, this.getStonesPit(selectedPit)); }
					
				}
				else if(pitToAccess <= 11)
				{
					while(total > 0)
					{
						pits.get(selectedPit+1).addStones(1);
						total--;
						selectedPit++;
					}
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