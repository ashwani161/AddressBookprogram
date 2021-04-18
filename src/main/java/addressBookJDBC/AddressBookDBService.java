package addressBookJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
	private static AddressBookDBService addressBookDBService;

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
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            addressBookList = getAddressBookDataList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private List<AddressBookData> getAddressBookDataList(ResultSet resultSet) {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String Name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
               // long phone = resultSet.getLong("phoneNumber");
                String email = resultSet.getString("email");
                addressBookDataList.add(new AddressBookData(Name, lastName, address, city, state, zip, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookDataList;
    }

}
