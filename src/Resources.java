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

public class Resources extends JPanel {
	private Player player;
	
	public Resources(Player newPlayer)
	{
		player = newPlayer;
		
		this.setBackground(new Color(0,100,0));
		setLayout(new FlowLayout());
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		
		JLabel playerResources = new JLabel("Resources:");
		add(playerResources);
	}
	
}