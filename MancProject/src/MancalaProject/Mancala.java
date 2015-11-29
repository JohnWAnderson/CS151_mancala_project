package MancalaProject;

import javax.swing.JOptionPane;

public class Mancala
{	
	private final static String[] SETUP = { "Clasic", "Custom" };
	private final static String[] SETUP_2 = { "3 Stones", "4 Stones" };
	public static void main(String[] args)
	{

		int selection = JOptionPane.showConfirmDialog(null,
				"Would you like to play a game", "Mancala",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (selection == -1 || selection == 2) {
			JOptionPane.showMessageDialog(null, "GoodBye");
			System.exit(0);
		}
		int option = JOptionPane.showOptionDialog(null,
				"Pick what game stlye that ", "Mancala Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				SETUP, SETUP[0]);
		int stones = JOptionPane.showOptionDialog(null,
				"How many stones would you like to start with?",
				"Mancala Game", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, SETUP_2, null);
		//if (stones == 0)
		//	model.setInitStones(3);
		//else
		//	model.setInitStones(4);
		//model.update();
	}
}   