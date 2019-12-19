package WebDriverCommands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.LaunchBrowser;
import util.TestUtil;


public class ActionDriver {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ActionDriver() {
		driver = LaunchBrowser.driver;
	}
	
	
	/*
	 *Navigate to application
	 *@param url  
	 */
	public void navigateToApplication(String url) throws Exception {
		
		try {
			driver.get(url);
			LaunchBrowser.childTest.pass("Navigated to application sucessfully");
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable to navigate to application");
			throw e;
		}
		
	}
	
	public String getCurrentURL() throws Exception {
		
		try {
			 String text = driver.getCurrentUrl();
			 System.out.println(text);
			 
			LaunchBrowser.childTest.pass("Captured the current URL");
			 return text;
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Current URL not captured");
			throw e;
		}
		
		
		
	}
	
	
	
	/*
	 * Used to perform to click action on links, buttons, checkbox and radio buttons
	 * @param - Get it from OR
	 */
	public void click(By locator, String element) throws Exception {
		
		try {
			driver.findElement(locator).click();
			LaunchBrowser.childTest.pass("Performed click action on : " + element);
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable to perform click action on : " + element, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			LaunchBrowser.childTest.info(e);
			throw e;
		}
		
	}
	
	
	
	
	/*
	 * User to enter data into textbox and Text area
	 * @param locator
	 * @param testData
	 */
	public void type (By locator, String testData, String element)  throws Exception {
		try {
			driver.findElement(locator).sendKeys(testData);
			LaunchBrowser.childTest.pass("Performed type in : " + element + "with data : "+testData);
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable to perform type in : " + element + "with data : "+testData, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			LaunchBrowser.childTest.info(e);
			throw e;
		}
	}
	
	
	
	public String getText(By locator) {
		try {
			String txt = driver.findElement(locator).getText();
			LaunchBrowser.childTest.pass("Text is : " + txt);
			return txt;
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable to return text");
			return null;
		}
		
	}
	
	public void scrollPageUp() {
		  try {
		   JavascriptExecutor js = ((JavascriptExecutor) driver);
		   js.executeScript("window.scrollBy(0,-250)");
		   LaunchBrowser.childTest.pass("Able to scrollup the page");
		  } catch (Exception e) {
		   LaunchBrowser.childTest.fail("Unable to scrollup the page");
		  }
		 
		  
		 }
		 
		 
		 public void scrollPageDown() {
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 }
	
	
	
	
	/*
	 * Perform mouse hover on given element
	 * @param locator
	 * @param element
	 * @throws IOException
	 */
	public void mouseHover(By locator, String element) throws Exception {
		try {
			Actions a = new Actions(driver);
			WebElement mo = driver.findElement(locator);
			a.moveToElement(mo).perform();
			LaunchBrowser.childTest.pass("Performed mouseHover action on :"+element);
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable to perform mouseHover action on : " + element, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			LaunchBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void waitOn() {
		driver.manage().timeouts().implicitlyWait(TestUtil.WAIT, TimeUnit.MINUTES);
	}
	
	
	
	public void newTab(By locator, String element) {
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		driver.findElement(locator);
	} 
	
	
/*	public void switchTab(By locator, String element) {
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		driver.findElement(locator).sendKeys(Keys.CONTROL +"\t");
	}*/
	
	public void switchTab(String element) throws Exception {
		try { 
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));
   	 	LaunchBrowser.childTest.pass("Able switch to another tab :"+element);
   		} catch (Exception e) {
   			LaunchBrowser.childTest.fail("Unable switch to another tab : " + element, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
   			LaunchBrowser.childTest.info(e);
   			throw e;
   		}
	}
	
	
/*	public void switchTab(String element) throws IOException {
		try { 
		Actions action = new Actions(driver);
		 // Switch to Second Tab
		 action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		 LaunchBrowser.childTest.pass("Able switch to another tab :"+element);
		} catch (Exception e) {
			LaunchBrowser.childTest.fail("Unable switch to another tab : " + element, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			LaunchBrowser.childTest.info(e);
			throw e;
		}
	}*/
	
	
	
	
	
	public void Switch(String testData) {
		driver.switchTo().alert().sendKeys(testData);
	}
	
	public void AlertAccept( ) {
		driver.switchTo().alert().accept();
	}
	
	public void AlertDefault() {
		driver.switchTo().defaultContent();
	}
	
	public String screenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
	}
	
	public void NavigateBack() {
		driver.navigate().back();
	}
	


}
