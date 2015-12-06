package MancalaProject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * The main program that combints all of the JPanels in the view onto the JPanel in the corrent game board
 * @author John Anderson
 * @author Christopher Dalporto
 * @author Andy Nguyen
 *
 */
public class Mancala implements ChangeListener
{	
	private final String[] SETUP_2 = { "3 Stones", "4 Stones" };
	private MancalaModel model;
	private MancalaView view;
	private Borad style;
	private JPanel output;
	private JPanel center;
	public JFrame frame;
	/**
	 * creats the mancala
	 * @param style   the board style
	 * @param dataModel  the model
	 */
	public Mancala(Borad style, MancalaModel dataModel) // dataModel passed
	{
		model = dataModel; //new MancalaModel(); old code
		view = new MancalaView(style, this.model); //passing main model to the view
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
	/**
	 * refreshes the borad
	 */
	public void refresh()
	{
		center.setVisible(false);
		output.setVisible(false);
		output = new JPanel(new BorderLayout());
		center = new JPanel(new BorderLayout());
		center.add(view.BigPit(1), BorderLayout.WEST);  // big pit
		center.add(view.BigPit(-1), BorderLayout.EAST);	// big pit
		center.add(view.MiddlePitsUpdate(), BorderLayout.CENTER);	// pits
		center.add(view.toplabel(), BorderLayout.NORTH);	// top label
		center.add(view.botlabel(), BorderLayout.SOUTH);	// bot label
		output.add(center, BorderLayout.CENTER);
		output.add(view.playersTurn(), BorderLayout.SOUTH);
		frame.add(output, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	/**
	 * starts the board
	 */
	public void start()
	{	
		output = new JPanel(new BorderLayout());
		frame = new JFrame();
		frame.setSize(new Dimension(800,310));
		frame.setLayout(new BorderLayout());
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(view.StartBigPit(1), BorderLayout.WEST);  // big pit
		center.add(view.StartBigPit(-1), BorderLayout.EAST);	// big pit
		center.add(view.StartMiddlePits(), BorderLayout.CENTER);	// pits
		center.add(view.botlabel(), BorderLayout.NORTH);	// top label
		center.add(view.toplabel(), BorderLayout.SOUTH);	// bot label
		output.add(center, BorderLayout.CENTER);
		output.add(view.playersTurn(), BorderLayout.SOUTH);
		frame.add(view.ManB(), BorderLayout.WEST);		//
		frame.add(view.ManA(), BorderLayout.EAST);
		//frame.add(view.playersTurn(), BorderLayout.SOUTH);
		frame.add(output, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.setStones(0);
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
	/**
	 * when there is a statechange the refresh is called
	 */
	/**
	 * calls a method to repaint the view
	 */
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		refresh();
	}
}   