/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
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

public class Store extends JPanel {
	private Player player;
	private TowerDefenseModel model;
	
	public Store(Player newPlayer, TowerDefenseModel newModel) {
		
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
		JButton button = new JButton("Buy");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				model.togglePlacingMode(); // activates placing mode
				
			}
		});
		add(button);
	}
}