package project3;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**********************************************************************
 * Creates a DVD to be rented 
 * 
 * @author Jarod Collier and Ben Burger
 * @version 7/7/18
 *********************************************************************/
public class DVD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** The date the DVD was rented */
	protected GregorianCalendar bought;
	
	/** The date the DVD is due back */
	protected GregorianCalendar dueBack;
	
	/** The title of the DVD */
	protected String title;
	
	/** The name of the person who is renting the DVD */
	protected String nameOfRenter; 

	public DVD() {
	}

	public DVD(GregorianCalendar bought, GregorianCalendar dueBack, String title, String name) {
		super();
		this.bought = bought;
		this.dueBack = dueBack;
		this.title = title;
		this.nameOfRenter = name;
	}

	public GregorianCalendar getBought() {
		return bought;
	}
	
	public void setBought(GregorianCalendar bought) {
		this.bought = bought;
	}
	
	public GregorianCalendar getDueBack() {
		return dueBack;
	}
	
	public void setDueBack(GregorianCalendar dueBack) {
		this.dueBack = dueBack;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNameOfRenter() {
		return nameOfRenter;
	}

	public void setNameOfRenter(String nameOfRenter) {
		this.nameOfRenter = nameOfRenter;
	}

	public double getCost(GregorianCalendar date) {
		return 2.0;
	}
}
