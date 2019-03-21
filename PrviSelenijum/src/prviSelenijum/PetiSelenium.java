package prviSelenijum;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PetiSelenium {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		String url = UrlConfig.NEWTOURS;

		try {
			//driver.get(url);

//			WebElement register = driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
//			register.click();
//			System.out.println("click register");
//			Thread.sleep(2000);
//
//			driver.navigate().back();
//			System.out.println("click back");
//			Thread.sleep(2000);
//
//			driver.navigate().forward();
//			System.out.println("click forward");
//			Thread.sleep(2000);
//
//			driver.navigate().to(url);
//			System.out.println("go to hame page");
//			Thread.sleep(2000);
//
//			driver.navigate().refresh();
//			System.out.println("refresh hame page");
//			Thread.sleep(2000);
//
//			String url2 = UrlConfig.FACEBOOK;
//			driver.get(url2);
//
//			WebElement username = driver.findElement(By.id("email"));
//			username.sendKeys("kkmisha@hotmail.com");
//
//			WebElement pass = driver.findElement(By.id("pass"));
//			pass.sendKeys("perica");
//
//			Thread.sleep(2000);
//			
//			WebElement buttonRegister = driver.findElement(By.xpath("//input[@id='u_0_2']"));
//			buttonRegister.click();
			
//			1. Izvrsiti navigaciju na sajt www.youtube.com
//			2. U pretrszi ukucati Rick Astley
//			3. Kliknuti na prvi vide klip
			WebDriverWait wait = new WebDriverWait(driver, 100);
			
			String url3 = UrlConfig.YOUTUBE;
			//Thread.sleep(3000);
			driver.get(url3);
			//Thread.sleep(3000);
			WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
			search.sendKeys("Rick Astley");
			Thread.sleep(3000);
			WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
			searchButton.click();
			Thread.sleep(3000);
		//	WebElement klik= wait.until(ExpectedConditions.elementToBeClickable(By.className("video-stream html5-main-video")));
			//WebElement klik = driver.findElement(By.className("video-stream html5-main-video"));
			WebElement klik = driver.findElement(By.xpath("//a[contains(text(),'Rick Astley - Never Gonna Give You Up (Official Mu')]"));
			
			klik.click();
			//video[@class='video-stream html5-main-video']
			Thread.sleep(2000);
			//WebDriverWait pause = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-play-button ytp-button']")));
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-play-button ytp-button']"))).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-play-button ytp-button']"))).click();
			//button[@class='ytp-play-button ytp-button']
			Thread.sleep(6000);
		//	List<WebElement> list = new ArrayList<WebElement>();
			//for(int i =0;i<10;i++) {
			List<WebElement> list = driver.findElements(By.className("ytd-compact-video-renderer"));
			System.out.println(list);
			//}
			/**
			 *  List<WebElement> playSecondRecomended = driver.findElements(By.className("ytd-compact-video-renderer"));
            playSecondRecomended.get(2).click();
			 * 
			 */
			
			Thread.sleep(3000);
			list.get(1).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			driver.quit();
		}
	}

}
