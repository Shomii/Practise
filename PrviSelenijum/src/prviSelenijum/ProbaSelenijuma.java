package prviSelenijum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class ProbaSelenijuma {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.gecko.driver",
//                "D:\\Selenium\\geckodriver.exe");
		
		WebDriver web = new FirefoxDriver();
		web.get("http://newtours.demoaut.com/");
		System.out.println();
		String title = web.getTitle();
		System.out.println(title);
		int duzina = title.length();
		System.out.println("duzina title: "+duzina);
		String sors = web.getPageSource();
		int duzinaSorsa = sors.length();
		System.out.println("duzina soursa: " +duzinaSorsa);
		boolean bol = web.getCurrentUrl().equals("http://newtours.demoaut.com/");
		System.out.println(bol);
		
		web.close();

	}

}
