import java.net.URL;

/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
*/

public class LumberYard extends Structure implements Productive
{
	public LumberYard(TowerDefenseModel newMap, int newRow, int newCol)
	{
		super(newMap, newRow, newCol);
	}
	
	
	
	/**
	 * Purpose: made to hold strucutre as a placingStructure
	 */
	public LumberYard()
	{
		// TODO Auto-generated constructor stub
	}


	/**
	 * overriden method to set lumberyard img instead
	 */
	@Override
	protected URL getURL()
	{
		return getClass().getResource("/media/lumberyard.png");
	}
}