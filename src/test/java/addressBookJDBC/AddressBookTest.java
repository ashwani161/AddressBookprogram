package addressBookJDBC;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
	AddressBook addressBook;
	List<AddressBookData> addressBookDataList;

	@Test
	public void givenThreeContactsInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws SQLException {
		addressBook = new AddressBook();
		Assert.assertEquals(4, addressBook.readAddressBookData(AddressBook.IOService.DB_IO).size());
	}

	@Test
	public void givenContactDataInDB_whenUpdated_ShouldSyncWithDB() throws SQLException {
		addressBook = new AddressBook();
		addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
		addressBook.updateContact("Nizampet", "Kathi");
		boolean result = addressBook.checkAddressBookInSyncWithDB("Kathi");
		Assert.assertTrue(result);
	}
	
	 @Test
	    public void givenDateRange_WhenContact_ShouldReturnEmpCount() throws SQLException{
	        addressBook = new AddressBook();
	        addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
	        LocalDate startDate = LocalDate.of(2018, 02, 01);
	        LocalDate endDate = LocalDate.now();
	        addressBookDataList = addressBook.readPersonDataForDateRange(startDate, endDate);
	        Assert.assertEquals(3, addressBookDataList.size());
	    }
	 
	 @Test
	    public void givenContactDataInDB_whenCountByState_ShouldMatchWithExpectedValue() {
	        addressBook = new AddressBook();
	        List<AddressBookData>  addressBookDataList = addressBook.countByState("Andhrapradesh");
	        Assert.assertEquals(2, addressBookDataList.size());
	    }
	 
	 @Test
	    public void givenContactDataInDB_whenCountByCity_ShouldMatchWithExpectedValue() {
	        addressBook = new AddressBook();
	        List<AddressBookData>  addressBookDataList = addressBook.countByCity("Hyderabad");
	        Assert.assertEquals(1, addressBookDataList.size());
	    }
	 
	 @Test
	    public void givenNewContactData_WhenAdded_ShouldSyncWithDB() throws SQLException {
	        addressBook = new AddressBook();
	        addressBookDataList = addressBook.readAddressBookData(AddressBook.IOService.DB_IO);
	        addressBook.addContactToAddressBook(6,"Bandaru","sai","HMTcolony","Hyderabad","Telangana",507112,"9177","sai44@yahoo.com","2019-03-02");
	        boolean result = addressBook.checkAddressBookInSyncWithDB("Bandaru");
	        System.out.println("new contact added in Database");
	        Assert.assertTrue(result);
	    }
}
