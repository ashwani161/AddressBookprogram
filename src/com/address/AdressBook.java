package com.address;

import java.util.ArrayList;
import java.util.Scanner;

public class AdressBook {
	private ArrayList<Contact> contacts= new ArrayList<Contact>();  // Array to hold all the contacts
	private int count = 0; // Number of contacts in the array(in address book)
	public String fileName;

	AdressBook() {
	}

	// Add Contact
	public boolean addContact(Contact person) {
		if (count < 3) {
			contacts.add (person);
			count++;
			return true;
		} else {
			return false;
		}

	}
	public boolean editContact(String fname, String lname){
	    for(int i = 0; i<count; i++){
	        if(contacts.get(i).getfirstName().equalsIgnoreCase(fname) && contacts.get(i).getlastName().equalsIgnoreCase(lname)){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter new first name:");
	        String newFirstName=sc.nextLine();
	        System.out.println("Enter new last name:");
	        String newlastName=sc.nextLine();
	        contacts.get(i).setfirstName(newFirstName);
	        	contacts.get(i).setlastName(newlastName);
	        }
	    }
	    return false;
	}
	public boolean removeContact(String fname, String lname){
	    for(int i = 0; i<count; i++){
	        if(contacts.get(i).getfirstName().equals(fname) && contacts.get(i).getlastName().equals(lname)){
	            contacts.remove(i);
	            return true;
	        }
	    }
	    return false;
	}
	// Display Contacts
	public void displayContacts() {
		for (int i = 0; i < count; i++) {
			System.out.println("firstName:"+ contacts.get(i).getfirstName());
			System.out.println("lastName:"+ contacts.get(i).getlastName());
			System.out.println("address:"+ contacts.get(i).getAddress());
			System.out.println("city:"+ contacts.get(i).getCity());
			System.out.println("state:"+ contacts.get(i).getState());
			System.out.println("zipCode:"+ contacts.get(i).getZipCode());
			System.out.println("phoneNumber:"+ contacts.get(i).getPhoneNumber());
			System.out.println("email:"+ contacts.get(i).getEmail());
		}
	}

}
