/*@Author: Sushen Kumar Manchukanti
 *Contact Manager Application
 * Date 09/24/2014
 * User Interface - Data type for storing the contacts in the Array List.
 */
package Manager;
// Class to store the structure of the ArrayList used in state info
public class Data {			//size constraint handled in JFame
	String FirstName;		//20
	String LastName;		//20
	String MiddleInitial;	//35(may be blank; not required)
	String AddressLine1;	//35
	String AddressLine2;    //(35) 	(may be blank; not required)
	String City; 			//(25)
	String State; 			//(2)
	String ZipCode; 		//(9)
	String PhoneNumber; 	//(21)
	String Gender; 			//(1)(Must be M or F)
	String Country;			//(30)
	String Email;			//(100)
/*Constructor to create an object of type data and insert into the "contacts" Array List*/
public Data(String fname,String MInitial,String lname, String Addr1, String Addr2, String city,String state, String zip, String phnum,String gender,String country,String email)
	{
		this.FirstName=fname;
		this.LastName=lname;
		this.MiddleInitial=MInitial;
		this.AddressLine1=Addr1;
		this.AddressLine2=Addr2;
		this.City=city;
		this.State=state;
		this.ZipCode=zip;
		this.PhoneNumber=phnum;
		this.Gender=gender;
		this.Country=country;
		this.Email=email;
	}
}
