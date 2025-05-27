import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
 * Purpose: The reponsibility of Store is let user get or updrage structures in
 * exchange of resources
 *
 * Store is-a JPanel
 */
public class Store extends JPanel
{
	private PlayerResource playerResource; // Store HAS-A player
	private TowerDefenseModel model; // Store HAS-A model

	/**
	 * 
	 * Purpose: Constructor that passes player and TowerDefenseModel reference
	 * to Store
	 * 
	 * @param newPlayer
	 * @param newModel
	 */
	public Store(PlayerResource newPlayerResource, TowerDefenseModel newModel)
	{

		playerResource = newPlayerResource; //pass a reference to player resouce
		model = newModel; // pass a reference to moddel

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentY(FlowLayout.CENTER);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		setBackground(new Color(196, 164, 132));

		JLabel header = new JLabel("BUY STRUCTURES");
		add(header);

		// button to buy Canon
		JButton canonButton = new JButton("Canon: 10 Wood");
		canonButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( playerResource.getWood() >= 10 ) //  check if player has resources needed
				{
					model.setPlacingStructure(new Canon());
					model.togglePlacingMode(); // activates placing mode
					playerResource.takeWood(10);
				}
			}
		});
		add(canonButton);

		// button to buy archerTower
		JButton archerButton = new JButton("Archer Tower: 20");
		archerButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( playerResource.getWood() >= 20 ) // check if [player has resources needed
				{
					model.setPlacingStructure(new ArcherTower());
					model.togglePlacingMode(); // activates placing mode
					playerResource.takeWood(20);
				}
			}
		});
		add(archerButton);
		
		// button to buy lumberyard
		JButton lumberButton = new JButton("Buy LumbYard: 25 Wood");
		lumberButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( playerResource.getWood() >= 25 )
				{
					model.setPlacingStructure(new LumberYard());
					model.togglePlacingMode(); // activates placing mode
					playerResource.takeWood(25);
				}
			}
		});
		add(lumberButton);

		// Button to buy mineshaft
		JButton mineShaftButton = new JButton("Buy MineShaft: 50 Wood");
		mineShaftButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				if( playerResource.getWood() >= 50 ) //check if player has recources needed
				{
					model.setPlacingStructure(new MineShaft());
					model.togglePlacingMode(); // activates placing mode
					playerResource.takeWood(50);
				}
			}
		});
		add(mineShaftButton);

	}
}