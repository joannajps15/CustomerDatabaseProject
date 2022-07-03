/*Inherits search class and edits components to display frame that user can interact with to delete a customer from the database*/

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

public class deleteCustomer extends search implements ActionListener, KeyListener {
	
	//CONSTRUCTOR
	public deleteCustomer(String txt, CustomerDataBase db) {
		
		super(txt, db);
		
		btnThat = new JButton("Delete Customer");
		panel.add(btnThat);
		btnThat.setBounds(135, 220, 310, 25);
		btnThat.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnThat.setBackground(clrPlum);
		btnThat.addActionListener(this);

		//Remove Unnecessary Components
		panel.remove(btnSubmit);
		
		for(int i = 0; i < 6; i++) {
			panel.remove(lblInfo[i]);
			panel.remove(customerValues[i]);
		}
		
		//Add Components	
		img = new ImageIcon("delete.png");
		lblFirstName.setIcon(img);
		lblLastName.setIcon(img);
		
	}
	
	//KeyListener
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		
		//returns textField background to white when user retypes information in according textField
		if(e.getSource() == txtFirstName) {
			txtFirstName.setBackground(Color.white);
		}
		else {
			txtLastName.setBackground(Color.white);
		}
			
	}
	
}
