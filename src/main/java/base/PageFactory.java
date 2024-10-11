package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory extends BaseMethods {

	public String SearchText = "Employee Education in 2018: Strategies to Watch";

	@FindBy(xpath = "(//a[@class='nav-link-search track_nav_interact collapsed'])[2]")
	public WebElement searchIcon;

	@FindBy(xpath = "(//input[@id='search-field'])[2]")
	public WebElement searchField;

	@FindBy(xpath = "//div[@class='results container']")
	public WebElement searchResults;

	@FindBy(xpath = "(//a[@class='search-result']/div/h3)[1]")
	public WebElement firstSearchResult;

	@FindBy(xpath = "(//button[contains(text(),'Search')])[2]")
	public WebElement searchButton;

	@FindBy(id = "onetrust-accept-btn-handler")
	public WebElement acceptCookies;
	
	@FindBy(xpath = "(//a[contains(text(),'Find a Center')])[4]")
	public WebElement findACenterButton;
	
	public WebElement getFindACenterButton() {
		return findACenterButton;
	}

	public WebElement getCookieAcceptButton() {
		return acceptCookies;
	}

	public WebElement getSearchResults() {
		return searchResults;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getFirstSearchResultTitle() {
		return firstSearchResult;
	}

}
