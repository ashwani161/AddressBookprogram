package com.address;
import java.util.ArrayList;
import java.util.Comparator;
public class StreamAPI {
	public static void main(String[] args) {
		ArrayList<PersonDetails> list = new ArrayList<>();
		
		list.add(new PersonDetails("ashwani","maddi","bangalore","karnataka",560001));
		list.add(new PersonDetails("surya", "adabala","rajahmundry","andhrapradesh",533101));
		list.add(new PersonDetails("ram", "kathi","bhadrachalam","telangana",507111));
		list.add(new PersonDetails("pavani", "pasupulati","chennai","tamilnadu",600040));
		list.add(new PersonDetails("mounika", "thota","vijayawada","andhrapradesh",520001));
		
		/*list.stream().filter(PersonDetails -> {
			if (PersonDetails.firstName.equals("surya"))
				return true;
			return false;
		}).forEach(personDetails -> System.out.println(personDetails));*/
		
		/*list.stream().sorted(Comparator.comparing(Persondetails -> Persondetails.lastName))
		.forEach(PersonDetails -> System.out.println(PersonDetails));*/
		
		list.stream().sorted(Comparator.comparing(Persondetails -> Persondetails.zip))
		.forEach(PersonDetails -> System.out.println(PersonDetails));
	}

}
