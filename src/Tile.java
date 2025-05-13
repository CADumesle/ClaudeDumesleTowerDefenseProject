
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/12/2025
 */

import javax.swing.JPanel;

/**
 * 
 * Purpose: The reponsibility maybe nothing tbh
 *
 * Tile is-a JPANEL
 * Tile is ...
 */
public class Tile extends JPanel
{
	public Tile()
	{

	}

	/**
	 * 
	 * can you place on this tile?
	 * 
	 * @return false (default)
	 */
	public boolean isPlaceable()
	{
		return false;
	}

	/**
	 * @return
	 */
	public Enemy getEnemy()
	{
		// TODO Auto-generated method stub
		return null;
	}
}