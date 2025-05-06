/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
*/


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * Purpose: The reponsibility of TowerDefenseModel is to create a 2D map containing all ingame objects
 *
 * TowerDefenseModel is-a JPanel
 */
public class TowerDefenseModel extends JPanel
{

	private Tile[][] tiles = new Tile[9][9]; //TDM Has-Many tiles

	private PathTile nextTile = null; //TDM Has-A nextTile

	private PathTile startPath; // TDM Has-A startPath

	private Enemy enemy = new Enemy(); // TDM Has-A Enemy
	
	private boolean placingMode = false; // TDM HAS-A placing mode

	private Structure placingStructure;

	/*
	 * Construct defense model
	 */
	public TowerDefenseModel()
	{

		setLayout(new GridLayout(9,9));
		createMap();

		startPath.spawn(enemy);
		
		
		
		MouseListener mListener = new MouseListener(this);
		this.addMouseListener(mListener);

	}



	/**
	 * 
	 * Purpose: manually create a course for the player
	 */
	public void createMap() 
	{
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
	
	/**
	 * 
	 * Purpose: let player in and out of Placing mode
	 */
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
	
	/*
	 * Purpose: check if in placing mode
	 * @return: placingmode
	 */
	public boolean isPlacingMode() 
	{
		return placingMode;
	}
	
	/**
	 * note: maybe change later to a queue.add and let player buy multiple at once
	 * Purpose: keep structure bought stored
	 * @param newStructure
	 */
	public void setPlacingStructure(Structure newStructure)
	{
		placingStructure = newStructure;
	}

	/**
	 * 
	 * Purpose: place structure in wanted row,col
	 * @param row
	 * @param col
	 */
	public void placeStructure(Structure newStructure, int row, int col)
	{
		Tile placeArea = tiles[row][col];
		
		if(newStructure instanceof Canon)
		{
			Canon canon = new Canon(this, row, col);
			placeArea.add(canon, BorderLayout.CENTER);
		}
		else
		{
			LumberYard lumberYard = new LumberYard(this,row,col);
			placeArea.add(lumberYard, BorderLayout.CENTER);
		}
		
		placeArea.revalidate();
		placeArea.update(getGraphics());
	}
	
	/**
	 * 
	 * Purpose: return structure being placed
	 * @return placing structure
	 */
	public Structure getPlacingStructure()
	{
		return placingStructure;
	}
	
	/**
	 * 
	 * @return model's 2d array
	 */
	public Tile[][] getMap()
	{
		
		return tiles;
	}
	
}