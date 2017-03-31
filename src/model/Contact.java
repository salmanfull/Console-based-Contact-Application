package model;

import static java.lang.System.out;

import model.Email;

public class Contact implements Comparable<Contact> {

	private Name name;
	private Phone phone;
	private Email email;
	private Address address;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int compareTo(Contact c) {
		return this.getName().getFName().compareTo(c.getName().getFName());
	}

}
