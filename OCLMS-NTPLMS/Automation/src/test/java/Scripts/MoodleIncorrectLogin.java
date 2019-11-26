package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import OR.MoodleLoginPage;
import WebDriverCommands.ActionDriver;
import base.LaunchBrowser;

public class MoodleIncorrectLogin extends LaunchBrowser {
	
	WebDriver driver;
	ActionDriver adriver;
	Properties prop;
	
	public MoodleIncorrectLogin() {
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
	 
	
	public void MIncorrectLogin() throws IOException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Navigate to Login");
		adriver.type(MoodleLoginPage.txtusername, "monkeybrand", "username textbox");
		adriver.click(MoodleLoginPage.btnlogin, "Login Button");
	}
	
	
	public String getTextFromApp() {
		 String text = adriver.getText(MoodleLoginPage.textarea);
		 System.out.println(text);
		 return text;
	}




	
	

}
