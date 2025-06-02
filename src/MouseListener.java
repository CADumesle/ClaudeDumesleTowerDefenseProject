import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * Purpose: The reponsibility of MouseListener is listen on user
 * mouseclicks/place structures on tiles if desired
 *
 * MouseListener is-a MouseAdapter
 */

public class MouseListener extends MouseAdapter
{
	TowerDefenseModel gameModel; // MouseListener HAS-A model

	/**
	 * 
	 * Purpose: Constructor for MouseListener
	 * 
	 * @param newModel
	 */
	public MouseListener(TowerDefenseModel newModel)
	{
		super();// let parent handle construction
		gameModel = newModel; // pass reference of model
	}

	/**
	 * Purpose: Listen when user clicks and get gridbox location of click
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// divide the width of the TDM by its grdlayout dimensions
		int cellWidth = gameModel.getWidth() / gameModel.getDimension();
		int cellHeight = gameModel.getHeight() / gameModel.getDimension();

		// get x and y of click
		int x = e.getX();
		int y = e.getY();

		int col = x / cellWidth;
		int row = y / cellHeight;

		System.out.println("Clicked cell: (" + row + ", " + col + ")");

		// if in placing mode place structure bought and toggle placing mode off
		if (gameModel.isPlacingMode())
		{
			try
			{
				if (gameModel.getMap()[row][col].isPlaceable())
				{
					gameModel.placeStructure(gameModel.getPlacingStructure(), row, col);
					gameModel.togglePlacingMode();
				}
				else
				{
					throw new InvalidTileException();
				}
			}
			catch (InvalidTileException e1) // catch the error and let player try to click on another tile
			{
				e1.printStackTrace();
			}

		}

	}
}