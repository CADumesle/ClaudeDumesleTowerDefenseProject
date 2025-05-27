import java.awt.BorderLayout;
import java.awt.Color;

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
 * Purpose: The reponsibility of GroundTile is display area where Structures can
 * be placed
 *
 * GroundTile is-a Tile
 */
public class GroundTile extends Tile
{

	private Structure currentStructure; // A GroundTile Has-A currentStructure

	/**
	 * 
	 * Purpose: GroundTile defualt constructor
	 */
	public GroundTile()
	{
		this.setBackground(new Color(45, 178, 0));

		setLayout(new BorderLayout());
	}

	/**
	 * 
	 * Purpose: set currentSctructure
	 * 
	 * @param newStructure
	 */
	public void setStructure(Structure newStructure)
	{
		currentStructure = newStructure;
	}

	/**
	 * Purpose:Override so Structures can be placed on GroundTile
	 * 
	 */
	@Override
	public boolean isPlaceable()
	{
		return true;
	}

	/**
	 * 
	 * Purpose: check if GroundTile is occupied
	 * 
	 * @return true if there is a structure, false if not
	 */
	public boolean hasStructure()
	{
		if (currentStructure != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}