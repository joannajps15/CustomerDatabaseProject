/* FileNameInput class inherits CustomFrame class and takes in file name and uses error-checking to ensure file exists */

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.*;
import java.io.*;

public class FileNameInput extends CustomFrame implements ActionListener {

	//ATTRIBUTES
	private JLabel lblMessage;
	private JTextField txtFileName;
	private JButton btnSubmit;
	
	//CONSTRUCTOR
	public FileNameInput(String txt) {	
		
		super(txt); 
		
		lblMessage = new JLabel("ENTER YOUR FILE NAME: ");	
		txtFileName = new JTextField();
		btnSubmit = new JButton("Submit");
		
		//Adds Components to Panel
		panel.add(lblMessage);
		panel.add(txtFileName);
		panel.add(btnSubmit);
		
		//User Instruction Label
		lblMessage.setHorizontalAlignment(0);
		lblMessage.setBounds(135, 250, 305, 50);
		lblMessage.setFont(fontTitle);
		lblMessage.setOpaque(true);
		lblMessage.setBackground(clrPlum);
		lblMessage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));

		//User Input TextField
		txtFileName.setBounds(135, 300, 305, 50);
		txtFileName.setFont(fontNormal);
		txtFileName.setHorizontalAlignment(0);
		txtFileName.requestFocus();
		txtFileName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		
		//Button for User to Submit File Name
		btnSubmit.setBounds(185, 400, 200, 50);
		btnSubmit.setFont(fontNormal);
		btnSubmit.setBackground(clrPlum);
		btnSubmit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, clrHeliotrope, clrHeliotrope));
		btnSubmit.addActionListener(this);

	}

	//METHODS
	
	//actionPerformed method
	public void actionPerformed(ActionEvent e) {
		
		//to enter main menu when submit button is clicked
		if(e.getSource() == btnSubmit) {
			frame.dispose();
			
			//uses try-catch block to error-trap user when file name is invalid
			try {
				BufferedReader br = new BufferedReader(new FileReader(txtFileName.getText()));
				MainMenu main = new MainMenu(txtFileName.getText(),"Customer Database");
			}
			catch(IOException io) {
				JOptionPane.showMessageDialog(null, "File not found");
				FileNameInput fn = new FileNameInput("File Name Request");
			}
			
		}
		
	}





	
	
	
	
	
	
}
