package MancalaProject;

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
	/**public void clearStones()
	{
		clear the selected pits stones
	}*/
	public void attach(ChangeListener listener) {
		this.listeners.add(listener);

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
