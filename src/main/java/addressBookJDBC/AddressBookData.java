package addressBookJDBC;

import java.util.Objects;

public class AddressBookData {
	public int id;
	public String Name;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public int zip;
	public int phoneNumber;
	public String email;

	public AddressBookData(int id, String Name, String lastName, String address, String city, String state, int zip,
			int phoneNumber, String email) {
		this.id = id;
		this.Name = Name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddressBookData{" + "id='" + id + '\'' + "Name='" + Name + '\'' + ", lastName='" + lastName + '\''
				+ ", address='" + address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip="
				+ zip + ", phoneNumber=" + phoneNumber + ", email='" + email + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AddressBookData that = (AddressBookData) o;
		return id == that.id && zip == that.zip && phoneNumber == that.phoneNumber && Objects.equals(Name, that.Name)
				&& Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address)
				&& Objects.equals(city, that.city) && Objects.equals(state, that.state)
				&& Objects.equals(email, that.email);
	}
}
