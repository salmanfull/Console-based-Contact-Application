package controller;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Phone;

public class PhoneHandler {
	public void showPhoneNumbers(Phone phoneobj) {
		Map<String, Set<Long>> phone = phoneobj.getPhone();
		out.println();
		out.println(" ************** PHONE ***************** ");
		for (Map.Entry<String, Set<Long>> entry : phone.entrySet()) {
			out.print(entry.getKey() + " : ");
			Set<Long> phoneSet = entry.getValue();
			Iterator<Long> itr = phoneSet.iterator();
			while (itr.hasNext()) {
				out.print(itr.next());
				if (itr.hasNext())
					out.print(", ");
				else
					out.println("");
			}
		}
	}

	public void getPhoneNumbers(Phone phoneobj) {
		Scanner in = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			out.println("Select the type of number : ");
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
			Long number;
			switch (choice) {
			case 1:
				out.println("Enter phone Number : ");
				try {
					number = in.nextLong();
					in.nextLine();
				} catch (Exception e) {
					in.nextLine();
					flag = true;
					out.println("Invalid input. Try again");
					continue;
				}
				addPhoneNumber("Home", number, phoneobj);
				break;
			case 2:
				out.println("Enter phone Number : ");
				try {
					number = in.nextLong();
					in.nextLine();
				} catch (Exception e) {
					flag = true;
					out.println("Invalid input. Try again");
					continue;
				}
				addPhoneNumber("Work", number, phoneobj);
				break;
			case 3:
				out.println("Enter phone type : ");
				String type = in.nextLine();
				out.println("Enter phone Number : ");
				try {
					number = in.nextLong();
				} catch (Exception e) {
					flag = true;
					out.println("Invalid input. Try again");
					continue;
				}
				addPhoneNumber(type, number, phoneobj);
				break;
			default:
				out.println("Invalid input. Try again. ");
				flag = true;
				continue;
			}
			out.println("Do you want to enter more phone numbers. Enter 'y' if yes and any other key if no : ");
			char c = in.next().charAt(0);
			if (c == 'y' || c == 'Y')
				flag = true;
		} while (flag);

	}

	public void addPhoneNumber(String type, long phoneNumber, Phone phoneobj) {
		Map<String, Set<Long>> phone = phoneobj.getPhone();
		Set<Long> phoneSet = (!phone.containsKey(type)) ? (new HashSet<Long>()) : phone.get(type);
		phoneSet.add(phoneNumber);
		phone.put(type, phoneSet);
	}

}
