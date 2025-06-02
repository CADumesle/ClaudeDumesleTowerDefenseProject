import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Lead Author(s): Claude-Arthur Dumesle
 * 
 * @author:  Claude-Arthur Dumesle
 * 
 * 	version date: 6/1/25
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
	 * @return true if condition is met, false if not
	 */
	public boolean hasStructure()
	{
		return currentStructure != null;
	}
}