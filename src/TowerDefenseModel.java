/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TowerDefenseModel extends JPanel{

	private Tile[][] tiles = new Tile[9][9]; //TDM Has-Many tiles

	PathTile nextTile = null; //TDM Has-A nextTile

	PathTile startPath; // TDM Has-A startPath

	Enemy enemy = new Enemy(); // TDM Has-A Enemy
	
	boolean placingMode = false; // TDM HAS-A placing mode


	MainGame window;
	public TowerDefenseModel()
	{

		setLayout(new GridLayout(9,9));
		createMap();

		startPath.spawn(enemy);
		
		
		
		MouseListener mListener = new MouseListener(this);
		this.addMouseListener(mListener);

	}


	//manually create a course for the player
	public void createMap() {
		//create a 9x9 loop to traverse through grid
		for (int i = 0; i < 9; i++)
		{

			for(int k = 0; k <9; k++)
			{
				/////////// make the the last center Tile of the grid a startPath
				//eEnemis traverse from bottom to top
				if((i == 8) && (k == 4))
				{
					PathTile path = new PathTile(nextTile);
					add(path);
					startPath = path;
					tiles[i][k] = path;

				}
				/////////// add Pathtile's to the middle of the grid'
				else if (k == 4)
				{
					PathTile path = new PathTile(nextTile);
					add(path);
					nextTile = path;
					tiles[i][k] = path;
				}
				else// all other Tiles are groundTile
				{
					GroundTile ground = new GroundTile();
					add(ground);
					tiles[i][k] = ground;
				}

			}

		}
	}
	
	
	public void togglePlacingMode()
	{
		if(placingMode)
		{
			placingMode = false;
		}
		else
		{
			placingMode = true;
		}
	}
	
	public boolean isPlacingMode() 
	{
		return placingMode;
	}
	//place structure in wanted row,col
	public void placeStructure(int row, int col)
	{
		Tile placeArea = tiles[row][col];
		Canon canon = new Canon(this, row, col);
		placeArea.add(canon);
		placeArea.revalidate();
		placeArea.update(getGraphics());
	}
	
	//return: 2d array of tiles tiles
	public Tile[][] getMap(){
		
		return tiles;
	}
}