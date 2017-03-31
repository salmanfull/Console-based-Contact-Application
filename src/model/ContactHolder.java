package model;
import java.util.ArrayList;

public class ContactHolder {
	
         private ArrayList<Contact> contact_list;
         public ContactHolder(){
        	 contact_list = new ArrayList<Contact>();
         }
         public ArrayList<Contact> getContactList(){
        	 return contact_list;
         }
}
