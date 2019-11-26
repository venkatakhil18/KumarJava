package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import OR.CreateAccountPage;
import OR.MoodleLoginPage;
import WebDriverCommands.ActionDriver;
import base.LaunchBrowser;

public class MoodleBadPassword extends LaunchBrowser {
	
	WebDriver driver;
	ActionDriver adriver;
	Properties prop;
	
	public MoodleBadPassword() {
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
	 
	
	public void MIncorrectEmail() throws IOException {
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verify Invalid Email Address");
		adriver.click(MoodleLoginPage.txtsignup, "Create Account Button");
		adriver.type(CreateAccountPage.txtEmail, "monkeybrand", "Email Textbox");
		adriver.type(CreateAccountPage.txtPwd, "password", "Password Textbox");
		adriver.type(CreateAccountPage.txtCnfmEmail, "monkeybrand", "Email Confirm Textbox");
		adriver.type(CreateAccountPage.txtFN, "monkey", "First Name Textbox");
		adriver.type(CreateAccountPage.txtLN, "brand", "Last Name textbox");
		adriver.click(CreateAccountPage.btnSubmit, "Create Account Button");
		adriver.click(CreateAccountPage.lnkBadPwdList, "Bad password List Link");
		adriver.switchTab("Switching to another tab");
		//adriver.getCurrentURL();
		
	}
	
	
	public String getTextFromApp() {
		return adriver.getCurrentURL();
	}
	
	




}
