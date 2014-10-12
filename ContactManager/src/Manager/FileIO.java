/*@Author: Sushen Kumar Manchukanti
 *Contact Manager Application
 * Date 09/24/2014
 * User Interface - class to handle all the File IO operations needed for the UI.
 */

package Manager;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// class manages file input outputs. 
public class FileIO {
//loads contents from file "contaxts.txt" to contacts Array List
public static void init()
{
	ContactInterface.position=-1; //initialize row selected to -1 
	try{
		ContactInterface.file= new File("contacts.txt"); //check if file exists
		if(!ContactInterface.file.exists())
		ContactInterface.file.createNewFile(); 			//create one in case it doesn't
		BufferedReader reader = new BufferedReader(new FileReader("contacts.txt")); 
		String line;
		//Read each line from the file and add those fields into a new row in "contacts" Array List.
		while ((line = reader.readLine()) != null) {
			String temp[]=line.split("-");
			ContactInterface.contacts.add(new Data(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8],temp[9],temp[10],temp[11]));
		}
		reader.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
//Function Checks if all the required fields are not null
public static boolean validate()
{
	  if(ContactInterface.text_fname.getText().equals("") ||
	  ContactInterface.text_lname.getText().equals("") ||
	  ContactInterface.text_addr1.getText().equals("") ||
	  ContactInterface.text_city.getText().equals("") ||
	  ContactInterface.text_state.getText().equals("") ||
	  ContactInterface.text_zip.getText().equals("") ||
	  ContactInterface.text_phnum.getText().equals("") ||
	  ContactInterface.text_gender.getText().equals("") ||
	  ContactInterface.text_country.getText().equals("") ||
	  ContactInterface.text_email.getText().equals(""))
	return false;
	  //now check if input is of valid type.  
	  else            
	  {
			 if(
		     ContactInterface.text_fname.getText().matches("[a-zA-Z]*")      &&
		     ContactInterface.text_midname.getText().matches("[a-zA-Z]")     &&
			 ContactInterface.text_lname.getText().matches("[a-zA-Z]*")      &&
			 ContactInterface.text_city.getText().matches("[a-zA-Z]*")       &&
			 ContactInterface.text_state.getText().matches("[a-zA-Z]*")      &&
			 ContactInterface.text_zip.getText().matches("[0-9]*")           &&
			 ContactInterface.text_phnum.getText().matches("[0-9]*")         &&
			 ContactInterface.text_gender.getText().matches("m|f|M|F")       &&
			 ContactInterface.text_country.getText().matches("[a-zA-Z]*")    &&
			 ContactInterface.text_email.getText().contains("@")             &&
			 ContactInterface.text_email.getText().contains("."))
		      return true;
		  else
			  return false;
	  }
}
//Funtion checks if a new record being added already exists.
public static boolean check()
{
	Boolean flag=true;
	for(int i=0;i<ContactInterface.contacts.size();i++)
	{
		if(ContactInterface.contacts.get(i).FirstName.equals(ContactInterface.text_fname.getText())
		   && ContactInterface.contacts.get(i).MiddleInitial.equals(ContactInterface.text_midname.getText())
		   && ContactInterface.contacts.get(i).LastName.equals(ContactInterface.text_lname.getText()))
			flag=false;
	}
	return flag;
}
/*function to write all rows from the "contacts" arraylist back into the file. */
public static void updateFile()
{
	try{
		BufferedWriter out = new BufferedWriter(new FileWriter(ContactInterface.file));
		for (int i = 0; i < ContactInterface.contacts.size(); i++) {
			out.write(ContactInterface.contacts.get(i).FirstName+"-"+ContactInterface.contacts.get(i).MiddleInitial+"-"+
					ContactInterface.contacts.get(i).LastName+"-"+ContactInterface.contacts.get(i).AddressLine1+"-"+
					ContactInterface.contacts.get(i).AddressLine2+"-"+ContactInterface.contacts.get(i).City+"-"+
					ContactInterface.contacts.get(i).State+"-"+ContactInterface.contacts.get(i).ZipCode+"-"+
					ContactInterface.contacts.get(i).PhoneNumber+"-"+ContactInterface.contacts.get(i).Gender+"-"+
					ContactInterface.contacts.get(i).Country+"-"+ContactInterface.contacts.get(i).Email+"-");	
	    	out.newLine();
		}
		out.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
/*Function triggered by Store Jbutton in the UI */
public static void store()
{
	if(validate()==true && check()==true ) // if validation is true and passes the check function.
	{
	ContactInterface.contacts.add(new Data(ContactInterface.text_fname.getText(),ContactInterface.text_midname.getText(),
								  ContactInterface.text_lname.getText(),ContactInterface.text_addr1.getText(),
								  ContactInterface.text_addr2.getText(),ContactInterface.text_city.getText(),
								  ContactInterface.text_state.getText(),ContactInterface.text_zip.getText(),
								  ContactInterface.text_phnum.getText(),ContactInterface.text_gender.getText(),
								  ContactInterface.text_country.getText(),ContactInterface.text_email.getText()));
	StateInfo.Array_Table();	//call array table to refresh table
	updateFile();				//write the updates back into file
	ContactInterface.textField.setForeground(Color.green);
	ContactInterface.textField.setText("Successfully stored !");	//status update in jtext box for user knowledge
	StateInfo.clear();	//clear up all text fields.
	}
	else
	{
		ContactInterface.textField.setForeground(Color.red);
		if(validate()==false)
			ContactInterface.textField.setText("A required Field is empty or invalid data"); //status info for user.
		if(check()==false)
			ContactInterface.textField.setText("Possible duplicate record"); //status info for the user.
	}
}
/*Function triggered by the delete button in the UI */
public static void delete()
{
	if(ContactInterface.position>=0) // if a legitimate row is selected to be deleted
	{
		ContactInterface.contacts.remove(ContactInterface.position); //remove from contacts arraylist
		StateInfo.Array_Table(); //refresh table
		updateFile(); //write change to file
		ContactInterface.textField.setForeground(Color.green);
		ContactInterface.textField.setText("Successfully deleted !"); //status update
	}
	return;
}
/*Triggered by modify Jbutton being pressed */
public static void modify()
{
	if(validate()==true) // if validation checks
	{
		if(ContactInterface.position>=0) // if a proper row is selected to be modified
		{
		//update arraylist of the row position with the values in the textfields
		ContactInterface.contacts.get(ContactInterface.position).FirstName=ContactInterface.text_fname.getText();
		ContactInterface.contacts.get(ContactInterface.position).MiddleInitial=ContactInterface.text_midname.getText();
		ContactInterface.contacts.get(ContactInterface.position).LastName=ContactInterface.text_lname.getText();
		ContactInterface.contacts.get(ContactInterface.position).AddressLine1=ContactInterface.text_addr1.getText();
		ContactInterface.contacts.get(ContactInterface.position).AddressLine2=ContactInterface.text_addr2.getText();
		ContactInterface.contacts.get(ContactInterface.position).City=ContactInterface.text_city.getText();
		ContactInterface.contacts.get(ContactInterface.position).State=ContactInterface.text_state.getText();
		ContactInterface.contacts.get(ContactInterface.position).ZipCode=ContactInterface.text_zip.getText();
		ContactInterface.contacts.get(ContactInterface.position).PhoneNumber=ContactInterface.text_phnum.getText();
		ContactInterface.contacts.get(ContactInterface.position).Gender=ContactInterface.text_gender.getText();
		ContactInterface.contacts.get(ContactInterface.position).Country=ContactInterface.text_country.getText();
		ContactInterface.contacts.get(ContactInterface.position).Email=ContactInterface.text_email.getText();
		StateInfo.Array_Table(); 										//refresh table
		updateFile(); 													//write back the arraylist changes into the file
		StateInfo.clear(); 												//clear all text fields
		ContactInterface.textField.setForeground(Color.green);
		ContactInterface.textField.setText("Successfully Modified !"); 	//success status update
		}
	}
	else
	{
		ContactInterface.textField.setForeground(Color.red);
		ContactInterface.textField.setText("A required Field is empty or invalid data"); //failure to modify status update 
	}
}

}
