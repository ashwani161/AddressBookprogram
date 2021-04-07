package AddressBookProgram;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class JSONFileTest {
	@Test
	public void givenJSONFile_WhenRead_ShouldReturnTrue() {
		JSONFile json = new JSONFile();
		boolean result = json.jsonread();
		Assert.assertTrue(result);
		}
	@Test
	public void givenJSONFile_WhenWrite_ShouldReturnTrue() throws IOException {
		JSONFile json = new JSONFile();
        Contact contact1 = new Contact("Maddi", "Ashwani", "Chandanagar", "Hyd", "Telangana", "500050",
        		"9177678541", "ashwanin65@gmail.com");
        boolean result1 = json.jsonwrite(contact1);
        Assert.assertTrue(result1);
	}

}
