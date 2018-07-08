package project3;

import java.util.GregorianCalendar;

/**********************************************************************
 * Creates a Game to be rented 
 * 
 * @author Jarod Collier and Ben Burger
 * @version 7/7/18
 *********************************************************************/
public class Game extends DVD {
	/** Represents the type of player */
	private PlayerType player; 

	public Game(GregorianCalendar bought, GregorianCalendar dueBack,
			String title, String name, PlayerType player) {
		super();
		this.bought = bought;
		this.dueBack = dueBack;
		this.title = title;
		this.nameOfRenter = name;
		this.player = player;
	}
	
	
}
