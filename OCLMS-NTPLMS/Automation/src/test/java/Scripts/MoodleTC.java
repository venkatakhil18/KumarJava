package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import OR.MoodleHomePage;
import OR.MoodleLoginPage;
import WebDriverCommands.ActionDriver;
import base.LaunchBrowser;

public class MoodleTC {
	WebDriver driver;
	ActionDriver adriver;
	Properties prop;
	
	public MoodleTC() {
		driver = LaunchBrowser.driver;
		adriver = new ActionDriver();
		
	
	
	try {
		prop = new Properties();
		FileInputStream ip = new  FileInputStream("D:\\OCLMS-NTPLMS\\Automation\\src\\main\\java\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	} catch (IOException e) {
			e.printStackTrace();
		
	}
}
	
	
	public void MoodleAcceptTC() throws IOException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Accept Terms and Conditions");
		adriver.click(MoodleLoginPage.btnAcceptTC, "Accept Button");
		
	} 
	
	
	public String getTextFromApp() {
		 String text = adriver.getText(MoodleHomePage.MsgLoggedin);
		 System.out.println(text);
		 return text;
	}
	
	public void MoodleDntAcptTC() throws IOException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Do not Accept Terms and Conditions");
		adriver.click(MoodleLoginPage.btnDntAcptTC, "Do not Accept Button");
	}
	
	public String getTextfromMoodleHome() {
		 String text = adriver.getText(MoodleLoginPage.MsgLoggedout);
		 System.out.println(text);
		 return text;
	}
}