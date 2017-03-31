import static java.lang.System.out;

import java.util.Scanner;

import controller.ContactHandler;
import model.ContactHolder;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactHolder holder = new ContactHolder();
		ContactHandler handler = new ContactHandler();
		Scanner in = new Scanner(System.in);
		while (true) {
			out.println("Select an option:");
			out.println("1.Create a new contact");
			out.println("2.Show the list of contacts");
			out.println("3.Edit Contact");
			out.println("4.Delete contact");
			out.println("5.Exit");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				handler.createContact(holder);
				break;
			case 2:
				handler.showContacts(holder);
				break;
			case 3:
				handler.editContact(holder);
				break;
			case 4:
				handler.deleteContact(holder);
				break;
			case 5:
				return;
			default:
				out.println("Invalid input");
			}

		}
	}

}
