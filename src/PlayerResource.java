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
 * 
 * Version/date: 6/1/25
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
	// PlayerResource Has-A woodStoredCounter
	private int woodStoredCounter;
	// PlayerResource HAs-A stoneStoredCounter
	private int stoneStoredCounter;
	// PlayerResource Has-A diamondStoredCounter
	private int diamondStoredCounter;

	private JLabel resourceDisplay; // PlayerResource Has-A resource Display
	


	/**
	 * 
	 * Purpose:  Main Constructor for PlayerResource
	 * @param newWood
	 * @param newStone
	 * @param newDiamond
	 */
	public PlayerResource(int newWood, int newStone, int newDiamond)
	{
		woodStoredCounter = newWood;
		stoneStoredCounter = newStone;
		diamondStoredCounter = newDiamond;

		this.setBackground(new Color(0, 100, 0));
		setLayout(new FlowLayout());
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);

		resourceDisplay = new JLabel(
				"Wood: " + woodStoredCounter + " Stone: " + stoneStoredCounter + " Diamond: " + diamondStoredCounter);
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
		woodStoredCounter -= newWood;
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
		stoneStoredCounter -= newStone;
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
		woodStoredCounter += newWood;
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
		stoneStoredCounter += newStone;
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
		diamondStoredCounter += newDiamond;
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
		return "Wood: " + woodStoredCounter + " Stone: " + stoneStoredCounter + " Diamond: " + diamondStoredCounter;
	}

	/**
	 * 
	 * @return woodStoredCounter
	 */
	public int getWood()
	{
		return woodStoredCounter;
	}

	/**
	 * 
	 * @return stoneStoredCounter
	 */
	public int getStone()
	{
		return stoneStoredCounter;
	}

	/**
	 * 
	 * @return diamondStoredCounter
	 */
	public int getDiamond()
	{
		return diamondStoredCounter;
	}

}