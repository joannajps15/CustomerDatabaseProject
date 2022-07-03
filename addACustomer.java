/*Inherits search class and edits frame components accordingly to create frame that allows user to add a customer to the database*/

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class addACustomer extends search implements ActionListener, KeyListener{
	
	//ATTRIBUTES
	private JTextField[] txtInput = new JTextField[6];
	private JButton btnAdd;
	
	//CONSTRUCTOR
	public addACustomer(String txt, CustomerDataBase db){
		super(txt, db);
		
		//btnAdd - uses ActionListener to add customer
		btnAdd = new JButton("Add Customer");
		panel.add(btnAdd);
		btnAdd.setBounds(135, 475, 305, 25);
		btnAdd.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnAdd.setBackground(clrPlum);
		btnAdd.addActionListener(this);
		
		//removes unnecessary components from addACustomer frame
		panel.remove(txtFirstName);
		panel.remove(txtLastName);
		panel.remove(lblFirstName);
		panel.remove(lblLastName);
		panel.remove(btnSubmit);
		panel.remove(btnThat);
		
		//edits label accordingly for address
		String msg = "Address \n(*Please separate three components by ','):";
		lblInfo[2].setText(msg);
	
		//replaces label and puts textField in place to receive according user input
		for(int i = 0; i < customerValues.length; i++) {	
			txtInput[i] = new JTextField();
			panel.add(txtInput[i]);
			txtInput[i].setBounds(290, 170 + (i * 45), 250, 40);
			txtInput[i].setHorizontalAlignment(0);
			txtInput[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
			txtInput[i].setFont(fontNormal);
			txtInput[i].addKeyListener(this);
			txtInput[i].setText(null);
			
			panel.remove(customerValues[i]);
			
			fixLabel(lblInfo[i], i);
		}
		
	}
	
	//to clear textFields of text
	public void clear() {
		for(int i = 0; i < txtInput.length; i++) {
			txtInput[i].setText("");
			txtInput[i].setBackground(Color.white);
		}
	}

	//ActionListener - when a button is clicked
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAdd) { //when 'Add Customer' button is clicked
			//to error-trap user if textFields are left empty
			if(txtInput[0].getText().equalsIgnoreCase("") || txtInput[1].getText().equalsIgnoreCase("") || txtInput[2].getText().equalsIgnoreCase("") || txtInput[3].getText().equalsIgnoreCase("") || txtInput[4].getText().equalsIgnoreCase("") || txtInput[5].getText().equalsIgnoreCase("")) {
				for(int i = 0; i < txtInput.length; i++) {
					if(txtInput[i].getText().equalsIgnoreCase("")) {
						txtInput[i].setBackground(Color.pink);
					}
				}
				JOptionPane.showMessageDialog(frame, "Please filled in required field", "Invalid Input", 0); //message to alert user of unfilled fields
				
			}
			else { 
				
				//to error trap user in case age or income values are invalid
				try {
					Double.parseDouble(txtInput[5].getText());
				}
				catch(NumberFormatException nf) {
					JOptionPane.showMessageDialog(frame, "Please enter valid input for 'Income'", "Invalid Input", 0);
					txtInput[5].setBackground(Color.pink);
				}
				
				try {
					Integer.parseInt(txtInput[4].getText());
				}
				catch(NumberFormatException nf) {
					JOptionPane.showMessageDialog(frame, "Please enter valid input for 'Age'", "Invalid Input", 0);
					txtInput[4].setBackground(Color.pink);
				}
				
				//to error trap user in case 3 components are not added to 'address' JTextField
				StringTokenizer st = new StringTokenizer(txtInput[2].getText(), ",");
				
				if(st.countTokens() != 3) {
					JOptionPane.showMessageDialog(frame, "Please separate street, city/country, and postal code by ',' (ie: 160 16th Ave E, Markham Ontario, L3P 3K8)", "Invalid Input", 0);
					txtInput[2].setBackground(Color.pink);
				}
				else {
					//adds customer to database
					db.addCustomerRecord(txtInput[0].getText(), txtInput[1].getText(), st.nextToken(), st.nextToken(), st.nextToken(), txtInput[3].getText(), Integer.parseInt(txtInput[4].getText()), Double.parseDouble(txtInput[5].getText()));	
					JOptionPane.showMessageDialog(frame, txtInput[0].getText()+ " " + txtInput[1].getText()+ " has been added to the customer database", "Successful Customer Addition", JOptionPane.INFORMATION_MESSAGE); //msg to alert user that customer was successfully added
					clear();
				}
			}
		}
		else if(e.getSource() == btnClear) {
			clear();
			for(int i = 0; i < txtInput.length; i++) {
				txtInput[i].setBackground(Color.white);
			}
		}
		else{
			frame.dispose();
		}
	}
	
	//KeyListener
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		
		//changes background to white when user retypes information
		if(e.getSource() == txtInput[0]) {
			txtInput[0].setBackground(Color.white);
		}
		else if(e.getSource() == txtInput[1]) {
			txtInput[1].setBackground(Color.white);
		}
		else if(e.getSource() == txtInput[2]) {
			txtInput[2].setBackground(Color.white);
		}
		else if(e.getSource() == txtInput[3]) {
			txtInput[3].setBackground(Color.white);
		}
		else if(e.getSource() == txtInput[4]) {
			txtInput[4].setBackground(Color.white);
		}
		else if(e.getSource() == txtInput[5]) {
			txtInput[5].setBackground(Color.white);
		}
		else{
			frame.dispose();
		}
			
	}
	
	
}
