package addressBookJDBC;

import java.sql.SQLException;
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
}
