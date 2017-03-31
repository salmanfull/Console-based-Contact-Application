package controller;

import static java.lang.System.out;

import java.util.Scanner;

import model.Address;

public class AddressHandler {
	public void getAddress(Address address) {
		Scanner in = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			System.out.println("Enter Door no: ");
			try {
				address.setDoor_no(in.nextInt());
				in.nextLine();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("Invalid input. Try again. ");
				flag = true;
				continue;
			}
		} while (flag);

		System.out.println("Enter Street: ");
		address.setStreet(in.nextLine());
		System.out.println("Enter Area: ");
		address.setArea(in.nextLine());
		System.out.println("Enter city: ");
		address.setCity(in.nextLine());
		System.out.println("Enter State: ");
		address.setState(in.nextLine());
		do {
			flag = false;
			System.out.println("Enter zipcode ");
			try {
				address.setZipcode(in.nextInt());
				in.nextLine();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("Invalid input. Try again. ");
				flag = true;
				continue;
			}
		} while (flag);

	}

	public void printAddress(Address address) {
		System.out.println();
		System.out.println(" ************* ADDRESS **************** ");
		System.out.print("Door no : " + address.getDoor_no());
		System.out.print("        Street : " + address.getStreet());
		System.out.print("	Area : " + address.getArea());
		System.out.print("	City : " + address.getCity());
		System.out.print("	State : " + address.getState());
		System.out.println("  ZipCode : " + address.getZipcode());
	}
}
