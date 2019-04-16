package home_page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageElements {

	public static WebElement element = null;

	public static final String HOME_PAGE_URL = "https://www.booking.com";
	public static final String SEARCH_BAR = "//input[@id='ss']";
	public static final String NEXT_MOUNTH_BUTTON = "//body[@id='b2indexPage']/div[contains(@class,'xpi__content__wrapper xpi__content__wrappergray')]/div[contains(@class,'xpi__content__container')]/div[contains(@class,'xpi__searchbox')]/div[contains(@class,'sb-searchbox__outer')]/form[@id='frm']/div[contains(@class,'xp__fieldset accommodation')]/div[contains(@class,'xp__dates xp__group')]/div[contains(@class,'xp-calendar')]/div[contains(@class,'bui-calendar')]/div[contains(@class,'bui-calendar__main')]/div[contains(@class,'bui-calendar__control bui-calendar__control--next')]/*[1]";
	public static final String DATE_ROW_CLASS_NAME = "bui-calendar__row";
	public static final String DATE_DAY_CLASS_NAME = "bui-calendar__date";
	public static final String CHECKIN_BUTTON = "//div[contains(@class,'xp__dates-inner xp__dates__checkin')]//span[contains(@class,'sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb')]";
	public static final String GUESTS_COUNT_BUTTON = "//span[contains(@class,'xp__guests__count')]";
	public static final String BUTTON_TO_ADD_CHILDREN = "//div[contains(@class,'sb-group__field sb-group-children')]//span[contains(@class,'bui-button__text')][contains(text(),'+')]";
	public static final String SEARCH_BUTTON = "//button[contains(@type,'submit')]//span[contains(text(),'Search')]";
	public static final String SERACH_LOCATION = "Beijing";
	public static final String FOUND_LOCATION = "//h1[contains(text()," + SERACH_LOCATION + ")]";
	public static final String ADVERT = "/html/body/div[4]/div[3]/div/div[6]/div/ul/li[1]/div/div/a/img";
	public static final String ADVERT_ABSOLUTE = "/html[1]/body[1]/div[4]/div[3]/div[1]/div[6]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/header[1]/h1[1]";
	public static final String ADVERT_CSS = "div.bui-carousel--medium:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)";
	public static final String ADVERT_CSS_SECOND = "div.bui-carousel--medium:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)";
	public static final String ADVERT_TXT = "div.bui-carousel--medium:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > header:nth-child(2) > h1:nth-child(1)";
	public static final String ADVERT_TXT_2 = "div.bui-carousel--medium:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > header:nth-child(2) > h1:nth-child(1)";
	public static final String TARGET_TXT = "//span[@class='sb-searchbox__title-text']";


	public static void openPage(WebDriver driver, String urlPage) {

		driver.get(urlPage);
	}

	public static WebElement findWebElement(WebDriver driver, String xpathInput) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathInput)));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	public static WebElement findWebElementByCssSelector(WebDriver driver, String cssSelector) {

		try {
			element = driver.findElement(By.cssSelector(cssSelector));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	public static void clickWebElement(WebDriver driver, String xpathInput) {

		findWebElement(driver, xpathInput).click();
	}

	public static void clickWebElementFoundByCssSelector(WebDriver driver, String cssSelector) {

		findWebElementByCssSelector(driver, cssSelector).click();
	}

	public static List<WebElement> getListOfWebElementsByClassName(WebDriver driver, String className) {
		List<WebElement> allElements = driver.findElements(By.className(className));
		return allElements;
	}

	public static void waitThread(long duration) throws Exception {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			throw e;
		}
	}

	public static String getFirstWords(String text) {
		String[] arr = text.split(":", 2);

		return arr[0];
	}

	public static void scrollDownToWebElement(WebDriver driver, String cssSelector) throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				element = driver.findElement(By.cssSelector(cssSelector)));
	}

}
