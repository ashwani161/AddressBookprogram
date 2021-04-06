package AddressBookProgram;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVReaderandWriter {
	private static final String filepath = "C:\\Users\\kathi\\eclipse-workspace\\AddressBookProgram\\src\\main\\java\\AddressBookProgram\\Adressbook.csv";
	private static final String filepath1 = "C:\\Users\\kathi\\eclipse-workspace\\AddressBookProgram\\src\\main\\java\\AddressBookProgram\\Adressbook1.csv";

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		readCsv(filepath);
		writeCsv(filepath1);
	}

	public static boolean readCsv(String filepath) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(filepath));
				CSVReader csvReader = new CSVReader(reader);) {
			// Reading records one by one in a String array
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				System.out.print("Name :" + nextRecord[0]);
				System.out.print("Email :" + nextRecord[1]);
				System.out.print("phoneNumber :" + nextRecord[2]);
				System.out.println("City :" + nextRecord[3]);

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean writeCsv(String filepath1)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(filepath1));) {
			StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			List<Contact> Contact = new ArrayList<>();
			Contact.add(new Contact("Maddi", "Ashwani", "Chandanagar", "Hyd", "telangana", "500050", "9177678541",
					"ashwanin65@gmail.com"));
			Contact.add(new Contact("kathi", "suresh", "nizanpet", "tpg", "andhrapradesh", "534101", "9550192936",
					"kathi4@gmail.com"));

			beanToCsv.write(Contact);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
