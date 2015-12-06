package MancalaProject;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * the model that controlls all of the data 
 * has the arraylist of pits and arraylist of bigpits
 * has all of the controlling game rules 
 * @author John Anderson
 * @author Christopher Dal Porto
 * @author Andy Nguyen
 * @version 1.0
 */
public class MancalaModel 
{
	private ArrayList<Pit> circle; // Circular array for holding values to traverse the array of pits
	private ArrayList<Pit> pits;  // ArrayList containing the inner pits
	private ArrayList<BigPit> bigPits;  // ArrayList containing two outer pits. 0  is player 2  1 is player 2
	private ArrayList<Pit> tempPits; // temporary ArrayList of pits to always hold copy from before turn is finished to allow undo
	private ArrayList<BigPit> tempBigPits; // temporary ArrayList of pits to always hold copy from before turn is finished to allow undo
	private Borad style; // Style to set the view to
	private ArrayList<ChangeListener> listeners; // list of listeners to be notified
	private int curPlayer; //variable to keep track of current player, see constructor for value meanings
	private int undo; // number of undos (held and updated for each turn
	private boolean gameOver; // gameOver var to be checked each turn before allowing a move
	private boolean retaketurn; // retaketurn true if bigPit is landed  giving extra turn
	private String lastPickedRow; // String always holding last row clicked for undo method
	
