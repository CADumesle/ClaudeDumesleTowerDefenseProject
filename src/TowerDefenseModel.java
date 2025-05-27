import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
 * 
 */

/**
 * 
 * Purpose: The reponsibility of TowerDefenseModel is to create a 2D map
 * containing all ingame objects
 *
 * TowerDefenseModel is-a JPanel
 */
public class TowerDefenseModel extends JPanel
{
	
	private PlayerResource playerResource = new PlayerResource(30, 10, 0); // TMD
																			// HAS-A
	private StructureInventory structureInventory = new StructureInventory(this);// Player

	private static final int DIMENSION = 9; // TDM HAS-A DIMENSION

	private Tile[][] tiles = new Tile[DIMENSION][DIMENSION]; // TDM Has-Many tile

	private PathTile startPath; // TDM Has-A startPath

	private boolean placingMode = false; // TDM HAS-A placing mode

	private Structure placingStructure; // TDM HAS-A placing Strucure
	
	private ArrayList<Point> pathCoordinates = new ArrayList<Point>(); // TDM HAS-MANY path Coordinates
	
	//TDM HAs-A pointToPathTile map
	private Hashtable<Point,PathTile> pointToPathTile= new Hashtable<Point , PathTile>();
	
	private int enemiesLeft = 10; // TDM HAS-A enemiesLeft int(tracks enemies left before win)
	
	private int enemyCounter = 10; // TDM HAS-A enemyCounter (track howmany more have to spawn)
	
	Timer enemySpawnerTimer; // TDM HAS-A EnemiesSpawnerTimer

