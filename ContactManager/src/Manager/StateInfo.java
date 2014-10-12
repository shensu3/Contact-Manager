/*@Author: Sushen Kumar Manchukanti
 *Contact Manager Application
 * Date 09/24/2014
 * User Interface - Class that contains all the logic used for state information of the UI
 */

package Manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;
// class which stores state information for Reading/writing data from the Contact interface.
public class StateInfo {
	// Function that clears up old data in table and adds all data from the "contacts" Array List
	public static void Array_Table()
	{
		for(int j=ContactInterface.table_1.getRowCount()-1;j>=0;j--) // Clears the old data if any ! 
		{
			ContactInterface.tableModel.removeRow(j);
		}
		for(int i=0;i<ContactInterface.contacts.size();i++) // adds all the data from the table data arraylist.
		{
			String temp[]={ContactInterface.contacts.get(i).FirstName,ContactInterface.contacts.get(i).PhoneNumber};
			ContactInterface.tableModel.addRow(temp);
		}
	}
	//Function fills data into the respective text files from a row of the contacts array list depending
	//on the row clicked by the user in the JTable.
	public static void fillData()
	{
		if(ContactInterface.position>=0 && ContactInterface.position < ContactInterface.contacts.size()) //check if row is legitimate
		{
		//Fill up data
		ContactInterface.text_fname.setText(ContactInterface.contacts.get(ContactInterface.position).FirstName);
		ContactInterface.text_midname.setText(ContactInterface.contacts.get(ContactInterface.position).MiddleInitial);
		ContactInterface.text_lname.setText(ContactInterface.contacts.get(ContactInterface.position).LastName);
		ContactInterface.text_addr1.setText(ContactInterface.contacts.get(ContactInterface.position).AddressLine1);
		ContactInterface.text_addr2.setText(ContactInterface.contacts.get(ContactInterface.position).AddressLine2);
		ContactInterface.text_city.setText(ContactInterface.contacts.get(ContactInterface.position).City);
		ContactInterface.text_state.setText(ContactInterface.contacts.get(ContactInterface.position).State);
		ContactInterface.text_zip.setText(ContactInterface.contacts.get(ContactInterface.position).ZipCode);
		ContactInterface.text_phnum.setText(ContactInterface.contacts.get(ContactInterface.position).PhoneNumber);
		ContactInterface.text_gender.setText(ContactInterface.contacts.get(ContactInterface.position).Gender);
		ContactInterface.text_country.setText(ContactInterface.contacts.get(ContactInterface.position).Country);
		ContactInterface.text_email.setText(ContactInterface.contacts.get(ContactInterface.position).Email);
		}
	}
	/*Funtion clears up all the text fields. */
	public static void clear()
	{
		//clear all text fields.
		ContactInterface.text_fname.setText("");
		ContactInterface.text_midname.setText("");
		ContactInterface.text_lname.setText("");
		ContactInterface.text_addr1.setText("");
		ContactInterface.text_addr2.setText("");
		ContactInterface.text_city.setText("");
		ContactInterface.text_state.setText("");
		ContactInterface.text_zip.setText("");
		ContactInterface.text_phnum.setText("");
		ContactInterface.text_gender.setText("");
		ContactInterface.text_country.setText("");
		ContactInterface.text_email.setText("");
	}
}
