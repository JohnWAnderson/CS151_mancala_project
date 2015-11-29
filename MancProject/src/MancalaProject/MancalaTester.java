import javax.swing.JOptionPane;


public class MancalaTester
{
	private final static String[] SETUP = { "Clasic", "Custom" };
	public static void main(String[] args)
	{
		Borad B1 = new classic();
		Borad B2 = new custom();
		int selection = JOptionPane.showConfirmDialog(null,
				"Would you like to play a game", "Mancala",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (selection == -1 || selection == 2) {
			JOptionPane.showMessageDialog(null, "GoodBye");
			System.exit(0);
		}
		int boardstyle = JOptionPane.showOptionDialog(null,
				"Pick what game stlye that ", "Mancala Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				SETUP, SETUP[0]);
		//System.out.println(boardstyle);
		if (boardstyle == 0) {
			Mancala temp = new Mancala(B1);
		} else {
			Mancala temp = new Mancala(B2);
		}
	
	}
}
