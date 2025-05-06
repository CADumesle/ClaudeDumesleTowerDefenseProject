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
 * Purpose: The reponsibility of GroundTile is display area where Structures can be placed
 *
 * GroundTile is-a Tile
 */
public class GroundTile extends Tile
{

	//Structure structures[];


	/**
	 * 
	 * Purpose: GroundTile defualt constructor
	 */
	public GroundTile() 
	{
		this.setBackground(new Color(144,238,144));
		
		setLayout(new BorderLayout());
	}

}