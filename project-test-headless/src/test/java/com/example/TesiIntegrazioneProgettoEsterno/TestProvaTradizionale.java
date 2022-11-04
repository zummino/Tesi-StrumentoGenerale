package com.example.TestProva1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestProvaTradizionale {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testTradizionale_release_v_1_1 throws Exception {
    driver.get("http://localhost:4200/");
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).clear();
    driver.findElement(By.id("login-username")).sendKeys("odoobnb@gmail.com");
    driver.findElement(By.id("login-password")).click();
    driver.findElement(By.id("login-password")).clear();
    driver.findElement(By.id("login-password")).sendKeys("provaprova93");
    driver.findElement(By.xpath("//button[@id='login-button']/div/p")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Ricerca')]")).click();
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("ciao");
    driver.findElement(By.xpath("//a[contains(text(),'Gemitaiz')]")).click();
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
