package Reuse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import OR.MoodleHomePage;
import OR.MoodleLoginPage;
import WebDriverCommands.ActionDriver;
import base.LaunchBrowser;

public class BusinessFunctions {

	WebDriver driver;
	ActionDriver adriver;
	public static Properties prop;
	
	
	public BusinessFunctions() {
		driver = LaunchBrowser.driver;
		adriver = new ActionDriver();
		
			
			
			try {
				prop = new Properties();
				FileInputStream ip = new  FileInputStream("D:\\OCLMS-NTPLMS"
						+ "\\Automation\\src\\main\\java\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
				
			}
		}

	
	
	public void goToApplication() throws Exception {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Navigate to CMS");
		adriver.navigateToApplication(prop.getProperty("MoodleURL"));
		Thread.sleep(3000);
	}
	
	
	
	public void login() throws IOException, InterruptedException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Navigate to Login");
		
		adriver.type(MoodleLoginPage.txtusername, prop.getProperty("username"), "username textbox");
		adriver.type(MoodleLoginPage.txtpassword, prop.getProperty("password"), "password textbox");
		adriver.click(MoodleLoginPage.btnlogin, "Login button");
		Thread.sleep(3000);
	}
	
	
	
	
	public void logout() throws IOException, InterruptedException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Navigate to Login");
		
		adriver.click(MoodleHomePage.BtnActMenu,"My account menu");
		adriver.click(MoodleHomePage.btnLogout,"Logout Button");
		Thread.sleep(3000);
	}
	
	
	
	
}
