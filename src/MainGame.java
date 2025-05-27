
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
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
 * Purpose: The reponsibility of MainGame is to display all needed components to
 * play
 *
 * MainGame is-a JFrame
 */
public class MainGame extends JFrame
{
	private TowerDefenseModel model; // MainGame has a model

	/**
	 * 
	 * Purpose: Create a window of the TowerDefenseGame
	 * 
	 * @param newModel
	 */
	public MainGame(TowerDefenseModel newModel)
	{

		model = newModel;

		setTitle("Tower Defense");
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1280,720));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		add(model.getStructureInventory(), BorderLayout.WEST);
		

		add(model.getPlayerResource(), BorderLayout.NORTH);

		Store store = new Store(model.getPlayerResource(), model);
		add(store, BorderLayout.EAST);

		add(model, BorderLayout.CENTER);

		
		add(model.getStructureInventory(), BorderLayout.WEST);

		pack();
	}

	public static void main(String[] args)
	{
		new MainGame(new TowerDefenseModel());

	}
	

	


}