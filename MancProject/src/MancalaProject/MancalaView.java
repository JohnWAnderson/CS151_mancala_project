import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaView
{
	private MancalaModel model;
	public MancalaView()
	{
		model = new MancalaModel();
	}
	
	public JPanel StartMiddlePits(Borad style)
	{
		JPanel centerPits = new JPanel();
        GridLayout gridLayout = new GridLayout(2,6);
        centerPits.setLayout(gridLayout);
        for(int i = 0; i < 12; i++)
        {	
        	Pit temp = new Pit(80,style, 0);
        	JLabel pit = new JLabel(temp);
        	centerPits.add(pit);
        	model.addPit(temp);
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
	public JPanel BigPit(Borad style, int player)
	{
		JPanel big = new JPanel();
		//big.setPreferredSize(new Dimension(160, 250));
		BigPit bigpit = new BigPit(190, style, 0, player); // 1 is player 2
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
	
}
