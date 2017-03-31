package controller;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Email;

public class EmailHandler {
	public void showemails(Email emailobj) {
		Map<String, Set<String>> email = emailobj.getEmail();
		out.println();
		out.println(" ************** EMAIL ***************** ");
		for (Map.Entry<String, Set<String>> entry : email.entrySet()) {
			out.print(entry.getKey() + " : ");
			Set<String> EmailSet = entry.getValue();
			Iterator<String> itr = EmailSet.iterator();
			while (itr.hasNext()) {
				out.print(itr.next());
				if (itr.hasNext())
					out.print(", ");
				else
					out.println("");
			}
		}
	}

	public void getEmails(Email emailobj) {
		Scanner in = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			out.println("Select the type of email : ");
			out.println("1.Home");
			out.println("2.Work");
			out.println("3.Custom");
			int choice;
			try {
				choice = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				in.nextLine();
				out.println("Invalid input. Try again");
				flag = true;
				continue;
			}
			String email;
			switch (choice) {
			case 1:
				out.println("Enter E-mail : ");
				email = in.nextLine();
				addemail("Home", email, emailobj);
				break;
			case 2:
				out.println("Enter E-mail : ");
				email = in.nextLine();
				addemail("Work", email, emailobj);
				break;
			case 3:
				out.println("Enter E-mail type : ");
				String type = in.nextLine();
				out.println("Enter E-mail : ");
				email = in.nextLine();
				addemail(type, email, emailobj);
				break;
			default:
				out.println("Invalid input. Try again. ");
				flag = true;
				continue;
			}
			out.println("Do you want to enter more E-mails. Enter 'y' if yes and any other key if no : ");
			char c = in.next().charAt(0);
			if (c == 'y' || c == 'Y')
				flag = true;
		} while (flag);

	}

	public void addemail(String type, String email_add, Email emailobj) {
		Map<String, Set<String>> email = emailobj.getEmail();
		Set<String> emailSet = (!email.containsKey(type)) ? (new HashSet<String>()) : email.get(type);
		emailSet.add(email_add);
		email.put(type, emailSet);
	}

}
