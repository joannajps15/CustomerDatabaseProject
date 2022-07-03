/*Main Menu of program 
 * Inherits CustomFrame method and displays buttons that user can click to perform varied tasks with the DataBase*/

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.awt.*;

public class MainMenu extends CustomFrame implements ActionListener, WindowListener {
	
	//ATTRIBUTES
	
	//CustomerDataBase
	static CustomerDataBase db;
	static String filename;
	
	//labels
	private JLabel lblTitle;
	
	//buttons
	private JButton[] btnOptions = new JButton[6];
	
	//text
	private String[] options = {"   Find A Customer", "   Add A Customer", "   Delete A Customer", "   Sort By Age", "   Sort By Income", "   Display All"};
	
	//Images
	private ImageIcon[] img = new ImageIcon[6];
	
	//CONSTRUCTOR
	public MainMenu(String filename, String txt) {
		
		super(txt);
		this.filename = filename;
		db = new CustomerDataBase(filename); //creates static object of CustomerDataBase class
		
		//Set Images
		img[0] = new ImageIcon("search.png");
		img[1] = new ImageIcon("add.png");
		img[2] = new ImageIcon("delete.png");
		img[3] = new ImageIcon("rearrange.png");
		img[4] = new ImageIcon("rearrange.png");
		img[5] = new ImageIcon("list.png"); 
		
		//Frame
		frame.addWindowListener(this);
		
		//Title
		lblTitle = new JLabel();
		lblTitle.setBounds(170, 150, 305, 50);
		lblTitle.setText("~ Main Menu ~");
		editFontTitleSize(30);
		lblTitle.setFont(fontTitle);
		lblTitle.setForeground(Color.black);
		
		for(int i = 0; i < 6; i++) {
			//Create Buttons
			btnOptions[i] = new JButton(options[i]);
			btnOptions[i].setBounds(200, 200 + (60 * i), 180, 50);
			btnOptions[i].setFont(fontNormal);
			btnOptions[i].setBackground(clrPlum);
			btnOptions[i].setBorder(null);
			btnOptions[i].setIcon(img[i]);
			btnOptions[i].setHorizontalAlignment(SwingConstants.LEFT);	
			btnOptions[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
			btnOptions[i].addActionListener(this);
			btnOptions[i].setActionCommand("" + i);
		}
		
		addComponents(); //adds new components to frame
	
	}
	
	public void addComponents() {
		frame.add(lblTitle);	
		for(int i = 0; i < 6; i++) {
			frame.add(btnOptions[i]);
		}
	}

	//WindowsListener
	public void windowOpened(WindowEvent e) {
	}
	
	public void windowClosing(WindowEvent e) {
		int exit = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Customer Directory", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(exit == 0) {
			JOptionPane.showMessageDialog(frame, "Thank you for using Customer Directory: the easy way to manage customer databases!", "Thank you", JOptionPane.INFORMATION_MESSAGE);
			db.addToFile(filename);
			System.exit(0);
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {	
	}

	
	public void windowDeactivated(WindowEvent e) {
	}

	//ActionListener
	public void actionPerformed(ActionEvent e) {
	
		//Main Menu Buttons - When buttons are clicked objects are created of according classes that create frames that the user can interact with to perform the intented task
		if(e.getActionCommand().equalsIgnoreCase("0")) {
			search searchFrame = new search("Search Customer Database", db); //so user can display the information of one customer
		}
		else if(e.getActionCommand().equalsIgnoreCase("1")) {
			addACustomer addFrame = new addACustomer("Add Customer", db); //to add a customer
		}
		else if(e.getActionCommand().equalsIgnoreCase("2")) {
			deleteCustomer deleteFrame = new deleteCustomer("Delete Customer", db); //to delete a customer
		}
		else if(e.getActionCommand().equalsIgnoreCase("3")) {
			db.sort(true); //sorts customers by (ascending) age using sort method in CustomerDataBase class
			JOptionPane.showMessageDialog(null, "Customer database has been sorted by AGE (in ascending order)", "Sorted by Age", JOptionPane.INFORMATION_MESSAGE); //displays confirmation message
			displayAll da = new displayAll("Display Customers", db); //shows sorted customers
			btnOptions[2].setActionCommand("age");
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("4")) {
			db.sort(false); //sorts customers by (ascending) income using sort method in CustomerDataBase class
			JOptionPane.showMessageDialog(null, "Customer database has been sorted by INCOME (in ascending order)", "Sorted by Income", JOptionPane.INFORMATION_MESSAGE); //displays confirmation message to user
			displayAll da = new displayAll("Display Customers", db); //displays sorted customers
			btnOptions[3].setActionCommand("income");
		}
		else if(e.getActionCommand().equalsIgnoreCase("5")) {
			displayAll da = new displayAll("Display Customers", db); //displays customers as edited by user
		}
		else if (e.getActionCommand().equalsIgnoreCase("age")) {
			addACustomer addAgeFrame = new addACustomer("Add Customer", db);
			db.sort(true); //if database is sorted by age, resorts database by age
		}
		else if (e.getActionCommand().equalsIgnoreCase("income")) {
			addACustomer addIncomeFrame = new addACustomer("Add Customer", db);
			db.sort(false); //if database is sorted by income, resorts database by income
		}
		
		
	}

}
