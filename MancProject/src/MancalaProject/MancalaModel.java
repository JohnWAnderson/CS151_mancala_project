package MancalaProject;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class MancalaModel 
{
	public ArrayList<Pit> pits;
	private Borad style;
	private ArrayList<ChangeListener> Listeners;
	public MancalaModel()
	{
		pits = new ArrayList<Pit>();
		Listeners = new ArrayList<ChangeListener>();
	}
	public void setStyle(Borad style) {
		this.style = style;

	}
	public Borad getStyle() {
		return style;
	}
	public void setStones(int number)
	{
		for(Pit p : pits)
		{
			p.addStones(number);
		}
	}
	/**public void clearStones()
	{
		needs to clear the cliped pit stones
	}*/
	public void addChangeListener(ChangeListener listener)
	{
		Listeners.add(listener);
	}
	public ArrayList<Pit> getPits()
	{
		return pits;
	}
	public void addPit(Pit temp)
	{
		pits.add(temp);
	}
}
