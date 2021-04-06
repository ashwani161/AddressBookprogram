package AddressBookProgram;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVReaderandWriterTest {
	private static final String filepath = "C:\\Users\\kathi\\eclipse-workspace\\AddressBookProgram\\src\\main\\java\\AddressBookProgram\\Adressbook.csv";
	private static final String filepath1 = "C:\\Users\\kathi\\eclipse-workspace\\AddressBookProgram\\src\\main\\java\\AddressBookProgram\\Adressbook1.csv";

	@Test
	public void givenCSVFileWhenReadShouldReturnTrue() throws IOException {

		OpenCSVReaderandWriter csv = new OpenCSVReaderandWriter();
		boolean result = csv.readCsv(filepath);
		Assert.assertTrue(result);
	}
	@Test
	public void givenCSVFileWhenWriteShouldReturnTrue() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		OpenCSVReaderandWriter csv = new OpenCSVReaderandWriter();
		boolean result = csv.writeCsv(filepath1);
		Assert.assertTrue(result);
	}

}
