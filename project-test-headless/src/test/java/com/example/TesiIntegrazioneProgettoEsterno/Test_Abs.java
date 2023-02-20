
//File risulta attualmente aggiornato per webdriver chrome headless!
package com.example.TesiIntegrazioneProgettoEsterno;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Abs{
private static WebDriver driver;
private boolean acceptNextAlert = true;
private static StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		
		  // Init chromedriver
		  //String chromeDriverPath = "/home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/chromedriver_v94_linux64/chromedriver";
		  //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		  WebDriverManager.chromedriver().setup();
		  System.setProperty("webdriver.chrome.whitelistedIps", "");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
		  driver = new ChromeDriver(options);  
		  
		  
		  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void test_loc_Abs_release_1_1() throws Exception{
    driver.get("http://localhost:4200/");
    Thread.sleep(6000);
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).clear();
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("odoobnb@gmail.com");
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).clear();
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("provaprova92");
    driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]/div[1]/span[1]")).click();
	Thread.sleep(6000);
	driver.get("http://localhost:4200/");
	Thread.sleep(6000);
	String m = driver.findElement(By.xpath("//html")).getText();
	System.out.println(m);
	String m = driver.findElement(By.xpath("//html")).getText();
	System.out.println(m);
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[normalize-space()='Home']"), "Home"));
	
	String s = driver.findElement(By.xpath("//html")).getText();
	System.out.println(s);
	driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-nav-bar[1]/ul[1]/li[3]/a[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-categories[1]/div[1]/div[1]/as-category-cover[1]/a[1]/as-media-cover[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-category-detail[1]/div[1]/as-playlist-list[1]/div[1]/as-media[1]/a[1]/div[2]/as-media-cover[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-nav-bar[1]/ul[1]/li[2]/a[1]")).click();
    driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-search[1]/div[1]/div[1]/as-input[1]/div[1]/input[1]")).sendKeys("mengoni");
    driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-search[1]/div[1]/div[2]/div[1]/as-album-track[1]/as-media-table-row[1]/as-track-main-info[1]/div[2]/div[2]/a[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mi Fiderò (feat. Madame)'])[1]/following::a[1]")).click();
    Thread.sleep(4000);
    assertEquals("Marco Mengoni",driver.findElement(By.xpath("//html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-album[1]/div[1]/as-media-summary[1]/div[1]/div[2]/div[1]")).getText());
  }


 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
