import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Purpose: The reponsibility of MouseListener is listen on user
 * mouseclicks/place structures on tiles if desired
 *
 * MouseListener is-a MouseAdapter
 */

public class MouseListener extends MouseAdapter
{
	TowerDefenseModel model; // MouseListener HAS-A model

	/**
	 * 
	 * Purpose: Constructor for MouseListener
	 * 
	 * @param newModel
	 */
	public MouseListener(TowerDefenseModel newModel)
	{
		super();// let parent handle construction
		model = newModel; // pass reference of model
	}

	/**
	 * Purpose: Listen when user clicks and get gridbox location of click
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// divide the width of the TDM by its grdlayout dimensions
		int cellWidth = model.getWidth() / model.getDimension();
		int cellHeight = model.getHeight() / model.getDimension();

		// get x and y of click
		int x = e.getX();
		int y = e.getY();

		int col = x / cellWidth;
		int row = y / cellHeight;

		System.out.println("Clicked cell: (" + row + ", " + col + ")");

		// if in placing mode place structure bought and toggle placing mode off
		if (model.isPlacingMode())
		{
			try
			{
				if (model.getMap()[row][col].isPlaceable())
				{
					model.placeStructure(model.getPlacingStructure(), row, col);
					model.togglePlacingMode();
				}
				else
				{
					throw new InvalidTileException();
				}
			}
			catch (InvalidTileException e1) // catch the error and let player try to click on another tile
			{
				e1.getMessage();
			}

		}

	}
}