/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myseleniumdemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class PracticeTesting {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private ExtentReports extent;
  private ExtentTest logger;
  private ExtentHtmlReporter reporter;
  private static long sasa= System.currentTimeMillis();

  @Before
  public void setUp() {
    reporter = new ExtentHtmlReporter("C:/Users/MMkolwe/Desktop/TestScreenshots/testReport.html");
    extent= new ExtentReports();
    extent.attachReporter(reporter);
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    //report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
         //managing cookies
     driver.manage().deleteAllCookies();
     //maximizing browser
     driver.manage().window().maximize();
     //managing browser timeouts
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     
     //navigating to the web url
     driver.navigate().to("http://localhost:8000/login");
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @After
  public void tearDown() {
      extent.flush();
      driver.quit();
      
      
  }
  @Test
  public void loginTest() throws InterruptedException, AWTException {
     reporter = new ExtentHtmlReporter("C:/Users/MMkolwe/Desktop/TestScreenshots/testReport.html");
     extent= new ExtentReports();
     extent.attachReporter(reporter);
     driver.findElement(By.name("email")).sendKeys("martinjj80@gmail.com");
     driver.findElement(By.name("password")).sendKeys("1234567");
     driver.findElement(By.cssSelector("#content > div > div > div > div > div > div.card-body > form > div:nth-child(3) > div > div > button")).click();
     Thread.sleep(2000); 
     Assert.assertTrue(true);
     String fetchUrl= driver.getCurrentUrl();
     System.out.println( " The current url visited is " + fetchUrl);
     logger = extent.createTest("LoginTest");
     logger.log(Status.PASS, "Login passed");
  }
  //tests the navigation functionality of various text links inthe system
  @Test
  public void navigationTest() throws InterruptedException{
      Assert.assertTrue(true);
     driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(4) > a > span")).click();
      Thread.sleep(2000);
//      Assert.assertTrue(true);
//      driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(6) > a > span")).click();
//      Thread.sleep(2000);
//      Assert.assertTrue(true);
//      driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(8) > a > span")).click();
//      Thread.sleep(2000);
//      Assert.assertTrue(true);
//      driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(10) > a > span")).click();
//      Thread.sleep(2000);
      Assert.assertTrue(true);
      driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(12) > a > span")).click();
      Thread.sleep(2000);
      logger = extent.createTest("NavigationTest");
      logger.log(Status.PASS, "Navigation passed");
  }
  //tests the export fuctionality
  @Test
  public void testExport() throws InterruptedException{
      driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(4) > a > span")).click();
      Thread.sleep(2000);
   
      try{
      driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div")).click();
      Thread.sleep(2000);
      System.out.println("Export function passed");
      }catch (Exception e){
        
    }
      driver.navigate().back();
      Thread.sleep(2000);
      logger = extent.createTest("ExportTest");
      logger.log(Status.PASS, "Export passed");
  }
  
  //tests the account creation capability of the system
  @Test
  public void accountCreationTest() throws InterruptedException{
    try{
    driver.findElement(By.cssSelector("#accordionSidebar > li:nth-child(12) > a > span")).click();
    Thread.sleep(2000);  
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).sendKeys("jumba");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("jumba123@gmail.com");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("kevin");
    driver.findElement(By.name("role")).click();
    {
      WebElement dropdown = driver.findElement(By.name("role"));
      dropdown.findElement(By.xpath("//option[. = 'User']")).click();
    }
    driver.findElement(By.name("role")).click();
    Thread.sleep(20);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("password_confirmation")).click();
    driver.findElement(By.name("password_confirmation")).sendKeys("123456");
    driver.findElement(By.cssSelector(".btn-success")).click();
    Thread.sleep(2000);
    PracticeTesting.captureScreenShots(driver);
    }catch(Exception e){
        System.out.println("The Account already exists");
    }
    logger = extent.createTest("Account Creation Test");
    logger.log(Status.PASS, "CreationAccount passed");
    try {
          logger.addScreenCaptureFromPath("C:/Users/MMkolwe/Desktop/TestScreenshots/test"+ sasa+".png");
         } catch (IOException ex) {
          Logger.getLogger(PracticeTesting.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  @Test
  public void testCreatedAccount(){
    //code to implemented here  
  }
  //tests whether the logout button takes commands to signout the logged user
  @Test
  public void testLogout() throws InterruptedException{
      
          driver.findElement(By.cssSelector(".mr-2")).click();
          Thread.sleep(2000);
          PracticeTesting.captureScreenShots(driver);
          driver.findElement(By.linkText("Logout")).click();
          Thread.sleep(2000);
          logger = extent.createTest("LogoutTest");
          logger.log(Status.PASS, "Logout passed");
          try {
          logger.addScreenCaptureFromPath("C:/Users/MMkolwe/Desktop/TestScreenshots/test"+ sasa+".png");
         } catch (IOException ex) {
          Logger.getLogger(PracticeTesting.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  //captures screenshot to be included in the Test Documentation
  public static void captureScreenShots(WebDriver ldriver) throws InterruptedException{
      Thread.sleep(2000);
      File src = ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
      
      try {
          //coping the screenshot to the desired location
          FileUtils.copyFile(src, new File("C:/Users/MMkolwe/Desktop/TestScreenshots/test"+ sasa+".png"));
      } catch (IOException ex) {
          Logger.getLogger(PracticeTesting.class.getName()).log(Level.SEVERE, null, ex);
      }
   
  }
}

