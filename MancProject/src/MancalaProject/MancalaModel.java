package MancalaProject;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {
private ArrayList<Integer> stones;
ArrayList<ChangeListener> listeners;

public MancalaModel() {
	stones  = new ArrayList<>();
	listeners = new ArrayList<>();
}
public void attach(ChangeListener c) {
	this.listeners.add(c);
}
/**
 * boolean player1 true=player1 false=player2
 * stones[0] = left bigpit(player1)
 * stones[7]= right bigpit(player2)
 * @param selectedPit
 * @param player
 */
public void update(int selectedPit, boolean player1) {
	
	for (int i = 0; i < stones.get(selectedPit); i++) {
		stones.set(Integer.valueOf(selectedPit+i), stones.get(selectedPit + i) + stones.get(selectedPit-i));
	}
	for (ChangeListener l : this.listeners) {
		l.stateChanged(new ChangeEvent(this));
	}
}
}