package com.address;

public class PersonContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String number;

	public PersonContactData(String firstname, String lastname, String address, String number) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.number = number;
	}

	public String toString() {
		return firstname + "," + lastname + "," + address + "," + number + ",";
	}

}
