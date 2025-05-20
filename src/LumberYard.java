import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Timer;

/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/19/2025
 */

/**
 * 
 * Purpose: The reponsibility of LumberYard is .produce wood for player
 *
 * LumberYard is-a Structure
 * LumberYard is Productive
 */
public class LumberYard extends Structure implements Productive
{
	private PlayerResource playerResource; // LumberYard HAS-A playerResource

	private int woodProductionRate = 1; // LumberYard HAS-A woodProductionRate

	/**
	 * 
	 * Purpose: create a LumberYard object that interacts with the map
	 * 
	 * @param newMap
	 * @param newRow
	 * @param newCol
	 */
	public LumberYard(TowerDefenseModel newMap, int newRow, int newCol)
	{
		super(newMap, newRow, newCol); // let parent handle constructions

		playerResource = newMap.getPlayerResource();

		Timer timer = new Timer(1000, new ActionListener()
		{

			// call attack every second
			@Override
			public void actionPerformed(ActionEvent e)
			{
				playerResource.addWood(woodProductionRate);

			}
		});

		timer.start();
	}

	/**
	 * Purpose: made to hold strucutre as a placingStructure
	 */
	public LumberYard()
	{

	}

	/**
	 * overriden method to set lumberyard img instead
	 */
	@Override
	public URL getURL()
	{
		return getClass().getResource("/media/lumberyard.png");
	}

	/**
	 * @return a LumberYard constructed lumberyard obj
	 */
	public LumberYard reconstruct(TowerDefenseModel newMap, int newRow,
			int newCol)
	{
		return new LumberYard(newMap, newRow, newCol);
	}

}