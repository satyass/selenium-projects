package selenium.practice;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SungevityHomePageTest {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setupConfig(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adityas\\workspace\\selenium-practice\\practice\\Drivers\\chromedriver.exe");
		
	}
	@BeforeMethod
	public void launchApplication(){
		driver = new ChromeDriver();
		driver.get("http://www.sungevity.com/");
		
	}
	@Test
	public void testHomePageLogo(){
		String expectedLogo = "Sungevity_logo.png";
		String actualLogo = driver.findElement(By.xpath("//div[@id='header']/header/div/div[1]/a[1]/img")).getAttribute("alt");
		try {
			Assert.assertEquals(expectedLogo, actualLogo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testHomePageTitle(){
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Solar Panels For Home, Residential Solar Power System - Sungevity";
		try {
			Assert.assertEquals(expectedTitle, actualTitle);
			System.out.println("actualTitle is  "+actualTitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void closeApplication(){
		driver.close();
	}

}
