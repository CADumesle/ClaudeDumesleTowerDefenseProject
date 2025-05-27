import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Timer;
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
 */

/**
 * 
 * Purpose: The reponsibility of LumberYard is .produce wood for player
 *
 * LumberYard is-a Structure
 * LumberYard is Productive
 */
public class LumberYard extends Structure 
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

		playerResource = newMap.getPlayerResource(); // pass a reference to players resource

		Timer timer = new Timer(500, new ActionListener()
		{

			// call to add wood to playerresource every 500 millisecond
			@Override
			public void actionPerformed(ActionEvent e)
			{
				animate();
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
	 * @return a LumberYard constructed lumberyard obj
	 */
	public LumberYard reconstruct(TowerDefenseModel newMap, int newRow,
			int newCol)
	{
		return new LumberYard(newMap, newRow, newCol);
	}
	
	/**
	 * Override Structure name
	 * @return "LumberYard"
	 */
	@Override
	public String getName()
	{
		return "LumberYard";
	}
	
	/**
	 * overriden method to set lumberyard img instead
	 */
	@Override
	public URL getImageURL()
	{
		return getClass().getResource("/media/lumberyard.png");
	}
	
	/**
	 * Overriden method to get lumberyard animated img instead
	 */
	@Override
	public URL getAnimationURL()
	{
		return getClass().getResource("/media/AnimatedLumberYard.png");
	}

}