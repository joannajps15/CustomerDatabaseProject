/*Inherits CustomFrame and creates search frame to allow user to display the information of one customer through the search class in CustomerDataBase*/

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

public class search extends CustomFrame implements ActionListener, KeyListener{
	
	//ATTRIBUTES
	
	//CustomerDataBase
	static CustomerDataBase db;

	//Search Feature
	protected ImageIcon img = new ImageIcon("search.png");
	protected JLabel lblFirstName, lblLastName;
	protected JTextField txtFirstName, txtLastName;
	protected JButton btnSubmit, btnExit, btnClear, btnThat;
	
	//Display Feature
	protected JLabel[] lblInfo = new JLabel[6];
	protected String[] lblText = {"First Name: ", "Last Name: ", "Address: ", "Phone Number: ", "Age", "Income"};
	protected JLabel[] customerValues = new JLabel[6];
	
	//CONSTRUCTOR
	public search(String txt, CustomerDataBase db) {
		
		super(txt);
		search.db = db;
		
		editFontNormalSize(10);
		
		//Search Feature
		lblFirstName = new JLabel("Enter First Name: ");
		lblLastName = new JLabel("Enter Last Name: ");
		
		txtFirstName = new JTextField();
		txtLastName = new JTextField();
		
		btnSubmit = new JButton("SEARCH");
		btnClear = new JButton("Clear");
		btnExit = new JButton("Return to Main Menu");
		
		//Add Components to Frame
		panel.add(lblFirstName);
		panel.add(lblLastName);
		panel.add(txtFirstName);
		panel.add(txtLastName);
		panel.add(btnSubmit);
		panel.add(btnExit);
		panel.add(btnClear);
		
		//First Name Label
		lblFirstName.setBounds(135, 160, 150, 25);
		lblFirstName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		lblFirstName.setHorizontalAlignment(0);
		lblFirstName.setFont(fontNormal);
		lblFirstName.setIcon(img);
		
		//First Name Text Field (for user to enter first name)
		txtFirstName.setBounds(290, 160, 150, 25);
		txtFirstName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		txtFirstName.setFont(fontNormal);
		txtFirstName.setHorizontalAlignment(0);
		txtFirstName.addKeyListener(this);
		txtFirstName.setText(null);
		
		//Last Name Label
		lblLastName.setBounds(135, 190, 150, 25);
		lblLastName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		lblLastName.setHorizontalAlignment(0);
		lblLastName.setFont(fontNormal);
		lblLastName.setIcon(img);
		
		//Last Name Text Field 
		txtLastName.setBounds(290, 190, 150, 25);
		txtLastName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		txtLastName.setFont(fontNormal);
		txtLastName.setHorizontalAlignment(0);
		txtLastName.addKeyListener(this);
		txtLastName.setText(null);
		
		//Search Button
		btnSubmit.setBounds(135, 220, 310, 25);
		btnSubmit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnSubmit.setHorizontalAlignment(0);
		btnSubmit.setBackground(clrPlum);
		btnSubmit.addActionListener(this);
		
		//Clear Button
		btnClear.setBounds(135, 520, 150, 25);
		btnClear.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnClear.setHorizontalAlignment(0);
		btnClear.setBackground(clrPlum);
		btnClear.addActionListener(this);
		
		//Return to Main Menu Button
		btnExit.setBounds(290, 520, 150, 25);
		btnExit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnExit.setHorizontalAlignment(0);
		btnExit.setBackground(clrPlum);
		btnExit.addActionListener(this);
		
		//btnThat - delete button for deleteCustoemr subclass
		btnThat = new JButton("Delete Customer");
		panel.add(btnThat);
		btnThat.setBounds(135, 220, 310, 25);
		btnThat.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnThat.setBackground(clrPlum);
		btnThat.addActionListener(this);
		panel.remove(btnThat);
		
		//Display Feature
		for(int i = 0; i < 6; i++) {
			lblInfo[i] = new JLabel();
			panel.add(lblInfo[i]);
			lblInfo[i].setBounds(135, 250 + (i * 45), 150, 40);
			lblInfo[i].setFont(fontNormal);
			lblInfo[i].setText(lblText[i]);
			lblInfo[i].setBackground(clrPlum);
			lblInfo[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
			
			customerValues[i] = new JLabel();
			panel.add(customerValues[i]);
			customerValues[i].setBounds(290, 250 + (i * 45), 150, 40);
			customerValues[i].setFont(fontNormal);
			customerValues[i].setBackground(clrPlum);
			customerValues[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		}
		
		
	}
	
	//Setter Methods to edit certain values and components for subclasses	
	
	public void setImage(String txt) {
		img = new ImageIcon(txt);
	}
	
	public void setButton(JButton btn, String txt) {
		btn = new JButton(txt);
	}
	
	public void fixButton(JLabel btn, int y) {
		btn.setBounds(290, 170 + (y * 45), 150, 40);
	}
	
	
	public void setTextField(JTextField textField) {
		textField = new JTextField();
	}
	
	
	public void setLabel(JLabel lbl, String txt) {
		lbl = new JLabel(txt);
	}
	
	public void fixLabel(JLabel lbl, int y) {
		lbl.setBounds(30, 170 + (y * 45), 250, 40);
	}
	
	
	//Other Methods
	
	//clear method to clear components of text, and reset background colours of textFields to white
	public void clear() {
		txtFirstName.setText("");
		txtLastName.setText("");
		for(int i = 0; i < 6; i++) {
			customerValues[i].setText("");
		}
		txtFirstName.setBackground(Color.white);
		txtLastName.setBackground(Color.white);
		txtFirstName.requestFocus();
	}

	//ActionListener - when specific buttons are clicked
	public void actionPerformed(ActionEvent e) {
		
		int num;
		
		
		if(e.getSource() == btnSubmit) { //if 'Search' button clicked
				if((txtFirstName.getText() == null ||txtFirstName.getText().equalsIgnoreCase("")) && (txtLastName.getText() == null ||txtLastName.getText().equalsIgnoreCase(""))) {
					//error trapping if both first name and last name text fields are not filled
					JOptionPane.showMessageDialog(frame, "Please fill in required field", "Invalid Input", 0);
					txtFirstName.setBackground(Color.pink);
					txtLastName.setBackground(Color.pink);
				}
				else if(txtFirstName.getText() == null ||txtFirstName.getText().equalsIgnoreCase("")) {
					//error trapping if first name text field is not filled
					JOptionPane.showMessageDialog(frame, "Please fill in required field", "Invalid Input", 0);
					txtFirstName.setBackground(Color.pink);
				}	
				else if(txtLastName.getText() == null ||txtLastName.getText().equalsIgnoreCase("")) {
					//error trapping if last name text field not filled
					JOptionPane.showMessageDialog(frame, "Please fill in required field", "Invalid Input", 0);
					txtLastName.setBackground(Color.pink);
				}
				else {
					//searches database for customer name
					num = db.displayOneCustomer(txtFirstName.getText(), txtLastName.getText());
					
					if(num == db.customerRecords.size()) {
						//error-trap user if customer name is not found
						JOptionPane.showMessageDialog(frame, "Name not found. Please try again", "Invalid Input", 0);
						clear();
						txtFirstName.setBackground(Color.pink);
						txtLastName.setBackground(Color.pink);
					}
					else {
						//returns values pertinent to customer in customerValues labels
						customerValues[0].setText(db.customerRecords.get(num).getFirstName());
						customerValues[1].setText(db.customerRecords.get(num).getLastName());
						
						customerValues[2].setText(db.customerRecords.get(num).getAddressOne() + ", " + db.customerRecords.get(num).getAddressTwo()+ ", " + db.customerRecords.get(num).getAddressThree());
						
						JScrollPane sp = new JScrollPane(customerValues[2], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						sp.setBounds(290, 340, 150, 40);
						sp.setBackground(clrHeliotrope);
						panel.add(sp);
						
						customerValues[3].setText("" + db.customerRecords.get(num).getTelephone());
						customerValues[4].setText("" + db.customerRecords.get(num).getAge());
						customerValues[5].setText("" + db.customerRecords.get(num).getIncome());
					}	
				}
		}
		else if(e.getSource() == btnThat) { //if 'Delete' button called (in deleteCustomer class)
			
			//similar error trapping feature to ensure user submits all required inputs
			if((txtFirstName.getText() == null ||txtFirstName.getText().equalsIgnoreCase("")) && (txtLastName.getText() == null ||txtLastName.getText().equalsIgnoreCase(""))) {
				JOptionPane.showMessageDialog(null, "Please fill in required field", "Invalid Input", 0);
				txtFirstName.setBackground(Color.pink);
				txtLastName.setBackground(Color.pink);
			}
			else if(txtFirstName.getText() == null ||txtFirstName.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please fill in required field", "Invalid Input", 0);
				txtFirstName.setBackground(Color.pink);
			}	
			else if(txtLastName.getText() == null ||txtLastName.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please fill in required field", "Invalid Input", 0);
				txtLastName.setBackground(Color.pink);
			}
			else {
				
				int j;
				
				j = db.displayOneCustomer(txtFirstName.getText(), txtLastName.getText());
				
				if(j != db.customerRecords.size()) {
					//displays message to confirm deletion
					int i = JOptionPane.showConfirmDialog(null, "Please confirm that you would like to delete " + txtFirstName.getText() + " " + txtLastName.getText() + " from the Customer Database", "Confirm Customer Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(i == 0) {
						//if confirmed, customer is deleted from array using CustomerDataBase deleteCustomerRecord class
						db.deleteCustomerRecord(txtFirstName.getText(), txtLastName.getText());
						JOptionPane.showMessageDialog(null, txtFirstName.getText() + " " + txtLastName.getText() + " has been deleted from the customer database", "Successful Deletion", 0);
						clear(); //clears textFeild components once customer is deleted
					}
				}
				else {
					//error traps user if customer name is not found
					JOptionPane.showMessageDialog(null, "Customer not found. Please try again.", "Invalid Input", 0);
					clear();
					txtFirstName.setBackground(Color.pink);
					txtLastName.setBackground(Color.pink);
				}
			}
		}
		else if (e.getSource() == btnClear) {
			clear(); //clears components when 'Clear' Button clicked
		}
		else if (e.getSource() == btnExit){
			frame.dispose(); //deletes frame to return to main menu
		}
		
	}

	//KeyListener
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		//to ensure TextField backgrounds are white when user begins to retype input
		if(e.getSource() == txtFirstName) {
			txtFirstName.setBackground(Color.white);
		}
		else {
			txtLastName.setBackground(Color.white);
		}
			
	}
	
}
