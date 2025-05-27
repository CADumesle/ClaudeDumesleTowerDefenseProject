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
	 * @return
	 */
	public Enemy getEnemy()
	{
		// TODO Auto-generated method stub
		return null;
	}
}