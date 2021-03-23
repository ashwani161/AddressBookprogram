package com.address;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class Contact1 {
    private static ArrayList<Person> contacts = new ArrayList<Person>();

	public static boolean addContact(Person person) {
       for(Person contact: contacts) {
    	   if(person.equals(contact)) {
    		   System.out.println("Contact: "+person.toString()+" already exists");
    		   return false;
    	   }
       }
       contacts.add(person);
       System.out.println("Adding contact:"+person.toString());
       return true;
		
		
    }
    public static void main(String[] args){
		
		addContact(new Person("sai", "pavani"));
		addContact(new Person("vishnu", "priya"));
		addContact(new Person("pavani", "reddy"));
		addContact(new Person("sai", "pavani"));
		
    }
}
