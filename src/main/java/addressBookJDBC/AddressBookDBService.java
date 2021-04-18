package addressBookJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;

public class AddressBookDBService {
	private static AddressBookDBService addressBookDBService;
	private static PreparedStatement addressBookDataStatement;
	private static PreparedStatement prepareStatement;

	public static AddressBookDBService getInstance() {
		if (addressBookDBService == null)
			addressBookDBService = new AddressBookDBService();
		return addressBookDBService;
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/AddressBookService?useSSL=false";
		String userName = "root";
		String password = "Ashu@8541";
		Connection connection;
		System.out.println("Connecting to database:" + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is successful!" + connection);
		return connection;
	}

	public List<AddressBookData> getAddressBookDataUsingDB() {
		String sql = "SELECT * FROM AddressBook";
		List<AddressBookData> addressBookList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			addressBookList = this.getPersonData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

	public int updateContactDetails(String name, String address) {
		String sql = String.format("update AddressBook set address = '%s' where Name = '%s';", address, name);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<AddressBookData> getEmployeePayrollData(String name) {
		List<AddressBookData> employeePayrollList = null;
		String sql = "SELECT * from AddressBook  WHERE Name = ?";
		if (this.addressBookDataStatement == null)
			addressBookDataStatement = this.prepareStatementForAddressBook(sql);
		try {
			addressBookDataStatement.setString(1, name);
			ResultSet resultSet = addressBookDataStatement.executeQuery();
			employeePayrollList = this.getPersonData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	private PreparedStatement prepareStatementForAddressBook(String sql) {
		try {
			Connection connection = this.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			return prepareStatement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<AddressBookData> getPersonData(ResultSet resultSet) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String Name = resultSet.getString("name");
				String lastName = resultSet.getString("lastname");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				int zip = resultSet.getInt("zip");
				int phoneNumber = (int) resultSet.getLong("phoneNumber");
				String email = resultSet.getString("email");
				String start = resultSet.getString("Start");
				addressBookList
						.add(new AddressBookData(id, Name, lastName, address, city, state, zip, phoneNumber, email,start));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

	private List<AddressBookData> getPersonDataUsingDB(String sql) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			addressBookList = this.getPersonData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}

	public List<AddressBookData> getPersonDataForDateRange(LocalDate startDate, LocalDate endDate) {
		String sql = String.format("SELECT * FROM AddressBook WHERE START BETWEEN '%s' AND '%s';",
				Date.valueOf(startDate), Date.valueOf(endDate));
		return this.getPersonDataUsingDB(sql);
	}

	public List<AddressBookData> getCount(String city) {
		List<AddressBookData> addressBookDataList = new ArrayList<>();
		String sql = String.format("SELECT * FROM AddressBook where city = '%s';", city);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			addressBookDataList = this.getPersonData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookDataList;
	}

	public List<AddressBookData> getCountByState(String state) {
		List<AddressBookData> addressBookDataList = new ArrayList<>();
		String sql = String.format("SELECT * FROM AddressBook where state = '%s';", state);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			addressBookDataList = this.getPersonData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookDataList;
	}

	public AddressBookData addContact(int id, String Name, String lastName, String address, String city,
			String state, int zip, int phoneNumber, String email,String start) {
		int contactId = -1;
		AddressBookData addressBookData = null;
		String sql = String.format(
				"INSERT INTO AddressBook (id,Name, lastName, address, city, state, zip, phoneNumber, email, start)"
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s')",
				id, Name, lastName, address, city, state, zip, phoneNumber, email,start);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			int rowAffected = statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
			if (rowAffected == 1) {
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next())
					contactId = resultSet.getInt(1);
			}
			addressBookData = new AddressBookData(id, Name, lastName, address, city, state, zip, phoneNumber, email,start);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookData;
	}
}
