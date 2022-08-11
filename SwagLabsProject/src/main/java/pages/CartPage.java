package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class CartPage extends PageObjectBase{

	@CacheLookup
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement itemTitle;

	public CartPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String retrieveItemTitle() {

		String item = itemTitle.getText();

		return item;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
