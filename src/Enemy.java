/**
* Lead Author(s): Claude-Arthur Dumesle
*
* Version: 5/5/2025
*/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * Purpose: The reponsibility of Enemy is Traverse through the PathTile LinkedList
 *
 * Enemy is-a JPanel
 */
public class Enemy extends JPanel
{
	private PathTile currentTile; //Enemy Has-A currentTile
	private Timer timer;// Enemy Has-A Timer

	private int health = 100; //  Enemy HAS-A health
	
	/*
	 * Enemy default constructor
	 * 
	 */
	public Enemy() 
	{

		JLabel name = new JLabel("Enemy");
		add(name);

		timer = new Timer(1000, new ActionListener() 
		{

			//call move method every second
			@Override 
			public void actionPerformed(ActionEvent e) 
			{
				move();
			}
		});

		timer.start();
	}

	
	/**
	 * 
	 * Purpose: deplete Enemy health with damage done
	 * @param damage
	 */
	public void damageEnemy(int damage)
	{
		health -= damage;
		//if damage reaches 0 or lower delete enemy from game
	}


	/**
	 * method called at the start of Path
	 * Purpose: Assign Enemy's current tile to param Tile
	 * @param newTile
	 */
	public void spawn(PathTile newTile)
	{
		currentTile = newTile;

	}


	/**
	 * 
	 * Purpose: let enemy traverse through tiles
	 */
	public void move() 
	{
		//dont move if not on any pathtile
		//dont move if there is no next tile
		if((currentTile != null) && (currentTile.getNextTile()) != null)
		{
			//update enemy's current tile
			currentTile.clear();

			currentTile = currentTile.getNextTile();

			//add enemy to new Tile
			currentTile.setEnemy(this);
		}
		else
		{
			timer.stop();
		}
	}

}