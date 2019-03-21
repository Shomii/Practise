package prviSelenijum;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CetvrtiSelenijum {

public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.gecko.driver",
//                "D:\\Selenium\\geckodriver.exe");
		
		WebDriver web = new FirefoxDriver();
		String url = UrlConfig.EVE;
		// https://www.eveonline.com/
		web.get(url);	
//		String title = web.getTitle();
//		System.out.println(title);
//		int duzina = title.length();
//		System.out.println("duzina title: "+duzina);
//		String sors = web.getPageSource();
//		int duzinaSorsa = sors.length();
//		System.out.println("duzina soursa: " +duzinaSorsa);
		
		String actualUrl = web.getCurrentUrl();
		
		if(actualUrl.equals(url)) {
			System.out.println("Na dobrom ste sajtu ->" + actualUrl);
		}else {
			System.out.println("Greska, trenutno ste na sajtu " + actualUrl);
		}
			
		
//		boolean bol = web.getCurrentUrl().equals("http://newtours.demoaut.com/");
//		System.out.println(bol);
		try {
			WebDriverWait wait = new WebDriverWait(web, 100);
			WebElement element;
			web.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			element= wait.until(ExpectedConditions.elementToBeClickable(By.className("Explore__icon___1PvKb")));
			//	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='Explore__icon___1PvKb']")));
			
			System.out.println("krenuo");
			Actions actions = new Actions(web);

			//actions.moveToElement(element).click().perform();
			((JavascriptExecutor) web).executeScript("arguments[0].scrollIntoView();", element);
			actions.moveToElement(element).click().perform();
			
			String newActualUrlll = web.getCurrentUrl();
			System.out.println(newActualUrlll);
			Thread.sleep(15000);
			web.navigate().back();
//		WebElement element = web.findElement(By.xpath("img[@class='Explore__image___2jDhl']"));
			//WebElement element = web.findElement(By.className("Explore__icon___1PvKb"));
			//WebElement element = web.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/img[2]"));
			//web.wait();
		//WebDriverWait wait = new WebDriverWait(web, 100);
			//WebElement element;// = web.findElement(By.xpath("img[@class='Explore__icon___1PvKb']"));
			//element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='styles__desktopView___21agp']//div[@class='styles__title___317iA'][contains(text(),'Articles')]")));
			
			element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='styles__desktopView___21agp']//div[@class='styles__title___317iA'][contains(text(),'Articles')]")));
			System.out.println("krenuo");
		//	Actions actions = new Actions(web);

			//actions.moveToElement(element).click().perform();
//			((JavascriptExecutor) web).executeScript("arguments[0].scrollIntoView();", element);
//			actions.moveToElement(element).click().perform();
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='Explore__icon___1PvKb']")));
		//	withAction().moveToElement(webElement).perform();
			element.click();
			String newActualUrl = web.getCurrentUrl();
			System.out.println(newActualUrl);
			actions.sendKeys(Keys.ESCAPE).perform();
			//web.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//	wait.withTimeout(10, TimeUnit.SECONDS);
		//	wait.
			//web.wait(5000);
			element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='//webimg.ccpgamescdn.com/7lhcm73ukv5p/6LCbIs6wQo0iMQ2QuWIGou/b9e34e2b3dd4283256b5618c7bc09167/Skill_Injector.png_w=640']")));
		
			element.click();
			String newActualUrl2 = web.getCurrentUrl();
			System.out.println(newActualUrl2);
			
			web.navigate().back();
			web.navigate().back();
			
			String newActualUrl3 = web.getCurrentUrl();
			System.out.println(newActualUrl3);
			
			
			
			
		}catch (Exception e) {
			System.out.println("greska "+e.toString());
		}
		web.quit();

	}
	
}
