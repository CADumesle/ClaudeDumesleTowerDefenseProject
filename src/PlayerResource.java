
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/19/2025
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * Purpose: The reponsibility of Player is store user's current resources
 *
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

	// a player has-many structuress
	private ArrayList<Structure> structures = new ArrayList<Structure>();

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
	 * Purpose: add a new structure to the list
	 * 
	 * @param newStructure
	 */
	public void addStructure(Structure newStructure)
	{
		structures.add(newStructure);
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

	/**
	 * 
	 * @return structures
	 */
	public ArrayList<Structure> getStructures()
	{
		return structures;
	}
}