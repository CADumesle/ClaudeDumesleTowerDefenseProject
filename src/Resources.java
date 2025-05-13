
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/12/2025
 */

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * Purpose: The responsibility of Resources is display player's current
 * resources
 *
 * Resources is-a Jpanel
 */
public class Resources extends JPanel
{
	private Player player; // Resources Has-A player

	private JLabel displayLabel = new JLabel();

	String display; // Resources HAS-A display

	/**
	 * 
	 * Purpose: Resources constructor that passes reference of player
	 * 
	 * @param newPlayer
	 */
	public Resources(Player newPlayer)
	{
		player = newPlayer;
		updateResources();
		displayLabel.setText(display);

		this.setBackground(new Color(0, 100, 0));
		setLayout(new FlowLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);

		add(displayLabel);
	}

	/**
	 * 
	 * Purpose: update player's resources
	 */
	public void updateResources()
	{

		display = "Resources: " + player.getWood() + " wood ";

	}
}