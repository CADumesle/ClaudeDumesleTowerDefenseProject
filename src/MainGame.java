import java.awt.BorderLayout;


import javax.swing.JFrame;
/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */
 //MainGame Is-A JFrame
public class MainGame extends JFrame {
	private TowerDefenseModel model;
	public MainGame(TowerDefenseModel newModel) {
		
		model = newModel;
		
		setTitle("Tower Defense");
		setLayout(new BorderLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		//don't use yet
		Player player = new Player(10,10,0); // default materials for player
		
		
		Resources resources = new Resources(player);
		add(resources, BorderLayout.NORTH);
		
		Store store = new Store(player, model);
		add(store, BorderLayout.EAST);	
		
		
		add(model, BorderLayout.CENTER);
		
		Store filler = new Store(player, model);
		add(filler, BorderLayout.WEST);
		
		pack();
	}
	

	public static void main(String[] args) {
		new MainGame(new TowerDefenseModel());

	}
	
}