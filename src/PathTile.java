import java.awt.BorderLayout;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lead Author(s): Claude-Arthur Dumesle
 * 
 * @author:  Claude-Arthur Dumesle
 * References:
 * Oracle. (2025a, April 5). Class Point. Point (java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html 
 * Oracle. (2025, April 5). Class ThreadLocalRandom. Threadlocalrandom (java platform SE 8 ). https://docs.oracle.com/javase/8/docs//api/java/util/concurrent/ThreadLocalRandom.html
 *  *1. Agarwal, P. (2021, November 14). Image processing in java - read and write. GeeksforGeeks. GeeksforGeeks. 
 *Retrieved May 8, 2025, from https://www.geeksforgeeks.org/image-processing-in-java-read-and-write/  
 * 
 * Version/date: 5/26/25
 * 
 * 
 */

/**
 * 
 * Purpose: The reponsibility of PathTile is let Enemy traverse through the map
 *
 * PathTile is-a Tile
 */
public class PathTile extends Tile
{

	private PathTile nextTile;// PathTile Has-A nextTile
	private Queue<Enemy> currentEnemies = new LinkedList<Enemy>(); // PathTile Has-A current Enemy

	/**
	 * 
	 * Purpose: PathTile constructor with pointer of nextTile
	 * 
	 * @param newNextTile
	 */
	public PathTile(PathTile newNextTile)
	{
		
		nextTile = newNextTile;
		this.setBackground(new Color(87, 65, 47));
		setLayout(new BorderLayout());
	}

	/**
	 * 
	 * Purpose: return: pointer to next tile
	 * 
	 * @return: nextTile
	 */
	public PathTile getNextTile()
	{

		return nextTile;
	}

	// note*: when Enemies are stored in queue update and return earliest enemy
	/**
	 * 
	 * 
	 * @return enemy on current enemy on tile
	 */
	@Override
	public Enemy getEnemy()
	{
		return currentEnemies.peek();
	}

	/**
	 * 
	 * Purpose: set pointer to nextTile
	 * 
	 * @param newNextTile
	 */
	public void setNextTile(PathTile newNextTile)
	{
		nextTile = newNextTile;
	}

	/**
	 * 
	 * Purpose: Set currentEnemy for Tile and also, add visually
	 * 
	 * @param newEnemy
	 */
	public void setEnemy(Enemy newEnemy)
	{
		currentEnemies.add(newEnemy);
		add(currentEnemies.peek(), BorderLayout.CENTER);
		updateDisplay();
	}

	/**
	 * 
	 * Purpose: use if PathTile is first in path, add enemy
	 * 
	 * @param newEnemy
	 */
	public void spawn(Enemy newEnemy)
	{
		setEnemy(newEnemy);
		newEnemy.spawn(this);
		updateDisplay();
	}

	/**
	 * 
	 * Purpose:method used when enemy leaves Path
	 */
	public void clear(Enemy enemy)
	{
		currentEnemies.remove(enemy);
		remove(enemy);
		updateDisplay();
	}
	
	/**
	 *  update graphics of tile
	 */
	public void updateDisplay()
	{
		update(getGraphics());
		revalidate();
	}

}