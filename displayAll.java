/*Displays All Customers by inheriting CustomFrame class and utilizing JTable,JTableHeader, to display information in a neat manner
 * Sources Used: 
 * https://www.tutorialspoint.com/how-to-change-each-column-width-of-a-jtable-in-java#:~:text=By%20default%20the%20width%20of,()%20method%20of%20JTable%20class.
 * https://www.codejava.net/java-se/swing/a-simple-jtable-example-for-display*/

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

public class displayAll extends CustomFrame implements ActionListener{
	
	static CustomerDataBase db;
	private JLabel lblTitle;
	private JButton btnExit;
	
	public displayAll(String txt, CustomerDataBase db) {
		super(txt);
		
		displayAll.db = db;
		
		lblTitle = new JLabel();
		panel.add(lblTitle);
		lblTitle.setBounds(150, 150, 305, 50);
		lblTitle.setText("~ All Customers ~");
		editFontTitleSize(30);
		lblTitle.setFont(fontTitle);
		lblTitle.setForeground(Color.black);
		
		JLabel lblBlock = new JLabel();
		lblBlock.setBounds(50, 210, 500, 300);
		panel.add(lblBlock);
		
		//Table
	    Object data[][]= new Object[db.customerRecords.size()][8];
	    String column[]={"First Name", "Last Name", "Address Line One", "Address Line Two", "Address Line Three", "Telephone", "Age", "Income"};         
	    
	    data = db.displayRecords(data);
	    JTable tblDisplay = new JTable(data,column);  
	    tblDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    DefaultTableCellRenderer centreCell = new DefaultTableCellRenderer();
	    centreCell.setHorizontalAlignment(JLabel.CENTER);
	    for(int i = 0; i < 8; i++) {
	    	tblDisplay.getColumnModel().getColumn(i).setPreferredWidth(150);
	    	tblDisplay.getColumnModel().getColumn(i).setCellRenderer(centreCell);
	    }
	   
	    JTableHeader header = tblDisplay.getTableHeader();
	    header.setBackground(clrPlum);
	    
	    JScrollPane sp = new JScrollPane(tblDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
	    sp.setBounds(50,210,500,300);  
	    panel.add(sp);
	    
	    
//	    sp.setBackground(clrHeliotrope);
		
		
//		txtCustomerInfo = new JTextArea();
//		txtCustomerInfo.setEditable(false);
//		txtCustomerInfo = db.displayRecords(txtCustomerInfo);
//		JScrollPane sp = new JScrollPane(db.displayRecords(txtCustomerInfo), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		sp.setBounds(50, 210, 500, 300);
//		sp.setBackground(clrHeliotrope);
//		panel.add(sp);
		
		btnExit = new JButton("Return to Main Menu");
		panel.add(btnExit);
		btnExit.addActionListener(this);
		btnExit.setBounds(135, 530, 305, 25);
		btnExit.setBackground(clrPlum);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
		//disposes frame when 'Return to Main Menu' button is clicked
		if(e.getSource() == btnExit) {
			frame.dispose();
		}
		
	}

	
	
}
