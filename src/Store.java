
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/19/2025
 */

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

		playerResource = newPlayerResource;
		model = newModel;

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
				if( playerResource.getWood() >= 10 )
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
				if( playerResource.getWood() >= 20 )
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
				if( playerResource.getWood() >= 50 )
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