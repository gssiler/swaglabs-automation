package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class CheckoutPage extends PageObjectBase{

	@CacheLookup
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	@CacheLookup
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	@CacheLookup
	@FindBy(xpath = "//input[@name='postalCode']")
	private WebElement postalCode;

	@CacheLookup
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@CacheLookup
	@FindBy(xpath = "//button[@name='finish']")
	private WebElement finishButton;

	@CacheLookup
	@FindBy(xpath = "//div[@id='checkout_complete_container']")
	private WebElement checkoutConfirmation;

	@CacheLookup
	@FindBy(xpath = "//span[@class='title']")
	private WebElement titleHeader;

	public CheckoutPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public CheckoutPage enterFirstName(String name) {
		elementControl.setText(firstName, name);

		return this;
	}

	public CheckoutPage enterLastName(String name) {
		elementControl.setText(lastName, name);

		return this;
	}

	public CheckoutPage enterPostalCode(String name) {
		elementControl.setText(postalCode, name);

		return this;
	}

	public CheckoutPage clickContinueButton() {
		elementControl.clickElement(continueButton);

		return this;
	}

	public CheckoutPage clickFinishButton() {
		elementControl.clickElement(finishButton);

		return this;
	}

	public String checkoutConfirmation() {

		String title = titleHeader.getText();
		System.out.println(checkoutConfirmation.getText());

		return title;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
