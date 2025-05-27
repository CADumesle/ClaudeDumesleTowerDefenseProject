import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
 * Purpose: The reponsibility of Enemy is Traverse through the PathTile
 * this class serves as a parent from enemies to inherit from
 * LinkedList
 *
 * Enemy is-a JPanel
 */
public class Enemy extends JPanel
{
	private PathTile currentTile; // Enemy Has-A currentTile
	private Timer timer;// Enemy Has-A Timer
	
	private BufferedImage image; // A Strucure HAS-A image

	private int health; // Enemy HAS-A health
	
	private TowerDefenseModel model;

	/*
	 * Enemy default constructor
	 */
	public Enemy(TowerDefenseModel newModel)
	{
		setHealth(getDesiredHealth());
		
		this.setMinimumSize(newModel.getSize());
		model = newModel;
		
		try
		{
			URL imgURL = getURL();
			image = ImageIO.read(imgURL); // set background image to desired img
											// url
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		timer = new Timer(getMovementSpeed(), new ActionListener()
		{

			// call move method every second
			@Override
			public void actionPerformed(ActionEvent e)
			{
				move();
			}
		});

		timer.start();
	}

	/**
	 * 
	 * Purpose: deplete Enemy health with damage done
	 * 
	 * @param damage
	 */
	public void damageEnemy(int damage)
	{

		health -= damage;
		// if damage reaches 0 or lower delete enemy from game
		
		System.out.println("enemy curr helth: " + health);
		if (health <= 0)
		{
			model.lowerEnemiesLeft(); // lower enemy for tracker
			currentTile.clear(this);
		}
	}

	/**
	 * method called at the start of Path
	 * Purpose: Assign Enemy's current tile to param Tile
	 * 
	 * @param newTile
	 */
	public void spawn(PathTile newTile)
	{
		currentTile = newTile;

	}

	/**
	 * 
	 * Purpose: let enemy traverse through tiles
	 */
	public void move()
	{
		//if tile doesn;t have a next, it's the last tile
		if (currentTile.getNextTile() == null)
		{ // playerLose if enemy gets to ladt tile
			model.playerLose();
		}
		
		// don't move if not on any path tile
		// don't move if there is no next tile
		if ((currentTile != null) && (health > 0))
		{
			// update enemy's current tile
			currentTile.clear(this);

			currentTile = currentTile.getNextTile();

			// add enemy to new Tile
			currentTile.setEnemy(this);
		}
		else
		{
			timer.stop();
		}
	}
	
	/**
	 * Purpose: draw desired image on JPanel
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		// call it parents method
		super.paintComponent(g);
		// draw background on Jpanel if image isn't null
		if (image != null)
		{
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	/**
	 * 
	 * Purpose: Method to be overriden by children
	 * 
	 * @return URL for background image
	 */
	public URL getURL()
	{
		return getClass().getResource("/media/goblin.png");
	}
	
	/**
	 * 
	 * Purpose: defaul moevement speed is 1000ms/s
	 * @return 1000
	 */
	public int getMovementSpeed()
	{
		return 1000;
	}
	
	/**
	 * 
	 * Purpose: method for child classes to override with deisred health for enemy
	 * @return default health, 100
	 */
	public int getDesiredHealth()
	{
		return 100;
	}
	
	/**
	 * 
	 * Purpose: set enemy health to desired
	 * @param newHealth
	 */
	public void setHealth(int newHealth )
	{
		health = newHealth;
	}
	

}