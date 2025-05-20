
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/5/2025
 */

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Purpose: The reponsibility of PathTile is let Enemy traverse through the map
 *
 * PathTile is-a Tile
 */
public class PathTile extends Tile
{

	private PathTile nextTile;// PathTile Has-A nextTile
	private Enemy currentEnemy; // PathTile Has-A current Enemy

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
		return currentEnemy;
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
		currentEnemy = newEnemy;
		add(currentEnemy);
		this.update(getGraphics());
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
	}

	/**
	 * 
	 * Purpose:method used when enemy leaves Path
	 */
	public void clear(Enemy enemy)
	{
		remove(currentEnemy);
		currentEnemy = null;

		this.update(getGraphics());
	}

}