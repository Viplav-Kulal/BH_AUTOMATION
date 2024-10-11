package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.PageFactory;


public class SearchTest extends PageFactory {

	@Test(priority = 0, description = "This test verifies the Search functionality and validates the first search result")
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
		click(getFindACenterButton());
		
	}
}
