package MancalaProject;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Mancala implements ChangeListener
{	
	private final String[] SETUP_2 = { "3 Stones", "4 Stones" };
	private MancalaModel model;
	private MancalaView view;
	private Borad style;
	private JPanel center;
	public JFrame frame;
	//public static Borad style;
	public Mancala(Borad style)
	{
		model = new MancalaModel();
		view = new MancalaView(style);
		this.style = style;
		
		/*ChangeListener listener = new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) {
				refresh();
			}
		};*/
		model.attach(this);
		start();
	}
	public void refresh()
	{
		center.setVisible(false);
		frame.setVisible(false);
		/**
		frame = new JFrame();
		frame.setSize(new Dimension(800,310));
		frame.setLayout(new BorderLayout());
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(view.BigPit(0), BorderLayout.WEST);  // big pit
		center.add(view.BigPit(1), BorderLayout.EAST);	// big pit
		center.add(view.MiddlePitsUpdate(), BorderLayout.CENTER);	// pits
		center.add(view.toplabel(), BorderLayout.NORTH);	// top label
		center.add(view.botlabel(), BorderLayout.SOUTH);	// bot label
		frame.add(view.ManA(), BorderLayout.WEST);		//
		frame.add(view.ManB(), BorderLayout.EAST);
		frame.add(center, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
		*/
	}
	public void start()
	{	
		frame = new JFrame();
		frame.setSize(new Dimension(800,310));
		frame.setLayout(new BorderLayout());
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(view.BigPit(0), BorderLayout.WEST);  // big pit
		center.add(view.BigPit(1), BorderLayout.EAST);	// big pit
		center.add(view.StartMiddlePits(), BorderLayout.CENTER);	// pits
		center.add(view.toplabel(), BorderLayout.NORTH);	// top label
		center.add(view.botlabel(), BorderLayout.SOUTH);	// bot label
		frame.add(view.ManA(), BorderLayout.WEST);		//
		frame.add(view.ManB(), BorderLayout.EAST);
		frame.add(center, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int startStones = JOptionPane.showOptionDialog(null,
				"How many stones would you like to start with?",
				"Mancala Game", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, SETUP_2, null);
	//	System.out.println(startStones);
		if (startStones == 0)
			model.setStones(3);
		else
			model.setStones(4);
		//model.update();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		//this.view.MiddlePitsUpdate();
		refresh();
	}
}   