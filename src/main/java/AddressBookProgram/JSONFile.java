package AddressBookProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class JSONFile {
	private static final String HOME = System.getProperty("user.dir");
	private static final String filename = "Addressbook.json";
	private static final Path homepath = Paths.get(HOME);
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static void main(String[] args, Contact Contact)
			throws IOException {
		jsonread();
		jsonwrite(Contact);
	}

	public static boolean jsonwrite(Contact contacts) throws IOException {
		if (Files.exists(homepath)) {
			Path filepath = Paths.get(HOME + "/" + filename);
			if (Files.exists(filepath)) {
				String s = gson.toJson(contacts);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(filepath)));
				bufferedWriter.write(s);
				bufferedWriter.close();
			} else {
				Files.createFile(filepath);
				String s = gson.toJson(contacts);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(filepath)));
				bufferedWriter.write(s);
				bufferedWriter.close();
			}
			return true;
		}
		return false;
	}

	public static boolean jsonread() {
		if (Files.exists(homepath)) {
			Path filepath = Paths.get(HOME + "/" + filename);
			try {
				if (Files.exists(filepath)) {
					BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filepath)));
					Contact contactperson = gson.fromJson(br, Contact.class);
					System.out.println("ContactPerson{" + "firstName='" + contactperson.getfirstName() + '\'' +
							", lastName='" + contactperson.getlastName() + '\'' + 
							", address='" + contactperson.getAddress() + '\'' +
							", city='" + contactperson.getCity() + '\'' +
							", state='" + contactperson.getState() + '\'' + 
							", zipCode='" + contactperson.getZipCode() + '\'' + 
							", phoneNumber='" + contactperson.getPhoneNumber() + '\'' + 
							", email='" + contactperson.getEmail() + '\'' + '}');
					return true;
				}
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}
}
