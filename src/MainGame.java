
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
	private Player player;

	/**
	 * 
	 * Purpose: Create a window of the TowerDefenseGame
	 * 
	 * @param newModel
	 */
	public MainGame(TowerDefenseModel newModel)
	{

		model = newModel;
		player = model.getPlayer();

		setTitle("Tower Defense");
		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		Resources resources = new Resources(player);
		add(resources, BorderLayout.NORTH);

		Store store = new Store(player, model);
		add(store, BorderLayout.EAST);

		add(model, BorderLayout.CENTER);

		Store filler = new Store(player, model);
		add(filler, BorderLayout.WEST);

		pack();
	}

	public static void main(String[] args)
	{
		new MainGame(new TowerDefenseModel());

	}

}