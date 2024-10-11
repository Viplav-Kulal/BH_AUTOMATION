package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseMethods extends Base {

	public static boolean isVisible(WebElement ele, int time) {
		@SuppressWarnings("unused")
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			element = wait.until(ExpectedConditions.visibilityOf(ele));
			System.out.println("Element " + ele.getText() + " is visible");
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Element not visible");
			e.printStackTrace();
		}
		return false;
	}
	
	public static void WaitForElementToBeVisible(WebElement ele, int time) {
		@SuppressWarnings("unused")
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			element = wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Element not visible");
			e.printStackTrace();
		}
	}

	public static boolean isClickable(WebElement ele, Duration time) {
		@SuppressWarnings("unused")
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			element = wait.until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element " + ele.getText() + " is Clickable");
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Element is not clickable");
			e.printStackTrace();
		}
		return false;
	}

	public void click(WebElement ele) {
		if (isClickable(ele, Duration.ofSeconds(30))) {
			System.out.println("Clicking on " + ele.getText());
			ele.click();
		}
	}

	public static void enterText(WebElement ele, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Entering text into element " + ele.getText());
			ele.clear();
			ele.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Unable to enter text");
			e.printStackTrace();
		}
	}

}