	/*
	 * Construct defense model
	 */
	public TowerDefenseModel()
	{
		
		setLayout(new GridLayout(DIMENSION, DIMENSION));
		
		generatePathCoordinates();
		createMap();


		MouseListener mListener = new MouseListener(this);
		this.addMouseListener(mListener);
		

		TowerDefenseModel self = this; // make a reference of itself to pass to actionPerformed
		enemySpawnerTimer = new Timer(10000, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int randomInt = ThreadLocalRandom.current().nextInt(0,3);
				
				if(enemyCounter <= 0)
				{
					enemySpawnerTimer.stop();
				}
				else if(randomInt == 0)
				{
					startPath.spawn(new Orc(self));
				} else
				{
					startPath.spawn(new Goblin(self));
				}
				enemyCounter--;
				System.out.println("EnemyCounteR: " + enemyCounter);
			}
			
		});
		enemySpawnerTimer.start();
	}
	
	/**
	 * 
	 * Purpose: Manually generate points for pathTiles to appear in the grid(in order)
	 */
	public void generatePathCoordinates()
	{
		pathCoordinates.add(new Point(8, 8));
		pathCoordinates.add(new Point(7, 8));
		pathCoordinates.add(new Point(6, 8));
		pathCoordinates.add(new Point(5, 8));
		pathCoordinates.add(new Point(4, 8));
		pathCoordinates.add(new Point(3, 8));
		pathCoordinates.add(new Point(2, 8));
		pathCoordinates.add(new Point(2, 7));
		pathCoordinates.add(new Point(2, 6));
		pathCoordinates.add(new Point(2, 5));
		pathCoordinates.add(new Point(2, 4));
		pathCoordinates.add(new Point(3, 4));
		pathCoordinates.add(new Point(4, 4));
		pathCoordinates.add(new Point(5, 4));
		pathCoordinates.add(new Point(5, 3));
		pathCoordinates.add(new Point(5, 2));
		pathCoordinates.add(new Point(5, 1));
		pathCoordinates.add(new Point(4, 1));
		pathCoordinates.add(new Point(3, 1));
		pathCoordinates.add(new Point(2, 1));
		pathCoordinates.add(new Point(1, 1));
		pathCoordinates.add(new Point(0, 1));
	}
	
	/**
	 * 
	 * Purpose:Connect All pathTiles in the order of the List created 
	 * 
	 */
	public void connectPath()
	{
		//Traverse through the the PathTile List Created(in order)
		for (int i = 0; i < pathCoordinates.size() - 1; i++)
		{
			Point currentPoint = pathCoordinates.get(i); // define current point
			Point nextPoint = pathCoordinates.get(i+1); // define next point
			
			//get the tile that corresponds to the currentpoint from PointToPathTile map
		    PathTile currentTile = pointToPathTile.get(currentPoint);
			//get the tile that corresponds to the nextpoint from PointToPathTile map
		    PathTile nextTile = pointToPathTile.get(nextPoint);

		    //set current tile to the next
		    currentTile.setNextTile(nextTile);
		}
		
		//start path to spawn enemies
		startPath = pointToPathTile.get(pathCoordinates.get(0));
		

	}

	/**
	 * 
	 * Purpose: Add desired tiles to the grid to a 2d array and the gridlayout of panel
	 */
	public void createMap()
	{
		// create a loop to traverse through grid's dimensions (9x9)
		for (int i = 0; i < DIMENSION; i++)
		{

			for (int k = 0; k < DIMENSION; k++)
			{
				
				Point currentPoint = new Point(i,k); //save reference to current point(x,y)
				
				if (pathCoordinates.contains(currentPoint)) // If that current point is in out list
				{
					PathTile path = new PathTile(null); // add a Path tile with a null pointer
					add(path);
					
					//put pathTile with correspoinging point found
					pointToPathTile.put(currentPoint, path);
					
					//add pathTile to 2darray
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
		
		connectPath(); // connect all paths
	}
	
	/**
	 * 
	 * Purpose: called to lower enemies left and check for player win
	 */
	public void lowerEnemiesLeft()
	{
		 enemiesLeft --; 
		 if(enemiesLeft <=0)
		 {
			 playerWin();
		 }
	}
	
	/**
	 * 
	 * Purpose: let player in and out of Placing mode
	 */
	public void togglePlacingMode()
	{
		if (placingMode)
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
	 * note: maybe change later to a queue.add and let player buy multiple at
	 * once
	 * Purpose: keep structure bought stored
	 * 
	 * @param newStructure
	 */
	public void setPlacingStructure(Structure newStructure)
	{
		placingStructure = newStructure;
	}
	

	/**
	 * 
	 * Purpose: place structure in wanted row,col
	 * 
	 * @param row
	 * @param col
	 */
	public void placeStructure(Structure newStructure, int row, int col)
	{
		Tile placeArea = tiles[row][col];

		newStructure = newStructure.reconstruct(this, row, col);
		placeArea.add(newStructure,
				BorderLayout.CENTER);

		placeArea.revalidate();
		placeArea.update(getGraphics());
		
		structureInventory.addToInventory(newStructure);
	}

	/**
	 * 
	 * Purpose: return structure being placed
	 * 
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

	/**
	 * 
	 * @return DIMENSION
	 */
	public int getDimension()
	{
		return DIMENSION;
	}

	/**
	 * 
	 * 
	 * @return playerResource
	 */
	public PlayerResource getPlayerResource()
	{
		return playerResource;
	}
	
	/**
	 * 
	 *
	 * @return structureInventory
	 */
	public StructureInventory getStructureInventory()
	{
		return structureInventory;
	}
	
	/**
	 * 
	 * Purpose: Let's player save his Stats when game was won GameWingStatFile
	 */
	public void writeStatToFile() 
	{
		
		File inputFile = new File("C:\\Users\\claud\\git\\ClaudeDumesleTowerDefenseProject\\src\\GameWinStatFile");
		
		PrintWriter outputFileWriter = null;
		try
		{
			//Create a PrintWriter object for outputFile
			outputFileWriter = new PrintWriter(inputFile);

			//"write" to the writer
			outputFileWriter.println((playerResource.getResource()));

			//Once you are done "writing", close the file.
			outputFileWriter.close();

		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Cannot write file. File will not be written.");
		}
		finally
		{
			//Once you are done "writing", close the file.
			if(outputFileWriter!=null)
			{
				outputFileWriter.close();
			} 
		}
		
		
	}
	
	/**
	 * 
	 * Purpose: Notify player win and write stats into a file if desired
	 */
	public void  playerWin()
	{
		JOptionPane.showMessageDialog(null, "No Enemies Left.. - You Win!");
		
		int saveOption = JOptionPane.showConfirmDialog(null, "Want to save stats?","Select an Option", JOptionPane.YES_NO_OPTION);
		
		if(saveOption == JOptionPane.YES_OPTION)
		{
			writeStatToFile();
		}
		System.exit(0);
	}
	
	/**
	 * 
	 * 
	 * Purpose: notify if player lost
	 */
	public void playerLose()
	{
		JOptionPane.showMessageDialog(null, "Enemy entered Village.. You Lose.");
		System.exit(0);// close game after message
	}
	
}