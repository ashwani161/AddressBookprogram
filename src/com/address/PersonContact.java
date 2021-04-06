package com.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonContact {
	private List<PersonContactData> personContactList;
	
	public PersonContact() {}
	
	public PersonContact(List<PersonContactData>
	                        personContactList) {}
	
	public static void main(String[] args) {
		ArrayList<PersonContactData> personContactList = new ArrayList<>();
		PersonContact personContact = new PersonContact(personContactList);
		Scanner consoleInputReader = new Scanner(System.in);
		personContact.readPersonContactData(consoleInputReader);
		personContact.writePersonContactData();
	}
	
	private void readPersonContactData(Scanner consoleInputReader) {
		System.out.println("Enter First Name: ");
		String firstname = consoleInputReader.next();
		System.out.println("Enter Last Name: ");
		String lastname = consoleInputReader.next();
		System.out.println("Enter Address: ");
		String address = consoleInputReader.next();
		System.out.println("Enter Number: ");
		String number = consoleInputReader.next();
		personContactList.add(new PersonContactData(firstname, lastname, address, number));
		
	}
	
	private void writePersonContactData() {
		System.out.println("\nWriting Person Contact Roaster to Console\n" + personContactList);
	}
	
}
