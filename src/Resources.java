/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
*/

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * Purpose: The reponsibility of Resources is display player's current resources
 *
 * Resources is-a Jpanel
 */
public class Resources extends JPanel 
{
	private Player player;

	/**
	 * 
	 * Purpose: Resrouces constructor that passes reference of player 
	 * @param newPlayer
	 */
	public Resources(Player newPlayer)
	{
		player = newPlayer;

		this.setBackground(new Color(0,100,0));
		setLayout(new FlowLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);

		JLabel playerResources = new JLabel("Resources:");
		add(playerResources);
	}

}