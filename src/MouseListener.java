/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/12/2025
*/

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * Purpose: The reponsibility of MouseListener is listen on user mouseclicks/place structures on tiles if desired
 *
 * MouseListener is-a MouseAdapter
 */

public class MouseListener extends MouseAdapter
{
	TowerDefenseModel model; // MouseListener HAS-A model

	/**
	 * 
	 * Purpose: Constructor for MouseListener
	 * @param newModel
	 */
	public MouseListener(TowerDefenseModel newModel) {
		super();//let parent handle construction
		model = newModel;
	}
	

	/**
	 * Purpose: Listen when user clicks and get gridbox location of click
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//divide the width of the TDM by its grdlayout dimensions
		int cellWidth = model.getWidth()/model.getDimension();
		int cellHeight = model.getHeight()/model.getDimension();

		//get x and y of click
		int x = e.getX();
		int y = e.getY();

		int col = x / cellWidth;
		int row = y / cellHeight;

		System.out.println("Clicked cell: (" + row + ", " + col + ")");

		//if in placing mode place structure bought and toggle placing mode off
		if(model.isPlacingMode()) {
			model.placeStructure(model.getPlacingStructure(), row, col);
			model.togglePlacingMode();
		}

	}
}