package controller;

import static java.lang.System.out;

import java.util.Scanner;

import model.Name;

public class NameHandler {
	public void showName(Name name) {
		out.print("First Name: " + name.getFName());
		out.print("    Last Name: " + name.getLName());
		out.println("    Nick Name: " + name.getNickname());
	}

	public void getname(Name name) {
		out.println("Enter First Name : ");
		Scanner in = new Scanner(System.in);
		// Name name = new Name();
		name.setFname(in.nextLine());
		out.println("Enter last Name : ");
		name.setLName(in.nextLine());
		out.println("Enter Nick Name : ");
		name.setNickname(in.nextLine());
		// in.close();
		// return name;
	}
}
