/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TowerDefenseModel extends JPanel{
	
	Tile[][] tiles = new Tile[9][9]; //TDM Has-Many tiles
	
	PathTile nextTile = null; //TDM Has-A nextTile
	
	PathTile startPath; // TDM Has-A startPath
	
	Enemy enemy = new Enemy(); // TDM Has-A Enemy
	
	
	
	MainGame window;
	public TowerDefenseModel(MainGame newWindow)
	{
		window = newWindow;
		setLayout(new GridLayout(9,9));
		
		createMap();
		
		startPath.spawn(enemy);
		

		
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
					
				}
				/////////// add Pathtile's to the middle of the grid'
				else if (k == 4)
				{
					PathTile path = new PathTile(nextTile);
					add(path);
					nextTile = path;
				}
				else// all other Tiles are groundTile
				{
					GroundTile ground = new GroundTile();
					add(ground);
				}

			}
			
		}
	}
	


}