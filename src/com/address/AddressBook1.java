package com.address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook1 {
	 static HashMap<String,AddressBook1> addressbooks= new HashMap<String,AddressBook1> ();
	 static ArrayList<Person> contacts = new ArrayList<Person>();

    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("How many address books do you want to create?");
		AddressBook1 addressbook1 = null;
		int addBookCount=s.nextInt();
		for(int i=0;i<addBookCount;i++) {
			System.out.println("Enter address book name:");
			String name= s.next();
			if(addressbooks.containsKey(name)) {
				System.out.println("Address book already exists");
				addressbook1 = addressbooks.get(name);
				i--;
			}else {
				addressbook1= new AddressBook1();
				addressbooks.put(name,addressbook1);

			}
		}
		
		System.out.println("Enter address book name you want to select:");
		String name= s.next();
		if(addressbooks.containsKey(name)) {
		addContact(name,new Person("sai", "pavani","telangana","bhadrachalam"));
		addContact(name,new Person("vishnu", "priya","maharastra","mumbai"));
		addContact(name,new Person("pavani", "reddy","andhra","gudem"));
		addContact(name,new Person("nikil", "pavani","andhra","vizag"));
		}else {
			System.out.println("Address book:"+name+" is not present");

		}
		System.out.println("Enter city or state:");
		String city= s.next().toLowerCase();
		List<Person> result = null;
		for(AddressBook1 add:addressbooks.values()) {
			if (result!=null)
				result.addAll(add.contacts.stream().filter(person -> person.getCity().toLowerCase().contains(city) || person.getState().toLowerCase().contains(city)).collect(Collectors.toList()));
			else
				result=(add.contacts.stream().filter(person -> person.getCity().toLowerCase().contains(city) || person.getState().toLowerCase().contains(city)).collect(Collectors.toList()));

		}
		System.out.println("Contacts in the given location are below:");
        result.forEach(person -> System.out.println(person.toString()));
        System.out.println("Number of persons with given query is:"+result.size());
	
        HashMap<String,ArrayList<Person>> stateDict = new HashMap<String, ArrayList<Person>>();
	    HashMap<String, ArrayList<Person>> cityDict = new HashMap<String, ArrayList<Person>>();
	    for(AddressBook1 add:addressbooks.values()) {
			for(Person per:add.contacts) {
				if(stateDict.containsKey(per.getState())) {
					ArrayList<Person> persons= stateDict.get(per.getState());
					persons.add(per);
					stateDict.put(per.getState(), persons);
					
				}else {
					ArrayList<Person> persons= new ArrayList<Person>();
					persons.add(per);
					stateDict.put(per.getState(),persons);
				}
				if(cityDict.containsKey(per.getCity())) {
					ArrayList<Person> persons= cityDict.get(per.getCity());
					persons.add(per);
					cityDict.put(per.getCity(), persons);
					
				}else {
					ArrayList<Person> persons= new ArrayList<Person>();
					persons.add(per);
					cityDict.put(per.getState(),persons);
				}
			}
		}
	    
	    System.out.println("State with persons are as below");
	    for (String person: stateDict.keySet()) {
	        System.out.println(person + " " + Arrays.asList(stateDict.get(person)));
	    }
	    System.out.println("Cities with persons are as below");
	    for (String person: cityDict.keySet()) {
	        System.out.println(person + " " + Arrays.asList(cityDict.get(person)));
	    }
		
    }
			

		public static boolean addContact(String name,Person person) {
	       for(Person contact: addressbooks.get(name).contacts) {
	    	   if(person.equals(contact)) {
	    		   System.out.println("Contact: "+person.toString()+" already exists");
	    		   return false;
	    	   }
	       }
	       contacts.add(person);
	       System.out.println("Adding contact:"+person.toString());
	       return true;

			
					
    }
}