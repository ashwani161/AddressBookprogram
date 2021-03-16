package com.address;


public class AdressBook {
	private Contact contacts[] = new Contact[3]; // Array to hold all the contacts
	private int count = 0; // Number of contacts in the array(in address book)
	public String fileName;

	AdressBook(String fileName) {
		this.fileName = fileName;
	}

	// Add Contact
	public boolean addContact(Contact person) {
		if (count < 3) {
			contacts[count] = person;
			count++;
			return true;
		} else {
			return false;
		}

	}

	// Display Contacts
	public void displayContacts() {
		for (int i = 0; i < count; i++) {
			System.out.println("firstName:"+ contacts[i].getfirstName());
			System.out.println("lastName:"+ contacts[i].getlastName());
			System.out.println("address:"+ contacts[i].getAddress());
			System.out.println("city:"+ contacts[i].getCity());
			System.out.println("state:"+ contacts[i].getState());
			System.out.println("zipCode:"+ contacts[i].getZipCode());
			System.out.println("phoneNumber:"+ contacts[i].getPhoneNumber());
			System.out.println("email:"+ contacts[i].getEmail());
		}
	}

}
