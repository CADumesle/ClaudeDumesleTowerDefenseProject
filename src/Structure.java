
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/5/2025
 */
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

	private BufferedImage image; // A Strucure HAS-A image

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
			URL imgURL = getURL();
			image = ImageIO.read(imgURL); // set background image to desired img
											// url
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

	public Tile[][] getMap()
	{
		return map;
	}

}