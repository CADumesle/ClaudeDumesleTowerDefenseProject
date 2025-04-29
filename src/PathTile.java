/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PathTile extends Tile{


	private PathTile nextTile;// PathTile Has-A nextTile
	private Enemy currentEnemy; //PathTile Has-A current Enemy

	//param newNextTile
	//constructor that lets TowerDefenseModel set nextTile
	public PathTile(PathTile newNextTile)
	{

		nextTile = newNextTile;
		this.setBackground(new Color(87,65,47));

	}

	//return: pointer to next tile
	public PathTile getNextTile()
	{

		return nextTile;
	}
	
	//return: enemy on current enemy on tile
	//note*: when Enemies are stored in queue update and return earliest enemy
	public Enemy getEnemy()
	{
		return currentEnemy;
	}
	
	//set pointer to nextTile
	public void setNextTile(PathTile newNextTile)
	{
		nextTile = newNextTile;
	}

	//Set currentEnemy for Tile and also, add visually
	public void setEnemy(Enemy newEnemy) {
		currentEnemy = newEnemy;
		add(currentEnemy);
		this.update(getGraphics());
	}

	//use if PathTile is first in path, add enemy
	public void spawn(Enemy newEnemy)
	{
		setEnemy(newEnemy);
		newEnemy.spawn(this);
	}

	//method used when enemy leaves Path
	public void clear()
	{
		remove(currentEnemy);
		currentEnemy = null;

		this.update(getGraphics());
	}
}