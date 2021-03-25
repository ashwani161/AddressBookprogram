package com.address;
import java.util.ArrayList;
import java.util.Comparator;
public class StreamAPI {
	public static void main(String[] args) {
		ArrayList<PersonDetails> list = new ArrayList<>();
		
		list.add(new PersonDetails("ashwani","maddi"));
		list.add(new PersonDetails("surya", "adabala"));
		list.add(new PersonDetails("ram", "kathi"));
		list.add(new PersonDetails("pavani", "pasupulati"));
		list.add(new PersonDetails("mounika", "thota"));
		
		/*list.stream().filter(PersonDetails -> {
			if (PersonDetails.firstName.equals("surya"))
				return true;
			return false;
		}).forEach(personDetails -> System.out.println(personDetails));*/
		
		list.stream().sorted(Comparator.comparing(Persondetails -> Persondetails.lastName))
		.forEach(PersonDetails -> System.out.println(PersonDetails));
	}

}
