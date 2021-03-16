package com.address;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		AdressBook addressbook = new AdressBook("Info.txt");

		Scanner s = new Scanner(System.in);

		boolean quit = false;
		while (!quit) {
			System.out.println("What would you like to do?");
			System.out.println(" 1) Display all contacts");
			System.out.println(" 2) Add a contact");
			System.out.println(" 3) Edit a contact");
			System.out.println(" 4) Delete a contact");
			System.out.println(" 5) Exit");

			switch (s.nextInt()) {
			case 1:
				addressbook.displayContacts();
				break;
			case 2:
				System.out.println("First Name: ");
				String firstName = s.next();
				System.out.println("Last Name: ");
				String lastName = s.next();
				System.out.println("Address: ");
				String address = s.next();
				System.out.println("City: ");
				String city = s.next();
				System.out.println("State: ");
				String state = s.next();
				System.out.println("ZipCode: ");
				String zipCode = s.next();
				System.out.println("Phone Number: ");
				String phoneNumber = s.next();
				System.out.println("Email: ");
				String email = s.next();
				addressbook.addContact(new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
				break;
			case 3:
			    System.out.println("Enter in first name to edit : ");
			    String firstname = s.next();
			    System.out.println("Enter in last name to edit : ");
			    String lastname = s.next();

			    addressbook.editContact(firstname, lastname);
			    break;
			case 4:
			    System.out.println("Enter in first name: ");
			    String firstname1 = s.next();
			    System.out.println("Enter in last name: ");
			    String lastname1 = s.next();

			    addressbook.removeContact(firstname1, lastname1);
			    break;
			case 5:
				quit = true;
				break;
			}
		}
	}
}