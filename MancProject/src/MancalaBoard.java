import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MancalaBoard
{	
	private ArrayList<Pit> pits = new ArrayList<Pit>();
	public MancalaBoard()
	{
		JFrame frame = new JFrame("mancala");
		frame.setSize(1000,500);
		JPanel center = new JPanel(new GridLayout(2,6));
		center.setPreferredSize(new Dimension(600,400));
		for(int i =0; i < 12; i++)
		{
			pits.add(new Pit());
			center.add(pits.get(i));
		}
		JPanel bigpit1 = new JPanel();	bigpit1.setPreferredSize(new Dimension(200,400)); bigpit1.add(new BigPit());
		JPanel bigpit2 = new JPanel();  bigpit2.setPreferredSize(new Dimension(200,400)); bigpit2.add(new BigPit());
		JPanel top = new JPanel(); top.setPreferredSize(new Dimension(1000, 50));
		JPanel bot = new JPanel(); bot.setPreferredSize(new Dimension(1000, 50));
		for(int i =1; i < 7; i++)
		{
			JLabel temp = new JLabel("A" + i );
			temp.setPreferredSize(new Dimension(100,50));
			top.add(temp);
			JLabel tempB = new JLabel("B" + i );
			tempB.setPreferredSize(new Dimension(90,50));
			bot.add(tempB);
		}
		
		frame.add(bigpit1, BorderLayout.EAST);
		frame.add(bigpit2, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);
		frame.add(top, BorderLayout.NORTH);
		frame.add(bot, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void addPits(JPanel center)
	{
		for(int i = 0;i < 12; i++)
		{
			
		}
	}
	
}
