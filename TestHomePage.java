package homepage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestHomePage extends HomePageElements {

	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		
		// open booking.com page
		openPage(driver, HOME_PAGE_URL);
	}

	@Test // search specific accommodation thru search bar, date picker and guest count
	public void searchSpecificAccommodation() throws Exception {
		
		// in search bar enter location defined in class HomePageElements in final variable SERACH_LOCATION
		findWebElement(driver, SEARCH_BAR).sendKeys(SERACH_LOCATION);

		// click on check in date
		clickWebElement(driver, CHECKIN_BUTTON);
		waitThread(1000);

		// click twice on next month button
		WebElement nextMonth = findWebElement(driver, NEXT_MOUNTH_BUTTON);
		nextMonth.click();
		waitThread(1000);
		nextMonth.click();

		// get all dates in month
		List<WebElement> days = getListOfWebElementsByClassName(driver,
				DATE_DAY_CLASS_NAME);

		// click on two dates
		days.get(8).click();
		waitThread(1000);
		days.get(18).click();
		waitThread(1500);
		
		// click on guest button and add two children
		clickWebElement(driver, GUESTS_COUNT_BUTTON);
		waitThread(1500);
		clickWebElement(driver, BUTTON_TO_ADD_CHILDREN);
		clickWebElement(driver, BUTTON_TO_ADD_CHILDREN);
		waitThread(1500);
		
		// click on search button
		clickWebElement(driver, SEARCH_BUTTON);

		// get text(string) from result of search
		String found = findWebElement(driver, FOUND_LOCATION).getText();
		String foundLocation = getFirstWords(found);

		// compare search criteria and result of search
		Assert.assertEquals(SERACH_LOCATION, foundLocation);

	}

	@Test(dependsOnMethods = { "searchSpecificAccommodation" }) // check if user click on advert to hotels, link opens
																// right page
	public void checkIfCityIsCorrect() throws Exception {
		
		// open booking.com page
		openPage(driver, HOME_PAGE_URL);
		waitThread(1500);
		
		// get location name from advert
		String advertTxt = findWebElementByCssSelector(driver, ADVERT_TXT)
				.getText();

		System.out.println("advertTxt: " + advertTxt);

		// scroll down to WebElement
		scrollDownToWebElement(driver, ADVERT_CSS);
		waitThread(5000);

		// click on advert
		clickWebElementFoundByCssSelector(driver, ADVERT_CSS);
		waitThread(1500);

		// check if location city has two words in name
		List<String> twoWordsCitys = Arrays.asList("New York", "Novi Sad", "New Delhi");
		String headLineTxt = "", targetTxt = "", found = "", foundLocation = "";
		String temp = "";
		
		
		for (int i = 0; i < twoWordsCitys.size(); i++) {
			if (advertTxt.equals(twoWordsCitys.get(i))) {

				foundLocation = twoWordsCitys.get(i);
				temp = foundLocation;
			}
		}
		
		if (foundLocation.length() <= 0) {
			found = driver.findElement(By.xpath("//h1[contains(text(),'" + advertTxt + "')]")).getText();

			foundLocation = getFirstWords(found);
			System.out.println("found: " + found);
			System.out.println("foundLocation: " + foundLocation);
		}

		// compare city name from advert and new page opened
		Assert.assertEquals(advertTxt, foundLocation);
		waitThread(5000);

	}
	
	@Test(dependsOnMethods = { "checkIfCityIsCorrect" }) // check if user click on advert to hotels, link opens
														 // right page
	public void checkIfCityIsCorrect2() throws Exception {

		openPage(driver, HOME_PAGE_URL);

		waitThread(1500);

		String advertTxt = findWebElementByCssSelector(driver, ADVERT_TXT_2)
				.getText();

		System.out.println("advertTxt: " + advertTxt);

		scrollDownToWebElement(driver, ADVERT_CSS);
		waitThread(5000);

		clickWebElementFoundByCssSelector(driver, ADVERT_CSS_SECOND);
		waitThread(1500);

		List<String> twoWordsCitys = Arrays.asList("New York", "Novi Sad", "New Delhi");

		String headLineTxt = "", targetTxt = "", found = "", foundLocation = "";
		String temp = "";
		for (int i = 0; i < twoWordsCitys.size(); i++) {
			if (advertTxt.equals(twoWordsCitys.get(i))) {

				foundLocation = twoWordsCitys.get(i);
				temp = foundLocation;
				System.out.println("foundLocation1: " + foundLocation);

			}

		}
		if (foundLocation.length() <= 0) {
			found = driver.findElement(By.xpath("//h1[contains(text(),'" + advertTxt + "')]")).getText();

			foundLocation = getFirstWords(found);
			System.out.println("found: " + found);
			System.out.println("foundLocation: " + foundLocation);
		}

		Assert.assertEquals(advertTxt, foundLocation);
		waitThread(5000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
