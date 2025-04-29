/*
 * Author: Claude-Arthur Dumesle
 * 
 * version/date: 4/14/2025
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//Enemy Is-A JPanel
public class Enemy extends JPanel
{
	private PathTile currentTile; //Enemy Has-A currentTile
	private Timer timer;// Enemy Has-A Timer

	private int health = 100;

	public Enemy() {

		JLabel name = new JLabel("Enemy");
		add(name);

		timer = new Timer(1000, new ActionListener() {

			//call move method every second
			@Override 
			public void actionPerformed(ActionEvent e) {

				move();
			}
		});

		timer.start();
	}

	
	public void damageEnemy(int damage)
	{
		health -= damage;
		//if damage reaches 0 or lower delete enemy from game
	}

	//method called at the start of Path
	//Assign Enemy's current tile to param Tile
	public void spawn(PathTile newTile)
	{
		currentTile = newTile;

	}

	//let enemy traverse through tiles
	public void move() {
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