package MancalaProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaView
{
	public JPanel centerPits;
	private MancalaModel model;
	public MancalaView(Borad style, MancalaModel dataModel)
	{
		model = dataModel;//new MancalaModel(); old code
		model.setStyle(style);
	}
	
	public JPanel StartMiddlePits()
	{
		centerPits = new JPanel();
        GridLayout gridLayout = new GridLayout(2,6);
        centerPits.setLayout(gridLayout);
        for(int i = 0; i < 12; i++)
        {	
        	Pit temp = new Pit(80,model.getStyle(), 0, i, model);
        	
        	JLabel pit = new JLabel(temp);
        	
        	pit.addMouseListener(temp); // add Mouse listener to each pit object passing pit to it
        	
        	centerPits.add(pit);
        	model.addPit(temp);
        }
		return centerPits;
	}
	/**
	 * updates tha JPanel by not reading the pits to the model
	 * @return centerPits  the 12 center pits
	 */
	public JPanel MiddlePitsUpdate()
	{
		centerPits = new JPanel();
		 GridLayout gridLayout = new GridLayout(2,6);
	        centerPits.setLayout(gridLayout);
	        for(int i = 0; i < model.pits.size(); i++) // this needed to be restricted to the current size of pit ArrayList
	        {	
	        	Pit temp = new Pit(80,model.getStyle(), model.getStonesPit(i), i, model);    // model.getStonesPit(i)    this is what should be were 3 is
	        	
	        	JLabel pit = new JLabel(temp);
	        	pit.addMouseListener(temp); // add Mouse listener to each pit object passing pit to it
	        	
	        	centerPits.add(pit);
	        }
		return centerPits;
	}
	public JPanel toplabel()
	{
        JPanel botPanel = new JPanel();
		 for(int i =1; i < 7; i++)
         { 
                 JLabel tempA = new JLabel("           " + "A" + i + "            ");
                 botPanel.add(tempA);
         }
		 return botPanel;
	}
	
	public JPanel botlabel()
	{
        JPanel topPanel = new JPanel();
		 for(int i =1; i < 7; i++)
         {
                 JLabel tempB = new JLabel( "           " + "B" + (7 - i) + "            ");
                 topPanel.add(tempB);  
         }
		 return topPanel;
	}
	public JPanel BigPit(int player)
	{
		JPanel big = new JPanel();
		//big.setPreferredSize(new Dimension(160, 250));
		BigPit bigpit = new BigPit(190, model.getStyle(), 0, player); // 1 is player 2
		JLabel label = new JLabel(bigpit);
		big.add(label);
		return big;
	}
	public JPanel ManA()
	{
		JPanel leftLabel = new JPanel();
		JLabel M = new JLabel("M");
		JLabel A = new JLabel("A");
		JLabel N = new JLabel("N");
		JLabel C = new JLabel("C");
		JLabel A1 = new JLabel("A");
		JLabel L = new JLabel("L");
		JLabel A2 = new JLabel("A");
		JLabel space = new JLabel(" ");
		JLabel label = new JLabel("A");
		leftLabel.setLayout(new BoxLayout(leftLabel, BoxLayout.Y_AXIS));
		leftLabel.add(M);
		leftLabel.add(A);
		leftLabel.add(N);
		leftLabel.add(C);
		leftLabel.add(A1);
		leftLabel.add(L);
		leftLabel.add(A2);
		leftLabel.add(space);
		leftLabel.add(label);
		return leftLabel;
	}
	public JPanel ManB()
	{
		JPanel leftLabel = new JPanel();
		JLabel M = new JLabel("M");
		JLabel A = new JLabel("A");
		JLabel N = new JLabel("N");
		JLabel C = new JLabel("C");
		JLabel A1 = new JLabel("A");
		JLabel L = new JLabel("L");
		JLabel A2 = new JLabel("A");
		JLabel space = new JLabel(" ");
		JLabel label = new JLabel("B");
		leftLabel.setLayout(new BoxLayout(leftLabel, BoxLayout.Y_AXIS));
		leftLabel.add(M);
		leftLabel.add(A);
		leftLabel.add(N);
		leftLabel.add(C);
		leftLabel.add(A1);
		leftLabel.add(L);
		leftLabel.add(A2);
		leftLabel.add(space);
		leftLabel.add(label);
		return leftLabel;
	}
	public JPanel playersTurn()
	{
		JPanel turn = new JPanel();
		JLabel whoeseTurn = new JLabel();
		JLabel undoTurn = new JLabel();
		JLabel Won = new JLabel();
		if(model.getPlayer() == 1)
		{
			whoeseTurn = new JLabel("Player 1 turn: ");
		}
		else
		{
			whoeseTurn = new JLabel("Player 2 turn: ");
		}
		
		if(model.checkUndo() == true && model.Undo() != 3)
		{
			undoTurn = new JLabel("You have " + model.Undo() + "/3 undo's left");
		}
		else if(model.Undo() ==0)
		{
			undoTurn = new JLabel("You have no more undos");
		}
		/**if()
		{
			check win condtion then man label for winning player number
		}*/
		JButton undo = new JButton("UNDO");
		
		turn.setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		temp.add(whoeseTurn,  BorderLayout.WEST);
		temp.add(undoTurn);
		turn.add(temp, BorderLayout.WEST);
		turn.add(Won, BorderLayout.CENTER);
		turn.add(undo,  BorderLayout.EAST);
		return turn;
	}
	
}
