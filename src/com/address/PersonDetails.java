package com.address;

public class PersonDetails {
	public String firstName;
	public String lastName;
	public String city;
	public String state;
	public int zip;

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getstate() {
		return state;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public int getzip() {
		return zip;
	}

	public void setzip(int zip) {
		this.zip = zip;
	}

	public PersonDetails(String firstName, String lastName, String city, String state, int zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "[" + this.firstName + ", " + this.lastName + ", " + this.city + ", " + this.state + ", " + this.zip
				+ "]";
	}

}
