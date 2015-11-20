package MancalaProject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;	
public class StartUpStones
{
	protected int Amount;
	private MancalaBoard game;
	StartUpStones()
	{
		JFrame menu = new JFrame("menu");
		menu.setSize(new Dimension(300, 200));
		JButton normal = new JButton("3 stones");
		normal.addActionListener(new ActionListener()
	     {
	        public void actionPerformed(ActionEvent e)
	        {
	        	 menu.setVisible(false);
	        }
	     });
		JButton custum = new JButton("4 stones");
		custum.addActionListener(new ActionListener()
	     {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Type = "Custom";
	        	menu.setVisible(false);
	        }
	     });
		JLabel header = new JLabel("  Pick your board type");
		menu.add(normal,BorderLayout.EAST);
		menu.add(custum, BorderLayout.WEST);
		menu.add(header, BorderLayout.CENTER);
		menu.setVisible(true);
	}
}
