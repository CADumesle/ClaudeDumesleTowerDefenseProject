import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * Lead Author(s): Claude-Arthur Dumesle
 * 
 * @author:  Claude-Arthur Dumesle
 * References:
 * 1. Agarwal, P. (2021, November 14). Image processing in java - read and write. GeeksforGeeks. GeeksforGeeks. 
 *Retrieved May 8, 2025, from https://www.geeksforgeeks.org/image-processing-in-java-read-and-write/  
 * 
 * Version/date: 6/1/25
 * 
 * 
 */

/**
 * 
 * Purpose: This file serves as a parent for defensive strucutres to inherit from
 *
 * DEfenseStrucure is-a Structure
 * DefeneStructure is Defense
 * 
 */
public class DefenseStructure extends Structure implements Defense
{
	// A DefenseStrcutre HAS-Many targetAreas
	private Queue<Tile> targetAreas=  new LinkedList<Tile>();// Area when DefStructure can hit an enemy
	
	/**
	 * 
	 * Purpose: construct a DefenseStructure obj that interacts in the map
	 * 
	 * @param newMap
	 * @param newRow
	 * @param newCol
	 */
	public DefenseStructure(TowerDefenseModel newModel, int newRow, int newCol)
	{

		super(newModel, newRow, newCol); // let parent handle references and
											// paint

		scanMap();
		Timer timer = new Timer(1000, new ActionListener()
		{

			// call attack every second
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				attack();
			}
		});

		timer.start();
	}

	// DEFENSE IMPLEMENTATIONS

	/**
	 * Purpose: made to hold structure as a placingStructure
	 */
	public DefenseStructure()
	{
		
	}
	
	/**
	 * @param newMap
	 * @param newRow
	 * @param newCol
	 * @return a constructed canon
	 */
	public DefenseStructure reconstruct(TowerDefenseModel newMap, int newRow,
			int newCol)
	{
		return new DefenseStructure(newMap, newRow, newCol);
	}

	/**
	 * check targetable tiles for enemies, attack closest to base
	 */
	public void attack()
	{
		boolean targetHit = false;
		for (Tile tile : targetAreas)// traverse through the stack
		{
			//if current tile doesn't have enemy and target hit is false
			if ( (tile.getEnemy() != null) && (targetHit != true))
			{
				animate();
				tile.getEnemy().damageEnemy(getDamage());
				System.out.println("enemy dmg for: " + getDamage());
				targetHit = true; // stop attacking after first enemy hit
			}

		}
	}

	/**
	 * store all the PathTiles in the range of the defense into atkArea stack
	 */
	public void scanMap()
	{
		// traverse through the 2Darr of tiles left->right, top->bottom
		// atkArea is a stack, last items should be first to be scanned when
		// attacking
		for (int i = getRow() - getRange(); i <= getRow() + getRange(); i++)
		{


			for (int j = getCol() - getRange(); j <= getCol() + getRange(); j++)
			{

				try
				{
					targetAreas.add(getMap()[i][j]);
				}
				catch (IndexOutOfBoundsException e)
				{
					e.printStackTrace();
				}

			}
		}
	}

	

	/***
	 * 
	 * Override for this class and children to be able to be upgraded
	 */
	@Override
	public boolean isUpgradeable()
	{
		return true;
	}
	
	/**
	 * Override parent, return canon img instead
	 */
	@Override
	public URL getImageURL()
	{
		return getClass().getResource("/media/canon.png");
	}


	/**
	 * 
	 * 
	 * @return DEfense Strucure Damage
	 */
	public int getDamage()
	{
		return 10;
	}

	/**
	 * 
	 * 
	 * @return DEfense Structure Range
	 */
	public int getRange()
	{
		return 2;
	}
}
