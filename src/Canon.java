import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Canon extends Structure implements Defense{

	private int range = 2;// A Canon HAS-A range
	private int damage = 10; // A Canon HAS-A damage

	private int row; // A Canon HAS-A position x
	private int col; // A Canon HAS-a position y

	private Tile[][] map; // A Canon HAS-A map
	private Stack<PathTile> atkArea = new Stack<PathTile>(); // A Canon HAS-MANY atkArea

	private Timer timer; // A Canon HAS-A timer

	public Canon (TowerDefenseModel newMap, int newRow, int newCol) {
		map = newMap.getMap();
		row = newRow;
		col = newCol;

		JLabel name = new JLabel("Canon");
		add(name);

		scanMap();
		timer = new Timer(1000, new ActionListener() {

			//call attack every second
			@Override 
			public void actionPerformed(ActionEvent e) {
				attack();
			}
		});

		timer.start();
	}


	public void attack()
	{
		for(PathTile tile: atkArea)// traverse through the stack
		{

			if(tile.getEnemy() != null)
			{
				tile.getEnemy().damageEnemy(damage);
				System.out.println("enemy dmg for: " + damage);
				break; //stop attacking after first enemy hit
			}
		}
	}

	//store all the PathTiles in the range of the defense into atkArea stack
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
					if(map[i][j] instanceof PathTile)//only add Pathtiles into atkArea
					{
//						System.out.println("adding tile r: " + i + " c: " + j);
						atkArea.add((PathTile) map[i][j]);
					}
				}
			}
		}
		catch(IndexOutOfBoundsException e) // ignore possible outofbounds indexes
		{

		}
	}

}

