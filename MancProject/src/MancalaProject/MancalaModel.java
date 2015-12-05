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
	private ArrayList<Pit> circle;
	private ArrayList<Pit> pits;   
	private ArrayList<Pit> tempPits;
	private ArrayList<BigPit> tempBigPits;
	private ArrayList<BigPit> bigPits;  // 0  is player 1    1 is player 2
	private Borad style;
	private ArrayList<ChangeListener> listeners;
	private int curPlayer; //variable to keep track of current player, see constructor for value meanings
	private int undo;
	private boolean gameOver = false;
	private boolean retaketurn;
	private String lastPickedRow = "top";
	
	public MancalaModel()
	{
		this.curPlayer = -1; // 1 for player 1, -1 for player 2
		pits = new ArrayList<Pit>();
		bigPits = new ArrayList<BigPit>();
		circle = new ArrayList<Pit>();
		listeners = new ArrayList<ChangeListener>();	
		undo = 3;
	}
	public int getPlayer() {
		return this.curPlayer;
	}
	public boolean retaketurn()
	{
		return this.retaketurn;
	}
	public boolean player2Turn()
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
	public void undoCalled()
	{
		undo--;
		pits = new ArrayList<Pit>();
		for (Pit p : tempPits) {
			pits.add(p.clone());
		}
		//tempPits.ensureCapacity(pits.size());
		bigPits = new ArrayList<BigPit>();
		for (BigPit bp : tempBigPits){
			bigPits.add(bp.clone());
		}
		curPlayer = curPlayer * -1;
		for(ChangeListener l : this.listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
		
	}
	
	public void saveUndo()
	{
		tempPits = new ArrayList<Pit>();
		for (Pit p : pits) {
			tempPits.add(p.clone());
		}
		//tempPits.ensureCapacity(pits.size());
		tempBigPits = new ArrayList<BigPit>();
		for (BigPit bp : bigPits){
			tempBigPits.add(bp.clone());
		}
		//tempBigPits.ensureCapacity(bigPits.size());
		//tempPits.addAll(pits);
		//tempBigPits.addAll(bigPits);
		//System.arraycopy(pits, 0, tempPits, 0, pits.size()-1);
		//System.arraycopy(bigPits, 0, tempBigPits, 0, bigPits.size()-1);
		/*
		tempPits = new ArrayList<Pit>();
		tempBigPits = new ArrayList<BigPit>();
		for (Pit p : pits) {
			tempPits.add(p);
		}
		for(BigPit b : bigPits) {
			tempBigPits.add(b);
		} */
	}
	public void circleArray()
	{
		circle = new ArrayList<Pit>();
		circle.add(pits.get(5)); //0
		circle.add(pits.get(4));//1
		circle.add(pits.get(3));//2
		circle.add(pits.get(2));//3
		circle.add(pits.get(1));//4
		circle.add(pits.get(0));//5
		circle.add(pits.get(6));//6
		circle.add(pits.get(7));//7
		circle.add(pits.get(8));//8
		circle.add(pits.get(9));//9
		circle.add(pits.get(10));//10
		circle.add(pits.get(11));//11
	}
	public String getLastMove() {
		return this.lastPickedRow;
	}
	public void playerMove(int thePit, int theStones)
	{
		retaketurn = false;
		if (thePit >= 0 && thePit <= 5) {
			if (this.lastPickedRow.equals("bot"))
				this.setUndo();
			this.lastPickedRow = "top"; 
			}
		else if (thePit >= 6 && thePit <= 11) {
			if (this.lastPickedRow.equals("top"))
				this.setUndo();
			this.lastPickedRow = "bot";
		}
			
		Boolean check = true;
		circleArray();
		int pitToClear = thePit;
		int selectedPit = thePit;
		int totalStones = getStonesPit(selectedPit);
		pits.get(pitToClear).Clear();
		if(selectedPit <= 5)
		{
			if( selectedPit == 5)
				selectedPit =0;
			else if(selectedPit==4)
				selectedPit =1;
			else if(selectedPit ==3)
				selectedPit =2;
			else if(selectedPit ==2)
				selectedPit =3;
			else if(selectedPit == 1)
				selectedPit =4;
			else
				selectedPit =5;
		}
		if(totalStones == 1 && (selectedPit <= 4 && selectedPit >= 0))
		{
			int owned;
			int nextPit = selectedPit +1;
			if(selectedPit ==0)
				owned = 11;
			else if(selectedPit ==1)
				owned = 10;
			else if(selectedPit ==2)
				owned = 9;
			else if(selectedPit ==3)
				owned =8;
			else
				owned =7;
				
			if(circle.get(nextPit).getstones() == 0)
			{
				int taken = circle.get(owned).getstones() + 1;
				circle.get(owned).Clear();
				bigPits.get(0).addStones(taken);
				check = false;
				System.out.println("-------");
			}
		}
		else if(totalStones == 1 && (selectedPit <= 10 && selectedPit >= 6))
		{
			int owned;
			int nextPit = selectedPit +1;
			if(selectedPit == 6)
				owned = 5;
			else if(selectedPit ==7)
				owned = 4;
			else if(selectedPit == 8)
				owned = 3;
			else if(selectedPit == 9)
				owned =2;
			else
				owned = 1;
				
			if(circle.get(nextPit).getstones() == 0)
			{
				int taken = circle.get(owned).getstones() + 1;
				circle.get(owned).Clear();
				bigPits.get(1).addStones(taken);
				check = false;
				System.out.println("-DDD-");
			}
		}
		if(check == true)
		{
		while(totalStones != 0) 
			{
				totalStones--;
				selectedPit++;
					if(selectedPit == 6 && this.curPlayer == 1){
							bigPits.get(0).addStones(1);
							if(totalStones > 0)
							{
								circle.get(selectedPit).addStones(1);
								totalStones--;
							}
							else
								retaketurn = true;
						}
						else if(selectedPit == 12  && this.curPlayer == -1){
							bigPits.get(1).addStones(1);
							if(totalStones > 0)
							{
								selectedPit = -1;
							}
							else
								retaketurn = true;
						}
						else if(selectedPit ==12)
							selectedPit = -1;
						else
							circle.get(selectedPit).addStones(1);	
			}
		}
		if(retaketurn == false)
		{
			this.curPlayer = (this.curPlayer * -1); // alternate current player each time to negative and nonnegative num
		}
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
	public boolean gameEnded() {
		return gameOver;
	}
	public String whoWon()
	{
		String temp = "";
		if(bigPits.get(0).getstones() > bigPits.get(1).getstones())
			temp = "Player 2 Won the game";
		else if(bigPits.get(0).getstones() < bigPits.get(1).getstones())
			temp = "Player 1 Won the game";
		else
			temp = "THE GAME IS A TIE";
		
		return temp;
	}
	public void checkWin() {
		int count = 0;
		for (int i = 0; i <=5; i++){
			if (pits.get(i).getstones() == 0)
				++count;
		}
		if (count == 6) {
			for (int i = 6; i <=11; i++) {
				bigPits.get(1).addStones(pits.get(i).getstones());
				pits.get(i).Clear();
			}
			for(ChangeListener l : this.listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
				gameOver = true;
		}
		count = 0;
		for(int i = 6; i <=11; i++) {
			if (pits.get(i).getstones() == 0)
				++count;
		}
		if (count == 6) {
			for (int i = 0; i <=5; i++) {
				bigPits.get(0).addStones(pits.get(i).getstones());
				pits.get(i).Clear();
			}
			for(ChangeListener l : this.listeners) {
				l.stateChanged(new ChangeEvent(this));
			}
			gameOver = true;
		}
		gameOver = false;
	}
}