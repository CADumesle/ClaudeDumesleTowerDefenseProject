
/**
 * Lead Author(s): Claude-Arthur Dumesle
 *
 * Version: 5/5/2025
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;

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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		add(model.getPlayerResource(), BorderLayout.NORTH);

		Store store = new Store(model.getPlayerResource(), model);
		add(store, BorderLayout.EAST);

		add(model, BorderLayout.CENTER);

		StructureInventory playerStructures = new StructureInventory(
				model.getPlayerResource());
		add(playerStructures, BorderLayout.WEST);

		pack();
	}

	public static void main(String[] args)
	{
		new MainGame(new TowerDefenseModel());

	}

}