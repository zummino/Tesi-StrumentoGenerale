package com.example.Prova1;

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

public class Test_Katalon{
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
  public void test_loc_Katalon_release_1_1() throws Exception{
    driver.get("http://localhost:4200/");
    Thread.sleep(5000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='o'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='o'])[1]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='o'])[1]/following::input[1]")).sendKeys("odoobnb@gmail.com");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Indirizzo e-mail o nome utente'])[1]/following::input[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Indirizzo e-mail o nome utente'])[1]/following::input[2]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Indirizzo e-mail o nome utente'])[1]/following::input[2]")).sendKeys("provaprova93");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Indirizzo e-mail o nome utente'])[1]/following::span[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::a[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='marco'])[1]/following::input[1]")).sendKeys("marco");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='marco'])[1]/following::input[1]")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Due Vite'])[1]/following::a[1]")).click();
    Thread.sleep(5000);
    assertEquals("Marco Mengoni",driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Artist'])[1]/following::h2[1]")).getText());
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
