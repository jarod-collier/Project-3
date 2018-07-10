package project3;

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

/**********************************************************************
 * Creates the Rental Store
 * 
 * @author Jarod Collier and Ben Burger
 * @version 7/7/18
 *********************************************************************/
public class RentalStore extends AbstractListModel {

	private LinkedList<DVD> listDVDs;

	private boolean filter;

	public RentalStore() {
		super();
		filter = false;
		listDVDs = new LinkedList<DVD>();
	}

	public void add (DVD a) {
		listDVDs.add(a);
		fireIntervalAdded(this, 0, listDVDs.size());
	}

	public void remove (DVD a) {
		listDVDs.remove(a);
		fireIntervalRemoved(this, 0, listDVDs.size());
	}

	public DVD get (int i) {
		return listDVDs.get(i);
	}

	public void update() {

	}

	public Object getElementAt(int arg0) {	

		DVD unit = listDVDs.get(arg0);

//		String rentedOnDateStr = DateFormat.getDateInstance(DateFormat.SHORT)
//				.format(unit.getBought().getTime());
		
		String line = unit.toString();

//		String line = "Name: " + " " + listDVDs.get(arg0).getNameOfRenter();
//
//		if (unit instanceof Game)
//			line += ", Car Player: " + ((Game)unit).getPlayer();

		return line;
	}

	public int getSize() {
		//	return 5;
		return listDVDs.size();
	}

	public void saveAsSerializable(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(listDVDs);
			os.close();
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null,"Error in saving db");

		}
	}

	public void loadFromSerializable(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fis);

			listDVDs = (LinkedList<DVD>) is.readObject();
			fireIntervalAdded(this, 0, listDVDs.size() - 1);
			is.close();
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Error in loading db");
		}
	}
}
