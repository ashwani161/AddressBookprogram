package com.address;

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String email;

	public Contact(String firstName, String lastName, String address,
			String city,
			          String state, String zipCode, String phoneNumber, String email){
			        this.firstName = firstName;
			        this.lastName = lastName;
			        this.address = address;
			        this.city = city;
			        this.state = state;
			        this.zipCode = zipCode;
			        this.phoneNumber = phoneNumber;
			        this.email = email;
			    }

			    public String getfirstName() {
			        return this.firstName;
			    }

			    public void setfirstName(String firstName){
			        this.firstName = firstName;
			    }

			    public String getlastName() {
			        return this.lastName;
			    }

			    public void setlastName(String lastName){
			        this.lastName = lastName;
			    }

			    public String getAddress() {
			        return this.address;
			    }

			    public void setAddress(String address){
			        this.address = address;
			    }
			    public String getCity() {
			        return this.city;
			    }

			    public void setCity(String city){
			        this.city = city;
			    }
			    public String getState() {
			        return this.state;
			    }

			    public void setState(String state){
			        this.state = state;
			    }
			    public String getZipCode() {
			        return this.zipCode;
			    }

			    public void setZipCode(String zipCode){
			        this.zipCode = zipCode;
			    }
			    public String getPhoneNumber() {
			        return this.phoneNumber;
			    }

			    public void setPhoneNumber(String phoneNumber){
			        this.phoneNumber = phoneNumber;
			    }
			    public String getEmail() {
			        return this.email;
			    }

			    public void setEmail(String email){
			        this.email = email;
			    }
}
