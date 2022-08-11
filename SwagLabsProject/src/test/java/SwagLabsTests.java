import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.SwagLabsTestBase;
import pages.HomePage;

public class SwagLabsTests extends SwagLabsTestBase{

	@Test
	public void canLogIntoStandardUserAccount() {

		String userName = "standard_user";
		String password = "secret_sauce";
		String expectedUrl = "https://www.saucedemo.com/inventory.html";

		String currentUrl = new HomePage(getDriver(), getBaseUrl())
				.navigate()
				.enterUserName(userName)
				.enterPassword(password)
				.clickLoginButton()
				.retrieveUrl();

		assertEquals(expectedUrl, currentUrl, "The expected url does not match the current url.");
	}
}
