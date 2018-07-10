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
	
	public Game() {
	}

	public Game(GregorianCalendar bought, GregorianCalendar dueBack,
			String title, String name, PlayerType player) {
		super();
		this.bought = bought;
		this.dueBack = dueBack;
		this.title = title;
		this.nameOfRenter = name;
		this.player = player;
	}
	
	public PlayerType getPlayer() {
		return player;
	}

	public void setPlayer(PlayerType player) {
		this.player = player;
	}
	
	public double getCost(GregorianCalendar date) {
		if (date.compareTo(dueBack) <= 0)	
			return 5.00;
		else
			return 15.00;
	}

	public String toString() {
		return "Name: " + nameOfRenter + ", Title: " + title +
				", rented on: " + convertDateToString(bought) +
				", Due back on: " + convertDateToString(dueBack)
				+ ", Game Player: " + player;
	}
	
	
}
