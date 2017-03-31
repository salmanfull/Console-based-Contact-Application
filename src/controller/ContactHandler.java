package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import model.Address;
import model.Contact;
import model.ContactHolder;
import model.Email;
import model.Name;
import model.Phone;

public class ContactHandler {
	public void createContact(ContactHolder holder) {
		ArrayList<Contact> contact_list = holder.getContactList();
		Contact contact = new Contact();
		Name name = new Name();
		NameHandler nameHelper = new NameHandler();
		nameHelper.getname(name);
		contact.setName(name);
		Phone phone = new Phone();
		PhoneHandler phoneHelper = new PhoneHandler();
		phoneHelper.getPhoneNumbers(phone);
		contact.setPhone(phone);
		Email email = new Email();
		EmailHandler emailHelper = new EmailHandler();
		emailHelper.getEmails(email);
		contact.setEmail(email);
		Address address = new Address();
		AddressHandler addressHelper = new AddressHandler();
		addressHelper.getAddress(address);
		contact.setAddress(address);
		contact_list.add(contact);
	}

	public void showContacts(ContactHolder holder) {
		ArrayList<Contact> contact_list = holder.getContactList();
		Iterator<Contact> itr = contact_list.iterator();
		while (itr.hasNext()) {
			Contact c = itr.next();
			NameHandler nameHelper = new NameHandler();
			Name name = c.getName();
			nameHelper.showName(name);
			Phone phone = c.getPhone();
			PhoneHandler phoneHelper = new PhoneHandler();
			phoneHelper.showPhoneNumbers(phone);
			Email email = c.getEmail();
			EmailHandler emailHelper = new EmailHandler();
			emailHelper.showemails(email);
			Address address = c.getAddress();
			AddressHandler addressHelper = new AddressHandler();
			addressHelper.printAddress(address);
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------");
		}
	}

	public void deleteContact(ContactHolder holder) {
		Contact c = searchContact(holder, "delete");
		deleteContactFromList(c, holder);
		System.out.println("Contact Successfully deleted.");
	}

	public void deleteContactFromList(Contact c, ContactHolder holder) {
		ArrayList<Contact> contactList = holder.getContactList();
		contactList.remove(c);
	}

	public Contact searchContact(ContactHolder holder, String operation) {
		ArrayList<Contact> contactList = holder.getContactList();
		Collections.sort(contactList);
		Iterator<Contact> itr = contactList.iterator();
		int count = 1;
		while (itr.hasNext()) {
			Contact c = itr.next();
			Name name = c.getName();
			System.out.println(count++ + " : " + name.getFName() + " " + name.getLName());
		}
		int editContact = getContactNo(count - 1, operation);
		count = 1;
		Iterator<Contact> itr2 = contactList.iterator();
		Contact contactToBeReturned = null;
		while (itr2.hasNext()) {
			Contact c = itr2.next();
			if (count++ == editContact) {
				contactToBeReturned = c;
				break;
			}
		}
		return contactToBeReturned;

	}

	public void editContact(ContactHolder holder) {
		Contact contact = searchContact(holder, "edit");
		boolean flag = true;
		int editNumber = 0;
		while (flag) {
			flag = false;
			System.out.println("Select what do you want to edit : ");
			System.out.println("1. Name ");
			System.out.println("2. PhoneNumber");
			System.out.println("3. Email ");
			System.out.println("4. Address ");
			System.out.println("5. Edit Everthing ");
			Scanner in = new Scanner(System.in);
			try {
				editNumber = in.nextInt();
				if (editNumber <= 0 || editNumber > 4)
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				flag = true;
				System.out.println("Invalid Input ");
			}
		}
		switch (editNumber) {
		case 1:
			NameHandler nameHelper = new NameHandler();
			Name name = contact.getName();
			nameHelper.getname(name);
			break;
		case 2:
			PhoneHandler phoneHelper = new PhoneHandler();
			Phone phone = contact.getPhone();
			phoneHelper.getPhoneNumbers(phone);
			break;
		case 3:
			EmailHandler emailHelper = new EmailHandler();
			Email email = contact.getEmail();
			emailHelper.getEmails(email);
			break;
		case 4:
			AddressHandler addressHelper = new AddressHandler();
			Address address = contact.getAddress();
			addressHelper.getAddress(address);
			break;
		case 5:
			deleteContactFromList(contact, holder);
			createContact(holder);
		}
		System.out.println("Contact is successfully edited.");
	}

	public int getContactNo(int count, String operation) {
		int ContactNum = 0;
		boolean flag = true;
		while (flag) {
			flag = false;
			System.out.println("Enter the contact which you want to " + operation + " : ");
			Scanner in = new Scanner(System.in);

			try {
				ContactNum = in.nextInt();
				if (ContactNum <= 0 || ContactNum > count)
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				flag = true;
				System.out.println("Invalid Input ");
			}
		}
		return ContactNum;
	}

}
