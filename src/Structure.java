import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
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
 * Purpose: The reponsibility of Structure is define main methods of a Structure
 *
 * Structure is-a JPanel
 * Structure is ...
 */
public abstract class Structure extends JPanel
{
	private int row; // A Structure HAS-A position x
	private int col; // A Structure HAS-a position y

	private Tile[][] map; // A Structure HAS-A map

	private BufferedImage baseImage; // A Strucure HAS-A image
	private BufferedImage animatedImage; // A Structure HAS-A image

	/**
	 * 
	 * Purpose: make an empty Strucutre
	 */
	public Structure()
	{

	}

	/*
	 * main constructor for Structure
	 */
	public Structure(TowerDefenseModel newModel, int newRow, int newCol)
	{
		this.setMinimumSize(newModel.getSize());
		row = newRow;
		col = newCol;
		map = newModel.getMap();

		try
		{
			baseImage = ImageIO.read( getImageURL()); // set background image to desired img
											// url
			animatedImage = ImageIO.read(getAnimationURL());
		}
		catch (IOException e)
		{
			e.printStackTrace();
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
		if (baseImage != null)
		{
			g.drawImage(baseImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	/**
	 * 
	 * Purpose: when called shift between normal image and animated in N miliseconds
	 * 
	 */
	public void animate()
	{
		BufferedImage tempBaseImage = baseImage;
		
		
		//setStructure image to the actionImage
		baseImage = animatedImage;
		repaint();	//repaint to display action
		
		//Start a timer for the action image to not dissappear instantly
		Timer animationTimer = new Timer(100, new ActionListener()
		{
			
			//When timer is done, return to BaseImage
			@Override
			public void actionPerformed(ActionEvent e)
			{
				baseImage = tempBaseImage;
				repaint();
				
			}
		});
		
		animationTimer.start();
		animationTimer.setRepeats(false);//Timer shouldn't loop
	}
	
	/**
	 * 
	 * Purpose: decide which Structures can be upgraded by overrision
	 * @return false, by default
	 */
	public boolean isUpgradeable()
	{
		return false;
	}

	/**
	 * 
	 * Purpose: Method to be overriden by children
	 * 
	 * @return URL for Structre image
	 */
	public URL getImageURL()
	{
		return getClass().getResource("/media/structure.png");
	}

	/**
	 * 
	 * Purpose: Method to be overriden by children
	 * 
	 * @return URL for animation image
	 */
	public URL getAnimationURL()
	{
		return getClass().getResource("/media/structure.png");
	}
	
	/*
	 * only used for inherited obj to reconstruct
	 */
	public Structure reconstruct(TowerDefenseModel newMap, int newRow,
			int newCol)
	{
		return null;
	}


	/**
	 * 
	 * Purpose:
	 * 
	 * @return row
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * 
	 * Purpose:
	 * 
	 * @return col
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * 
	 * Purpose: 
	 * @return TowerModel's 2dArray map
	 */
	public Tile[][] getMap()
	{
		return map;
	}
	
	/**
	 * return: name of Structure
	 */
	public String getName()
	{
		return "Structure";
	}
	
	/**
	 * 
	 * Purpose: method for upgradeable defenses to override
	 */
	public void upgrade()
	{
		
	}
	
	/**
	 * 
	 * Purpose: method to be overriden by children to set their own base image
	 * @param newURL
	 */
	public void setBaseImage(URL newURL)
	{
		try
		{
			baseImage = ImageIO.read(newURL);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Purpose:  method to be overriden by chicldren to set their own animated image
	 * @param newURL
	 */
	public void setAnimatedImage(URL newURL)
	{
		try
		{
			animatedImage = ImageIO.read(newURL);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}