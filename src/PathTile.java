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
	

	public PathTile getNextTile()
	{
		
		return nextTile;
	}

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