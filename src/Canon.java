/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/12/2025
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
public class Canon extends Structure implements Defense
{

	private int range = 2;// A Canon HAS-A range
	private int damage = 10; // A Canon HAS-A damage
	private Queue<Tile> atkArea = new LinkedList<Tile>(); // A Canon HAS-MANY atkArea
	

	/**
	 * 
	 * Purpose: construct a canon obj that interacts in the map
	 * @param newMap
	 * @param newRow
	 * @param newCol
	 */
	public Canon (TowerDefenseModel newMap, int newRow, int newCol) 
	{
		
		super(newMap, newRow, newCol); //let parent handle references and paint

	

		scanMap();
		timer = new Timer(1000, new ActionListener() 
		{

			//call attack every second
			@Override 
			public void actionPerformed(ActionEvent e) 
			{
				attack();
			}
		});

		timer.start();
	}

	
	
	//DEFENSE IMPLEMENTATIONS
	
	/**
	 * Purpose: made to hold strucutre as a placingStructure
	 */
	public Canon()
	{
		// TODO Auto-generated constructor stub
	}



	/**
	 * check targetable tiles for enemies, attack closest to base
	 */
	public void attack()
	{
		for(Tile tile: atkArea)// traverse through the stack
		{
			
			if(tile.getEnemy() != null)
			{
				tile.getEnemy().damageEnemy(damage);
				System.out.println("enemy dmg for: " + damage);
				break; //stop attacking after first enemy hit
			}
			
		}
	}


	/**
	 * store all the PathTiles in the range of the defense into atkArea stack
	 */
	public void scanMap() 
	{
		try 
		{
			//traverse through the 2Darr of tiles left->right, top->bottom
			//atkArea is a stack, last items should be first to be scanned when attacking
			for(int i = row - range; i <= row + range; i++) 
			{
				for(int j = col - range; j <= row + range; j++)
				{

					System.out.println("adding tile r: " + i + " c: " + j);
					atkArea.add(map[i][j]);	
				}
			}
		}
		catch(IndexOutOfBoundsException e) // ignore possible outofbounds indexes
		{

		}
	}
	
	/**
	 * Override parent, return canon img instead
	 */
	@Override
	protected URL getURL()
	{
		return getClass().getResource("/media/canon.png");
	}
	
	/**
	 * @param newMap
	 * @param newRow
	 * @param newCol
	 * @return  a constructed canon
	 */
	public Canon reconstruct(TowerDefenseModel newMap, int newRow, int newCol)
	{
		return new Canon(newMap, newRow, newCol);
	}
	
}

