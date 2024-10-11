package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory extends BaseMethods {

	public String SearchText = "Employee Education in 2018: Strategies to Watch";
	public String CitySearch = "New York";
	public String ChildCareLocatorURL = "/child-care-locator";

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

	@FindBy(xpath = "//input[@id='addressInput']")
	public WebElement centerSearchField;

	@FindBy(xpath = "//div[@class='centerDetails results']/span")
	public WebElement centerResultsTitle;

	@FindBy(xpath = "//div[@class='centerResult infoWindow track_center_select covidOpen']")
	public List<WebElement> totalCenterResults;

	@FindBy(xpath = "//span[@class='mapTooltip__headline']")
	public WebElement popUpName;

	@FindBy(xpath = "//div[@class='mapTooltip__address']")
	public WebElement popUpAddress;

	@FindBy(xpath = "//div[contains(text(),'Enter a location to get started')]")
	public WebElement waitCenterLocationResult;

	public WebElement getCenterLocationResultWaitText() {
		return waitCenterLocationResult;
	}

	public WebElement getCenterPopUpAdress() {
		return popUpAddress;
	}

	public WebElement getCenterPopUpName() {
		return popUpName;
	}

	public List<WebElement> getTotalCenterResults() {
		return totalCenterResults;
	}

	public WebElement getCenterResutlsTitle() {
		return centerResultsTitle;
	}

	public WebElement getCenterSearchField() {
		return centerSearchField;
	}

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

	public WebElement getFirstCentre() {
		return getTotalCenterResults().get(0);
	}

	public String getSubElementText(int parentIndex, int subElementIndex) {
		try {
			WebElement parentElement = getTotalCenterResults().get(parentIndex);
			List<WebElement> subElements = parentElement.findElements(By.xpath("./*"));
			return subElements.get(subElementIndex).getText();
		} catch (Exception e) {
			System.out.println("invalid index");
			e.printStackTrace();
		}
		return null;
	}
}
