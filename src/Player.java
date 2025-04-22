/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */

public class Player {
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
}