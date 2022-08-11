package pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class ProductsPage extends PageObjectBase {

	public ProductsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String retrieveUrl() {

		String currentUrl = getDriver().getCurrentUrl();

		return currentUrl;

	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
