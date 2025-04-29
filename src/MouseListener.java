import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter{
	TowerDefenseModel model; // MouseListener HAS-A model

	public MouseListener(TowerDefenseModel newModel) {
		super();//let parent handle construction
		model = newModel;
	}
	//Listen when user clicks and get gridbox location of click
	@Override
	public void mouseClicked(MouseEvent e) {
		//divide the width of the TDM by its grdlayout dimensions(int 9 for now)
		int cellWidth = model.getWidth()/9;
		int cellHeight = model.getHeight()/9;

		//get x and y of click
		int x = e.getX();
		int y = e.getY();

		int col = x / cellWidth;
		int row = y / cellHeight;

		System.out.println("Clicked cell: (" + row + ", " + col + ")");

		//if in placing mode place structure bought and toggle placing mode off
		if(model.isPlacingMode()) {
			model.placeStructure(row, col);
			model.togglePlacingMode();
		}

	}
}