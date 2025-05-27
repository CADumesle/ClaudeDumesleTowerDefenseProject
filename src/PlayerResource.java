import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
 * Purpose: The reponsibility of PlayerResource is display all current resources of playwr
 *
 * PlayerResource is-a JPanel
 */
public class PlayerResource extends JPanel
{
	// a player has wood
	private int wood;
	// a player has stone
	private int stone;
	// a player has diamond
	private int diamond;

	private JLabel resourceDisplay; // a player has a resource Display
	


	/**
	 * 
	 * Purpose:  Main Constructor for PlayerResource
	 * @param newWood
	 * @param newStone
	 * @param newDiamond
	 */
	public PlayerResource(int newWood, int newStone, int newDiamond)
	{
		wood = newWood;
		stone = newStone;
		diamond = newDiamond;

		this.setBackground(new Color(0, 100, 0));
		setLayout(new FlowLayout());
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);

		resourceDisplay = new JLabel(
				"Wood: " + wood + " Stone: " + stone + " Diamond: " + diamond);
		add(resourceDisplay);
	}

	/**
	 * 
	 * Purpose: Set display text to newly updated values
	 */
	public void updateResources()
	{
		resourceDisplay.setText(getResource());
	}

	/**
	 * 
	 * Purpose: substract newWood from wood
	 * 
	 * @param newWood
	 */
	public void takeWood(int newWood)
	{
		wood -= newWood;
		updateResources();
	}

	/**
	 * 
	 * Purpose: substract newStone from stone
	 * 
	 * @param newStone
	 */
	public void takeStone(int newStone)
	{
		stone -= newStone;
		updateResources();
	}


	/**
	 * 
	 * Purpose: add new Wood to wood
	 * 
	 * @param newWood
	 */
	public void addWood(int newWood)
	{
		wood += newWood;
		updateResources();
	}

	/**
	 * 
	 * Purpose: add newStron to stone
	 * 
	 * @param newStone
	 */
	public void addStone(int newStone)
	{
		stone += newStone;
		updateResources();
	}

	/**
	 * 
	 * Purpose: add newDiamond to diamond
	 * 
	 * @param newDiamond
	 */
	public void addDiamond(int newDiamond)
	{
		diamond += newDiamond;
		updateResources();
	}

	
	/**
	 * 
	 * Purpose:
	 * 
	 * @return String with current material values
	 */
	public String getResource()
	{
		return "Wood: " + wood + " Stone: " + stone + " Diamond: " + diamond;
	}

	/**
	 * 
	 * @return wood
	 */
	public int getWood()
	{
		return wood;
	}

	/**
	 * 
	 * @return stone
	 */
	public int getStone()
	{
		return stone;
	}

	/**
	 * 
	 * @return diamond
	 */
	public int getDiamond()
	{
		return diamond;
	}

}