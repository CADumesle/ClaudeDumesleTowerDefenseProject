/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
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
 * Purpose: The reponsibility of Store is let user get or updrage structures in exchange of resources
 *
 * Store is-a JPanel
 */
public class Store extends JPanel 
{
	private Player player;
	private TowerDefenseModel model;
	
	/**
	 * 
	 * Purpose: Constructor that passes player and TowerDefenseModel reference to Store
	 * @param newPlayer
	 * @param newModel
	 */
	public Store(Player newPlayer, TowerDefenseModel newModel) 
	{
		
		player = newPlayer;
		model = newModel;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentY(FlowLayout.CENTER);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		setBackground(new Color(196,164,132));
		
		JLabel header = new JLabel("BUY OR UPGRADE");
		add(header);
		
		//placeholder Button to try defense
		JButton	canonButton = new JButton("Buy Canon");
		canonButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				model.setPlacingStructure(new Canon());
				model.togglePlacingMode(); // activates placing mode
			}
		});
		add(canonButton);
		
		//placeholder Button to try defense
		JButton	lumberButton = new JButton("Buy LumbYards");
		lumberButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				model.setPlacingStructure(new LumberYard());
				model.togglePlacingMode(); // activates placing mode
			}
		});
		add(lumberButton);
		
	}
}