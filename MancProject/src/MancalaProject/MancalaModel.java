package MancalaProject;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel 
{
	public ArrayList<Pit> pits;
	private Borad style;
	private ArrayList<ChangeListener> listeners;
	public MancalaModel()
	{
		pits = new ArrayList<Pit>();
		listeners = new ArrayList<ChangeListener>();
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
	
	public void playerMove(int selectedPit, int player)
	{
		boolean toAccessBigPit; // Checks if Big Pit will be accessed depending on the selected pit and # of stones in the selected pit.
		int numPitsToAccess;
		int total = getStonesPit(selectedPit);
		if(player == 0 && (selectedPit >= 0 && selectedPit <=5)) // Checks if selected pit is in the 1st row of center pits
		{
			numPitsToAccess = selectedPit - total;
			if(numPitsToAccess < 0) { toAccessBigPit = true; } // toAccessBigPit is true if Big Pit when # of pits accessed surpasses the player's Big pit.
	 
			for(int i = total; total > 0; i--)
			{
	 
			}
		}
		else if(player == 0 && (selectedPit >= 6 && selectedPit <= 11)) // Checks if selected pit is in the 2nd row of center pits
		{
	 
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
