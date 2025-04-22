/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Store extends JPanel {
	private Player player;
	
	public Store(Player newPlayer) {
		
		player = newPlayer;
		
		setLayout(new FlowLayout());
		setAlignmentY(FlowLayout.CENTER);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		setBackground(new Color(196,164,132));
		
		JLabel header = new JLabel("BUY OR UPGRADE");
		add(header);
		
		
	}
}