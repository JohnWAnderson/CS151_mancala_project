package MancalaProject;
import BigPit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Custum implements Borad
{
	private ArrayList<Pit> pits = new ArrayList<Pit>();
	@Override
	public Borad SetGameBorad() 
	{	
		JFrame frame = new JFrame("mancala");
		frame.setSize(1000, 300);	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,6));
		for(int i =0; i < 12; i++)
		{
			Pit temp = new Pit(100,100);
			pits.add(temp);
			center.add(temp);
		}
		BigPit big1 = new BigPit(100,200);
		BigPit big2 = new BigPit(100,200);
		JPanel bigpit1 = new JPanel();
		JPanel bigpit2 = new JPanel(); 
		bigpit1.add(big1);
		bigpit2.add(big2);
		JPanel top = new JPanel();
		JPanel bot = new JPanel(); 
		for(int i =1; i < 7; i++)
		{
			JLabel tempB = new JLabel( "               " + "B" + (7 - i) + "                ");
			top.add(tempB);   
			JLabel tempA = new JLabel("               " + "A" + i + "                ");
			bot.add(tempA);
		}
		frame.add(top, BorderLayout.NORTH);
		frame.add(bot, BorderLayout.SOUTH);
		frame.add(bigpit1, BorderLayout.WEST);
		frame.add(bigpit2, BorderLayout.EAST);
		frame.add(center, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

}
  