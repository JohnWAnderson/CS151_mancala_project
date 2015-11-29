package MancalaProject;
import java.awt.*;
import javax.swing.*;
 
public class ClassicBoard
{
        JFrame frame;
        //JPanel mancalaContainer;
        JPanel leftBigPit;
        JPanel rightBigPit;
        JPanel centerPits;
        JPanel topPanel;
        JPanel botPanel;
       
        public ClassicBoard()
        {
                frame = new JFrame("Classic Mancala Board");
                frame.setSize(500, 300);
                frame.setLayout(new BorderLayout());
                leftBigPit = new JPanel();
                rightBigPit = new JPanel();
               
                centerPits = new JPanel();
                GridLayout gridLayout = new GridLayout(2,6);
                gridLayout.setHgap(0);
                gridLayout.setVgap(0);
                centerPits.setLayout(gridLayout);
               
                topPanel = new JPanel();
                botPanel = new JPanel();
               
                this.drawClassicBoard();
        }
        public void drawClassicBoard()
        {      
                // add pit into leftBigPit Panel
                Pit bigPit1 = new Pit(100,200, "Normal");
                leftBigPit.add(bigPit1);
               
                // add pit ino rightBigPit Panel
                Pit bigPit2 = new Pit(100,200, "Normal");
                rightBigPit.add(bigPit2);
               
                // add pits into centerPits Panel
                for(int i = 0; i < 12; i++)
                {
                        Pit temp = new Pit(100, 100, "Normal");
                        centerPits.add(temp);
                }
               
                //add labels to topPanel Panel and botPanel Panel
                for(int i =1; i < 7; i++)
                {
                        JLabel tempB = new JLabel( "               " + "B" + (7 - i) + "                ");
                        topPanel.add(tempB);  
                        JLabel tempA = new JLabel("               " + "A" + i + "                ");
                        botPanel.add(tempA);
                }
               
                //mancalaContainer.add(centerPits, BorderLayout.CENTER);
                //mancalaContainer.add(leftBigPit, BorderLayout.WEST);
                //mancalaContainer.add(rightBigPit, BorderLayout.EAST);
                //frame.add(leftBigPit, BorderLayout.WEST);
                //frame.add(rightBigPit, BorderLayout.EAST);
                //frame.add(centerPits, BorderLayout.CENTER);
                frame.add(topPanel, BorderLayout.NORTH);
                frame.add(botPanel, BorderLayout.SOUTH);
                frame.add(leftBigPit, BorderLayout.WEST);
                frame.add(rightBigPit, BorderLayout.EAST);
                frame.add(centerPits, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
               
        }
}