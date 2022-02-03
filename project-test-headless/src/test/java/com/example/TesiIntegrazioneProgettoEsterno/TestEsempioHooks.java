package com.example.TesiIntegrazioneProgettoEsterno;

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

public class TestEsempioHooks {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Downloads\\chromedriver_win32_ChromeV97\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testEsempioHooks() throws Exception {
    driver.get("http://localhost:4200/");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).sendKeys("Mario");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).sendKeys("Rossi");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).sendKeys("mario.rossi@email.com");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-18]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-10]")).sendKeys("Mattia");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-13]")).sendKeys("Verdi");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).clear();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-17]")).sendKeys("mattia.verdi@email.com");
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-18]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-2]//*[@x-test-hook-20]//*[@x-test-tpl-23]//*[@x-test-hook-27]")).click();
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
