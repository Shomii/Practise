package home_page;

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

public class TestHomePage {

	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		
		// open booking.com page
		HomePageElements.openPage(driver, HomePageElements.HOME_PAGE_URL);
	}

	@Test // search specific accommodation thru search bar, date picker and guest count
	public void searchSpecificAccommodation() throws Exception {
		
		// in search bar enter location defined in class HomePageElements in final variable SERACH_LOCATION
		HomePageElements.findWebElement(driver, HomePageElements.SEARCH_BAR).sendKeys(HomePageElements.SERACH_LOCATION);

		// click on check in date
		HomePageElements.clickWebElement(driver, HomePageElements.CHECKIN_BUTTON);
		HomePageElements.waitThread(1000);

		// click twice on next month button
		WebElement nextMounth = HomePageElements.findWebElement(driver, HomePageElements.NEXT_MONTH_BUTTON);
		nextMonth.click();
		HomePageElements.waitThread(1000);
		nextMonth.click();

		// get all dates in month
		List<WebElement> days = HomePageElements.getListOfWebElementsByClassName(driver,
				HomePageElements.DATE_DAY_CLASS_NAME);

		// click on two dates
		days.get(8).click();
		HomePageElements.waitThread(1000);
		days.get(18).click();
		HomePageElements.waitThread(1500);
		
		// click on guest button and add two children
		HomePageElements.clickWebElement(driver, HomePageElements.GUESTS_COUNT_BUTTON);
		HomePageElements.waitThread(1500);
		HomePageElements.clickWebElement(driver, HomePageElements.BUTTON_TO_ADD_CHILDREN);
		HomePageElements.clickWebElement(driver, HomePageElements.BUTTON_TO_ADD_CHILDREN);
		HomePageElements.waitThread(1500);
		
		// click on search button
		HomePageElements.clickWebElement(driver, HomePageElements.SEARCH_BUTTON);

		// get text(string) from result of search
		String found = HomePageElements.findWebElement(driver, HomePageElements.FOUND_LOCATION).getText();
		String foundLocation = HomePageElements.getFirstWords(found);

		// compare search criteria and result of search
		Assert.assertEquals(HomePageElements.SERACH_LOCATION, foundLocation);

	}

	@Test(dependsOnMethods = { "searchSpecificAccommodation" }) // check if user click on advert to hotels, link opens
																// right page
	public void checkIfCityIsCorrect() throws Exception {
		
		// open booking.com page
		HomePageElements.openPage(driver, HomePageElements.HOME_PAGE_URL);
		HomePageElements.waitThread(1500);
		
		// get location name from advert
		String advertTxt = HomePageElements.findWebElementByCssSelector(driver, HomePageElements.ADVERT_TXT)
				.getText();

		System.out.println("advertTxt: " + advertTxt);

		// scroll down to WebElement
		HomePageElements.scrollDownToWebElement(driver, HomePageElements.ADVERT_CSS);
		HomePageElements.waitThread(5000);

		// click on advert
		HomePageElements.clickWebElementFoundByCssSelector(driver, HomePageElements.ADVERT_CSS);
		HomePageElements.waitThread(1500);

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

			foundLocation = HomePageElements.getFirstWords(found);
			System.out.println("found: " + found);
			System.out.println("foundLocation: " + foundLocation);
		}

		// compare city name from advert and new page opened
		Assert.assertEquals(advertTxt, foundLocation);
		HomePageElements.waitThread(5000);

	}
	
	@Test(dependsOnMethods = { "checkIfCityIsCorrect" }) // check if user click on advert to hotels, link opens
														 // right page
	public void checkIfCityIsCorrect2() throws Exception {

		HomePageElements.openPage(driver, HomePageElements.HOME_PAGE_URL);

		HomePageElements.waitThread(1500);

		String advertTxt = HomePageElements.findWebElementByCssSelector(driver, HomePageElements.ADVERT_TXT_2)
				.getText();

		System.out.println("advertTxt: " + advertTxt);

		HomePageElements.scrollDownToWebElement(driver, HomePageElements.ADVERT_CSS);
		HomePageElements.waitThread(5000);

		HomePageElements.clickWebElementFoundByCssSelector(driver, HomePageElements.ADVERT_CSS_SECOND);
		HomePageElements.waitThread(1500);

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

			foundLocation = HomePageElements.getFirstWords(found);
			System.out.println("found: " + found);
			System.out.println("foundLocation: " + foundLocation);
		}

		Assert.assertEquals(advertTxt, foundLocation);
		HomePageElements.waitThread(5000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
