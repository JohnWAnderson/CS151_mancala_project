import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;  

public class MancalaBoard implements Strategy
{	
	private ArrayList<Pit> pits = new ArrayList<Pit>();
	private int type;
	private Color color;
	public MancalaBoard(Color color, int type, int numberStones)
	{  
		this.color = color;   
		this.type = type;
		JFrame frame = new JFrame("mancala");
		frame.setSize(1000, 300);	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,6));
		for(int i =0; i < 12; i++)
		{
			pits.add(new Pit(100, 100, this.type, this.color));
			JLabel temp = new JLabel(pits.get(i));
			center.add(temp);
		}
		JLabel big1 = new JLabel(new BigPit(150,200,this.type,this.color));
		JLabel big2 = new JLabel(new BigPit(150,200,this.type,this.color));
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
		
		frame.add(bigpit1, BorderLayout.EAST);
		frame.add(bigpit2, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);
		frame.add(top, BorderLayout.NORTH);
		frame.add(bot, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public int ShapeFormatter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int NumberOfStones() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
