import javax.swing.JPanel;
/**
 * Lead Author(s): Claude-Arthur Dumesle
 * 
 * @author:  Claude-Arthur Dumesle
 * References:
 *  *1. Agarwal, P. (2021, November 14). Image processing in java - read and write. GeeksforGeeks. GeeksforGeeks. 
 *Retrieved May 8, 2025, from https://www.geeksforgeeks.org/image-processing-in-java-read-and-write/  
 * 
 * Version/date: 6/1/25
 * 
 * 
 */

/**
 * 
 * Purpose: Class for Ground and PathTile to derive from
 *
 * Tile is-a JPANEL
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
	 * Purpose: USed by inheriting Tiles that can hold enemy thus overriding and returning Enemy
	 * @return null, by default
	 */
	public Enemy getEnemy()
	{
		return null;
	}
}