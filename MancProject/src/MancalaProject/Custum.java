package MancalaProject;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Custum implements Borad
{
	@Override
	public void SetGameBorad(Graphics2D g, ArrayList<Pit> pit) 
	{	
		
		JFrame frame = new JFrame("mancala");
		frame.setSize(1000, 300);	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,6));
		for(int i =0; i < 12; i++)
		{
			Pit temp = new Pit(100,100);
			pit.add(temp);
			center.add(temp);
		}
		Pit big1 = new Pit(100,200);
		Pit big2 = new Pit(100,200);
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
  