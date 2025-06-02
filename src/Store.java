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
 * 
 * Version/date: 6/1/25
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
	private TowerDefenseModel gameModel; // Store HAS-A gameModel

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
		gameModel = newModel; // pass a reference to gameModdel

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
					gameModel.setPlacingStructure(new Canon());
					gameModel.togglePlacingMode(); // activates placing mode
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
					gameModel.setPlacingStructure(new ArcherTower());
					gameModel.togglePlacingMode(); // activates placing mode
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
					gameModel.setPlacingStructure(new LumberYard());
					gameModel.togglePlacingMode(); // activates placing mode
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
					gameModel.setPlacingStructure(new MineShaft());
					gameModel.togglePlacingMode(); // activates placing mode
					playerResource.takeWood(50);
				}
			}
		});
		add(mineShaftButton);

	}
}