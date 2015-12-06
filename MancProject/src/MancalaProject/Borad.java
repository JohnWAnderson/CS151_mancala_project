package MancalaProject;

import java.awt.Graphics2D;
/**
 * is the interface that has the method's for the types 2 boards we made.  The normal and custom boards
 * @author John Anderson
 * @author Christopher Dal Porto
 * @author Andy Nguyen
 * @version 1.0
 */
public interface Borad
{
	void drawbigpits(Graphics2D g2, int x, int y, int stones, int size);
	void drawpits(Graphics2D g2, int x, int y, int stones, int size);
	int stonespot();
	int bigstonesspot();
}