
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/5/2025
 */

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Purpose: The reponsibility of GroundTile is display area where Structures can
 * be placed
 *
 * GroundTile is-a Tile
 */
public class GroundTile extends Tile
{

	private Structure currentStructure;
	// Structure structures[];

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

	@Override
	public boolean isPlaceable()
	{
		return true;
	}

	/**
	 * 
	 * Purpose: check if GroundTile is occupied
	 * 
	 * @return
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