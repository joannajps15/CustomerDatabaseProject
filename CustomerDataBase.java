/*CustomerDataBase class creates array of customerRecords class and edits customerRecords as prompted in methods*/

import java.util.*;
import javax.swing.*;
import java.io.*;

public class CustomerDataBase {

	//Attributes
	public ArrayList<CustomerRecord> customerRecords = new ArrayList<CustomerRecord>();
	
	//Constructor
	public CustomerDataBase(String filename) {
		
		//try catch block for BufferedReader
		try {
			//reads each line and adds each component into customerRecords ArrayList
			String  line;
			
			BufferedReader br = new BufferedReader(new FileReader(filename));
			line = br.readLine();
			while(line!= null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				
				customerRecords.add(new CustomerRecord(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
				line = br.readLine();
			}
			br.close();
		}
		catch(IOException e) {
		}
		
	}
	
	//addCustomerRecord method allows user to add customer in according alphanumeric location
	public void addCustomerRecord(String firstName, String lastName, String addressOne, String addressTwo, String addressThree, String telephone, int age, double income) {
		
		int i;
		
		for(i = 1; i < customerRecords.size(); i++) {
			if(customerRecords.get(i-1).getLastName().compareToIgnoreCase(lastName) < 0 && customerRecords.get(i).getLastName().compareToIgnoreCase(lastName) > 0) {
				break;
			}
			else if(customerRecords.get(i-1).getLastName().compareToIgnoreCase(lastName) > 0){
				i=0;
				break;
			}
		}
		
		customerRecords.add(i, new CustomerRecord(firstName, lastName, addressOne, addressTwo, addressThree, telephone, age, income));
		
	}
	
	//to delete a customer from the database
	public void deleteCustomerRecord(String firstName, String lastName) {
		
		int i;
		
		for(i = 0; i < customerRecords.size(); i++) {
			if(customerRecords.get(i).getFirstName().compareToIgnoreCase(firstName) == 0 && customerRecords.get(i).getLastName().compareTo(lastName) == 0) {
				break;
			}	
		}
		
		if(i != customerRecords.size()) {
			customerRecords.remove(i);
		}
		else {
			JOptionPane.showMessageDialog(null, "Name not found");
		}
		
	}
	
	public int displayOneCustomer(String firstName, String lastName) {
		int i;
		
		for(i = 0; i < customerRecords.size(); i++) {
			if(customerRecords.get(i).getFirstName().equalsIgnoreCase(firstName) && customerRecords.get(i).getLastName().equalsIgnoreCase(lastName)) {
				break;
			}
		}

		return i;
	}
	
	//to display all records
	public Object[][] displayRecords(Object[][] records) {
		
		//display
		for(int i = 0; i < customerRecords.size(); i++) {
			records[i][0] = customerRecords.get(i).getFirstName();
			records[i][1] = customerRecords.get(i).getLastName();
			records[i][2] = customerRecords.get(i).getAddressOne();
			records[i][3] = customerRecords.get(i).getAddressTwo();
			records[i][4] = customerRecords.get(i).getAddressThree();
			records[i][5] = customerRecords.get(i).getTelephone();
			records[i][6] = customerRecords.get(i).getAge();
			records[i][7] = customerRecords.get(i).getIncome();
		}	
		
		return records; 
		
	}
	
	//to resort array instead by age or income
	public void sort(boolean selection) {
		
		int j;
		CustomerRecord temp;
		
		//sorts by age
		if(selection) {
			
			for(int i = 1; i < customerRecords.size(); i++) {
			
				temp = new CustomerRecord(customerRecords.get(i).getFirstName(), customerRecords.get(i).getLastName(), customerRecords.get(i).getAddressOne(), customerRecords.get(i).getAddressTwo(), customerRecords.get(i).getAddressThree(), customerRecords.get(i).getTelephone(), customerRecords.get(i).getAge(), customerRecords.get(i).getIncome());
				
				for (j = i-1; j >= 0; j--) {
					if((temp.getAge()) < customerRecords.get(j).getAge()) {
						customerRecords.remove(j+1);
						customerRecords.add(j+1, customerRecords.get(j));
					}
					else {
						break;
					}
				}
					
				customerRecords.remove(j+1);
				customerRecords.add(j+1, temp);
				
			}
			
		}
		
		//sorts by income
		else {
			
			for(int i = 1; i < customerRecords.size(); i++) {
				
				temp = new CustomerRecord(customerRecords.get(i).getFirstName(), customerRecords.get(i).getLastName(), customerRecords.get(i).getAddressOne(), customerRecords.get(i).getAddressTwo(), customerRecords.get(i).getAddressThree(), customerRecords.get(i).getTelephone(), customerRecords.get(i).getAge(), customerRecords.get(i).getIncome());
				
				for (j = i-1; j >= 0; j--) {
					if((temp.getIncome()) < customerRecords.get(j).getIncome()) {
						customerRecords.remove(j+1);
						customerRecords.add(j+1, customerRecords.get(j));
					}
					else {
						break;
					}
				}
				
				customerRecords.remove(j+1);
				customerRecords.add(j+1, temp);
				
			}
		}
		
	}

	
	//rewrites file with edits made to database by user
	public void addToFile(String filename) {
		
		String txt = "";
		
		try {
			
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			
			for(int i = 0; i < customerRecords.size(); i++) {
				txt += customerRecords.get(i).getFirstName() + "," + customerRecords.get(i).getLastName() + "," + customerRecords.get(i).getAddressOne() + "," + customerRecords.get(i).getAddressTwo() + "," + customerRecords.get(i).getAddressThree() + "," + customerRecords.get(i).getTelephone() + "," + customerRecords.get(i).getAge() + "," + customerRecords.get(i).getTelephone() + "\n";
			}
			
			pw.write(txt);
			
			pw.close();			
		}
		catch(IOException e) {
			
		}
		
	}
	

	
	
}