	public MancalaModel()
	{
		this.curPlayer = -1; // 1 for player 1, -1 for player 2
		pits = new ArrayList<Pit>();
		bigPits = new ArrayList<BigPit>();
		circle = new ArrayList<Pit>();
		listeners = new ArrayList<ChangeListener>();	
		undo = 3;
		gameOver = false;
		lastPickedRow = "bot";
	}
	/**
	 * checks what players turn it is
	 * @return curPlayer  the number related to the player
	 */
	public int getPlayer() {
		return this.curPlayer;
	}
	/**
	 * calls to see if you won a retake turn
	 * @return boolean  true or false to retake turn
	 */
	public boolean retaketurn()
	{
		return this.retaketurn;
	}
	/**
	 * tells if player 2 or not
	 * @return boolean  if player 2 true if not false 
	 */
	public boolean player2Turn()
	{
		return this.curPlayer == 1;
	}
	/**
	 * tells the current size of the pits arraylist
	 * @return pits.size()  the size of the pits
	 */
	public int pitsSize()
	{
		return pits.size();
	}
	/**
	 * Resets the undo variable back to 3
	 */
	public void setUndo()
	{
		this.undo = 3;
	}
	/**
	 * adds mancal pit to bigpit
	 * @param bp the pit to add to the arraylist
	 */
	public void addBigPit(BigPit bp)
	{
		bigPits.add(bp);
	}
	/**
	 * returns the amount of stones in their pit
	 * @param i the player number
	 * @return stones  the amount of stones the player has in his pit
	 */
	public int getPlayerPitStones(int i)
	{
		return bigPits.get(i).getstones();
	}
	/**
	 * returns number of undo moves left
	 * @return undo the variable containing undo value
	 */
	public int getUndo() {
		return this.undo;
	}
	/**
	 * Checks if there are more undo moves available to current player
	 * @return true if undo moves left is > 0
	 */
	public boolean checkUndo()
	{
		return (this.undo > 0);
	}
	/**
	 * Sets the style for the strategy pattern of the mancala board
	 * @param style Borad object 
	 */
	public void setStyle(Borad style) {
		this.style = style;
	}
	/**
	 * Gets the value stored in this.style which implements the Borad interface
	 * @return style object
	 */
	public Borad getStyle() {
		return style;
	}
	/**
	 * Gets the stones held in any given pit
	 * @param i the number in pits ArrayList to get from
	 * @return number of stones in the gotten pit
	 */
	public int getStonesPit(int i)
	{
		return pits.get(i).getstones();
	}
	/**
	 * Sets the stones for all inner pits of the mancalaBoard at start
	 * @param number of stones to be set for each inner pit
	 */
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
	/**
	 * Undo method which sets the ArrayLists of pits and bigPits to
	 * deep copies of the temporary lists from the previous turn
	 */
	public void undoCalled()
	{
		if (((this.getLastMove().equals("bot") && this.curPlayer == 1) || (this.getLastMove().equals("top") && this.curPlayer == -1)) || this.retaketurn() == true) {
			
			if (this.retaketurn() == true) {
				curPlayer = curPlayer * -1;
				this.retaketurn = false;
			}
		undo--;
		pits = new ArrayList<Pit>();
		for (Pit p : tempPits) {
			pits.add(p.clone());
		}
		bigPits = new ArrayList<BigPit>();
		for (BigPit bp : tempBigPits){
			bigPits.add(bp.clone());
		}
		curPlayer = curPlayer * -1;
		for(ChangeListener l : this.listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
		}
		else {
			return;
		}
		
	}
	/**
	 * called each turn to create temporary deep copies of the state of the pits
	 */
	public void saveUndo()
	{
		tempPits = new ArrayList<Pit>();
		for (Pit p : pits) {
			tempPits.add(p.clone());
		}
		tempBigPits = new ArrayList<BigPit>();
		for (BigPit bp : bigPits){
			tempBigPits.add(bp.clone());
		}
	}
	/**
	 * creates the circle Array differentiating the numbers for easy traversal
	 */
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
	/**
	 * returns the last move String containing which row was last activated
	 * @return string containing "top" or "bot"
	 */
	public String getLastMove() {
		return this.lastPickedRow;
	}
	/**
	 * playerMove function called each time a pit is clicked from the controller
	 * @param thePit which pit was clicked
	 * @param theStones number of stones from that first pit
	 */
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
		int startPit = thePit;
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
				owned = 10;
			else if(selectedPit ==1)
				owned = 9;
			else if(selectedPit ==2)
				owned = 8;
			else if(selectedPit ==3)
				owned =7;
			else
				owned =6;
				
			if(circle.get(nextPit).getstones() == 0)
			{
				int taken = circle.get(owned).getstones() + 1;
				circle.get(owned).Clear();
				bigPits.get(0).addStones(taken);
				check = false;
			}
		}
		else if(totalStones == 1 && (selectedPit <= 10 && selectedPit >= 6))
		{
			int owned;
			int nextPit = selectedPit +1;
			if(selectedPit == 6)
				owned = 4;
			else if(selectedPit ==7)
				owned = 3;
			else if(selectedPit == 8)
				owned = 2;
			else if(selectedPit == 9)
				owned =1;
			else
				owned = 0;
				
			if(circle.get(nextPit).getstones() == 0)
			{
				int taken = circle.get(owned).getstones() + 1;
				circle.get(owned).Clear();
				bigPits.get(1).addStones(taken);
				check = false;
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
							}
							else
								retaketurn = true;
						}
						else if(selectedPit == 12  && this.curPlayer == -1){
							bigPits.get(1).addStones(1);
							if(totalStones > 0)
							{
								selectedPit = 0;
								circle.get(selectedPit).addStones(1);
								totalStones--;
							}
							else
								retaketurn = true;
						}
						else if(selectedPit == 12){
							selectedPit = -1;}
						else
						{	
							circle.get(selectedPit).addStones(1);
								if(totalStones == 0 && (circle.get(selectedPit).getstones() ==1))
								{
									int owned;
									if(selectedPit ==0)
										owned = 11;
									else if(selectedPit ==1)
										owned = 10;
									else if(selectedPit ==2)
										owned = 9;
									else if(selectedPit ==3)
										owned =8;
									else if (selectedPit ==4)
										owned =7;
									else if(selectedPit == 5)
										owned = 6;
									else if(selectedPit == 6)
										owned = 5;
									else if(selectedPit ==7)
										owned = 4;
									else if(selectedPit == 8)
										owned = 3;
									else if(selectedPit == 9)
										owned =2;
									else if(selectedPit == 10)
										owned = 1;
									else
										owned = 0;
									if( player2Turn() == true  &&((selectedPit <= 5 && selectedPit >= 0)))
									{
									int taken = circle.get(owned).getstones() +1;
									circle.get(owned).Clear();
									circle.get(selectedPit).Clear();	
										bigPits.get(0).addStones(taken);
									}
									else if( player2Turn() == false && (selectedPit <= 11 && selectedPit >= 6))
									{
										int taken = circle.get(owned).getstones() +1;
										circle.get(owned).Clear();
										circle.get(selectedPit).Clear();
											bigPits.get(1).addStones(taken);
			
									}
								}
			} }
		}
		if(retaketurn == false)
		{
			this.curPlayer = (this.curPlayer * -1); // alternate current player each time to negative and nonnegative num
		}
		for (ChangeListener l : this.listeners) { // notify listeners (view)
			l.stateChanged(new ChangeEvent(this));
		}
	}
	/**
	 * attach method to stick listeners to be notified into list
	 * @param listener ChangeListener to be notified with model  update
	 */
	public void attach(ChangeListener listener) {
		this.listeners.add(listener);

	}
	/**
	 * Adds a pit to the list of pits and updates the listeners
	 * @param temp pit to be added to list
	 */
	public void addPit(Pit temp)
	{
		pits.add(temp);
		
		for (ChangeListener l : this.listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	/**
	 * keeps track of whether game is still going or not
	 * @return value of gameOver boolean variable
	 */
	public boolean gameEnded() {
		return gameOver;
	}
	/**
	 * gets which player won the game at conclusion of program
	 * @return String with the win statement
	 */
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
	/**
	 * Checks if win condiditon has been met(one complete row of pits empty) each turn
	 */
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
				setStones(0);
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