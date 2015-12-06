package MancalaProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * is the interface that has the method's for the types 2 boards we made.  The normal and custom boards
 * @author John Anderson
 * @author Christopher Dalporto
 * @author Andy Nguyen
 *
 */
public interface Borad
{
	void drawbigpits(Graphics2D g2, int x, int y, int stones, int size);
	void drawpits(Graphics2D g2, int x, int y, int stones, int size);
	int stonespot();
	int bigstonesspot();
}