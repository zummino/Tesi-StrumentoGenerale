package test.headless;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Hook {

	private static WebDriver driver;
	private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

		  @Before
		  public void setUp() throws Exception {
			
			 			  
			  // Init chromedriver			  
			  WebDriverManager.chromedriver().setup();
			  System.setProperty("webdriver.chrome.whitelistedIps", "");
			  ChromeOptions options = new ChromeOptions();
			  //to use chrome in headless mode add the argument "--headless"
			  //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
			  options.addArguments("--disable-gpu", "--window-size=1920,1200","--no-sandbox","--ignore-certificate-errors");
			  
			  driver = new ChromeDriver(options);			  
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	  @Test
	  public void test_function() throws Exception {
		  
			//paste here the test to execute 
		  driver.get("http://localhost:4200/");
		    driver.findElement(By.id("login-username")).click();
		    driver.findElement(By.id("login-username")).clear();
		    driver.findElement(By.id("login-username")).sendKeys("odoobnb@gmail.com");
		    driver.findElement(By.id("login-password")).click();
		    driver.findElement(By.id("login-password")).clear();
		    driver.findElement(By.id("login-password")).sendKeys("provaprova93");
		    driver.findElement(By.xpath("//button[@id='login-button']/div")).click();
		    driver.findElement(By.xpath("//*[@x448533202421-x-test-tpl-1]//*[@x448533202421-x-test-hook-29]//*[@x448624268039-x-test-tpl-1]//*[@x448627084077-x-test-tpl-6]//*[@x277063252156-x-test-tpl-2]//*[@x277063252156-x-test-hook-8]")).click();
		    driver.findElement(By.xpath("//*[@x448533202421-x-test-tpl-1]//*[@x448533202421-x-test-hook-29]//*[@x448624268039-x-test-tpl-3]//*[@x448624897747-x-test-tpl-2]//*[@x448594643043-x-test-tpl-1]//*[@x448594643043-x-test-hook-3]//*[@x448605300685-x-test-tpl-1]//*[@x448605300685-x-test-hook-4]")).clear();
		    driver.findElement(By.xpath("//*[@x448533202421-x-test-tpl-1]//*[@x448533202421-x-test-hook-29]//*[@x448624268039-x-test-tpl-3]//*[@x448624897747-x-test-tpl-2]//*[@x448594643043-x-test-tpl-1]//*[@x448594643043-x-test-hook-3]//*[@x448605300685-x-test-tpl-1]//*[@x448605300685-x-test-hook-4]")).sendKeys("ciao");
		    driver.findElement(By.xpath("//*[@x448533202421-x-test-tpl-1]//*[@x448533202421-x-test-hook-29]//*[@x448624268039-x-test-tpl-3]//*[@x448624897747-x-test-tpl-2]//*[@x448594643043-x-test-tpl-1]//*[@x448594643043-x-test-hook-14][1]//*[@x448545732489-x-test-tpl-1]//*[@x448621166798-x-test-hook-9]")).click();
		  	
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
