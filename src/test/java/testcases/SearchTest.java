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
		WaitForElementToBeVisible(getCenterSearchField(), 10);
		Assert.assertTrue(verifyEndPointInURL(ChildCareLocatorURL));
		enterText(getCenterSearchField(), CitySearch);
		waitfor(5);
		PressEnter(getCenterSearchField());
		WaitForElementToBeVisible(getCenterResutlsTitle(), 30);
		// Verifying number of centers text(20 centers) displayed, matches the results
		// in the list

		if (getCenterResutlsTitle().getText().equals(String.valueOf(getTotalCenterResults().size()))) {
			System.out.println("Total number of centers match the total number of results displayed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Total number of centers does not match the number of results displayed");
			Assert.assertTrue(false);
		}
		getNameandAdressOfCenterResult(1); // Here we collect the name and Address of Second item in the list

		System.out.println("Center Address : " + centreAddress);
		System.out.println("Center Name : " + centerName);

		click(getTotalCenterResults().get(1)); // Now open the pop-up
		WaitForElementToBeVisible(getCenterPopUpName(), 5);

		// Verify if the first Results name and Address in the list matches with that of
		// the pop-up

		Assert.assertTrue(centerName.equals(getCenterPopUpName().getText().trim()),
				"Center name in list is not same as the pop-up");
		Assert.assertTrue(centreAddress.equals(getCenterPopUpAdressOnSingleLine()),
				"Center Address in list is not same as the pop-up");
	}
}
