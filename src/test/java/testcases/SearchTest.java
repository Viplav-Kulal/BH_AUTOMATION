package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.PageFactory;

public class SearchTest extends PageFactory {

	// @Test(priority = 0, description = "This test verifies the Search
	// functionality and validates the first search result")
	public void tc_VerifySearch() {
		click(getCookieAcceptButton());
		click(getSearchIcon());
		Assert.assertTrue(isVisible(getSearchField(), 10));
		enterText(getSearchField(), SearchText);
		click(getSearchButton());
		WaitForElementToBeVisible(getSearchResults(), 10);
		Assert.assertTrue(isVisible(getFirstSearchResultTitle(), 1));
		Assert.assertTrue(getFirstSearchResultTitle().getText().equals(SearchText),
				"First search result does not match the searched text");
	}

	@Test(priority = 1, description = "This test verifies the Find A Center page and serach result count")
	public void tc_VerifyFindACenter() {
		click(getCookieAcceptButton());
		click(getFindACenterButton());
		WaitForElementToBeVisible(getCenterSearchField(), 10);
		Assert.assertTrue(verifyEndPointInURL(ChildCareLocatorURL));
		enterText(getCenterSearchField(), CitySearch);
		PressEnter(getCenterSearchField());
		WaitForElementToBeVisible(getCenterResutlsTitle(), 30);
		if (getCenterResutlsTitle().getText().equals(String.valueOf(getTotalCenterResults().size()))) {
			System.out.println("Total number of centers match the total number of results displayed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Total number of centers does not match the number of results displayed");
			Assert.assertTrue(false);
		}
		click(getTotalCenterResults().get(1));
		Assert.assertTrue(getSubElementText(1, 1).trim().contains(getCenterPopUpName().getText().trim()),
				"Center name in list is not same as the pop-up");
		Assert.assertTrue(getSubElementText(1, 3).trim().contains(getCenterPopUpAdress().getText().trim()),
				"Center name in list is not same as the pop-up");
	}
}
