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

	@Test
	public void canAddSauceLabsBackpackToCart() {

		String userName = "standard_user";
		String password = "secret_sauce";
		String item = "Sauce Labs Backpack";

		String itemInCart = new HomePage(getDriver(), getBaseUrl())
				.navigate()
				.enterUserName(userName)
				.enterPassword(password)
				.clickLoginButton()
				.addItemToCart(item)
				.viewCart()
				.retrieveItemTitle();

		assertEquals(item, itemInCart, "The expected item does not match the item in the cart.");
	}

	@Test
	public void canCompleteCheckoutWithSauceLabsOnesie() {

		String userName = "standard_user";
		String password = "secret_sauce";
		String item = "Sauce Labs Onesie";
		String firstName = "John";
		String lastName = "Doe";
		String postalCode = "13579";
		String expectedConfirmation = "CHECKOUT: COMPLETE!";

		String actualConfirmation = new HomePage(getDriver(), getBaseUrl())
				.navigate()
				.enterUserName(userName)
				.enterPassword(password)
				.clickLoginButton()
				.addItemToCart(item)
				.viewCart()
				.clickCheckoutButton()
				.enterFirstName(firstName)
				.enterLastName(lastName)
				.enterPostalCode(postalCode)
				.clickContinueButton()
				.clickFinishButton()
				.checkoutConfirmation();

		assertEquals(expectedConfirmation, actualConfirmation, "Purchase was not successful. Please try again.");
	}
}
