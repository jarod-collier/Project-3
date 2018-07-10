package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**********************************************************************
 * Creates the dialogue for when a DVD is rented
 * 
 * @author Jarod Collier and Ben Burger
 * @version 7/7/18
 *********************************************************************/
public class RentDVDDialog extends JDialog implements ActionListener {

	private JTextField titleTxt;
	private JTextField renterTxt;
	private JTextField rentedOnTxt;
	private JTextField DueBackTxt;

	private JButton okButton;
	private JButton cancelButton;
	private boolean closeStatus;

	private DVD unit;

	public RentDVDDialog(JFrame parent, DVD d) {
		// call parent and create a 'modal' dialog
		super(parent, true);

		setTitle("Rent a DVD:");
		closeStatus = false;
		setSize(400, 200);

		unit = d;
		// prevent user from closing window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// instantiate and display text fields

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(6, 2));

		textPanel.add(new JLabel("Your Name:"));
		renterTxt = new JTextField("Ben Burger", 30);
		textPanel.add(renterTxt);

		textPanel.add(new JLabel("Title of DVD:"));
		titleTxt = new JTextField("Step Brothers", 30);
		textPanel.add(titleTxt);

		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		textPanel.add(new JLabel("Rented on Date: "));
		rentedOnTxt = new JTextField(df.format(date), 30);
		textPanel.add(rentedOnTxt);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);  // number of days to add
		date = c.getTime();

		textPanel.add(new JLabel("Due Back: "));
		DueBackTxt = new JTextField(df.format(date), 15);
		textPanel.add(DueBackTxt);

		getContentPane().add(textPanel, BorderLayout.CENTER);

		// Instantiate and display two buttons
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		// if OK clicked the fill the object
		if (button == okButton) {
			// save the information in the object
			closeStatus = true;

			// Sets DVD buyer's name
			unit.setNameOfRenter(renterTxt.getText());

			// Sets the DVD's title
			unit.setTitle(titleTxt.getText());

			// Sets the DVD's date bought
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date date = df.parse(rentedOnTxt.getText());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				unit.setBought(cal);
			}
			catch (ParseException ex) {
				ex.printStackTrace();
			}

			// Sets the DVD's due date
			try {
				Date date = df.parse(DueBackTxt.getText());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				unit.setDueBack(cal);
			}
			catch (ParseException ex) {
				ex.printStackTrace();
			}



		}

		// make the dialog disappear
		dispose();
	}

	public boolean closeOK() {
		return closeStatus;
	}
}
