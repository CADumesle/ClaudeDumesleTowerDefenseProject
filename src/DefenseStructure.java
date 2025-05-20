
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/19/2025
 */
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
 * 
 * Purpose: The reponsibility of Canon is to detect and lower Enemy HP
 *
 * Canon is-a Structure
 * Canon is Defense
 * 
 */
public class DefenseStructure extends Structure implements Defense
{

	private Queue<Tile> atkArea = new LinkedList<Tile>(); // A Canon HAS-MANY
															// atkAre

	/**
	 * 
	 * Purpose: construct a canon obj that interacts in the map
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
	 * Purpose: made to hold strucutre as a placingStructure
	 */
	public DefenseStructure()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * check targetable tiles for enemies, attack closest to base
	 */
	public void attack()
	{
		for (Tile tile : atkArea)// traverse through the stack
		{

			if (tile.getEnemy() != null)
			{
				tile.getEnemy().damageEnemy(getDamage());
				System.out.println("enemy dmg for: " + getDamage());
				break; // stop attacking after first enemy hit
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
			System.out.println(getRange());

			for (int j = getCol() - getRange(); j <= getCol() + getRange(); j++)
			{

				// System.out.println("adding tile r: " + i + " c: " + j);
				try
				{
					atkArea.add(getMap()[i][j]);
				}
				catch (IndexOutOfBoundsException e)
				{
					// System.out.println("tile: " + i + ","+ j + "not added,
					// OOBounds");
				}

			}
		}
	}

	/**
	 * Override parent, return canon img instead
	 */
	@Override
	public URL getURL()
	{
		return getClass().getResource("/media/canon.png");
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
	 * 
	 * Purpose:
	 * 
	 * @return DEfense Strucure Damage
	 */
	public int getDamage()
	{
		return 10;
	}

	/**
	 * 
	 * Purpose:
	 * 
	 * @return DEfense Structure Range
	 */
	public int getRange()
	{
		return 2;
	}
}
