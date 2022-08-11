package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class HomePage extends PageObjectBase {

	@CacheLookup
	@FindBy(xpath = "//div[@class='form_group']/input[@id='user-name']")
	private WebElement enterUserName;

	@CacheLookup
	@FindBy(xpath = "//div[@class='form_group']/input[@id='password']")
	private WebElement enterPassword;

	@CacheLookup
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public HomePage enterUserName(String userName) {
		elementControl.setText(enterUserName, userName);

		return this;
	}

	public HomePage enterPassword(String password) {
		elementControl.setText(enterPassword, password);

		return this;
	}

	public ProductsPage clickLoginButton() {
		elementControl.clickElement(loginButton);

		return new ProductsPage(getDriver(), getRelativeUrl());
	}

	@Override
	protected String getRelativeUrl() {
		return "";
	}

}
