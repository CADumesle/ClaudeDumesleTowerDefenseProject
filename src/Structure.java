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
	protected int row; // A Structure HAS-A position x
	protected int col; // A Structure HAS-a position y
	
	protected Tile[][] map; // A Structure HAS-A map
	protected Timer timer; // A Structure HAS-A timer
	
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
	public Structure (TowerDefenseModel newMap, int newRow, int newCol) 
	{
		this.setMinimumSize(newMap.getSize());
		row = newRow;
		col = newCol;
		map = newMap.getMap();
		
        try {
        	URL imgURL = getURL();
            image = ImageIO.read(imgURL); // set background image to desired img url
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Purpose: draw desired image on JPanel
	 */
	@Override
    protected void paintComponent(Graphics g) 
	{
		//call it parents method
        super.paintComponent(g);
        //draw background on Jpanel if image isn't null
        if (image != null) 
        {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
	}
	
	/**
	 * 
	 * Purpose: Method to be overriden by children
	 * @return URL for background image
	 */
	protected URL getURL()
	{
		return getClass().getResource("/media/structure.png");
	}
    
	/*
	 * only used for inherited obj to reconstruct
	 */
	public Structure reconstruct (TowerDefenseModel newMap, int newRow, int newCol) {
		return null;
	}

}