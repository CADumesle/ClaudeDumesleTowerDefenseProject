/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
*/

/**
 * 
 * Purpose: The reponsibility of Player is store user's current resources
 *
 */
public class Player 
{
	//a player has wood
	private int wood;
	//a player has stone
	private int stone;
	//a player has diamond
	private int diamond;
	
	//a player has many structures
	//private Structures [] buildings;
	
	public Player(int newWood, int newStone, int newDiamond)
	{
		wood = newWood;
		stone = newStone;
		diamond = newDiamond;
	}
	
	
	public int getWood()
	{
		return wood;
	}
	
	public void addWood(int newWood)
	{
		wood += newWood;
	}
}