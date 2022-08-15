package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class ProductsPage extends PageObjectBase {

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addBackpackToCart;

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement addBikeLightToCart;

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement addBoltShirtToCart;

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement addJacketToCart;

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement addOnesieToCart;

	@CacheLookup
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement addRedShirtToCart;

	@CacheLookup
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement viewCart;

	@CacheLookup
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	public ProductsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String retrieveUrl() {

		String currentUrl = getDriver().getCurrentUrl();

		return currentUrl;
	}

	public ProductsPage addItemToCart(String item) {

		if (item == "Sauce Labs Backpack") {
			elementControl.clickElement(addBackpackToCart);
		}
		else if (item == "Sauce Labs Bike Light") {
			elementControl.clickElement(addBikeLightToCart);
		}
		else if (item == "Sauce Labs Bolt Shirt") {
			elementControl.clickElement(addBoltShirtToCart);
		}
		else if (item == "Sauce Labs Fleece Jacket") {
			elementControl.clickElement(addJacketToCart);
		}
		else if (item == "Sauce Labs Onesie") {
			elementControl.clickElement(addOnesieToCart);
		}
		else if (item == "Sauce Labs Red Shirt") {
			elementControl.clickElement(addRedShirtToCart);
		}

		System.out.println(item + ": Added To Cart");

		return this;
	}

	public CartPage viewCart() {

		elementControl.clickElement(viewCart);

		return new CartPage(getDriver(), getRelativeUrl());
	}

	public String retrieveErrorMessage() {
		String error = errorMessage.getText();
		System.out.println(error);

		return error;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
