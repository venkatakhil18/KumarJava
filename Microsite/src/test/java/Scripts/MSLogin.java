package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


import OR.MSHomePage;
import OR.MSLoginPage;
import WebDriverCommands.ActionDriver;
import base.LaunchBrowser;


	public class MSLogin extends LaunchBrowser {
		
		WebDriver driver;
		ActionDriver adriver;
		Properties prop;
		
		public MSLogin(){
			driver = LaunchBrowser.driver;
			adriver = new ActionDriver();
			
			try {
				prop = new Properties();
				FileInputStream ip = new  FileInputStream("D:\\OCLMS-NTPLMS"
						+ "\\Microsite\\src\\main\\java\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
				
			}
		}
		
		
		
			public void VerifyMSPrivacyPolicy() throws Exception {
				LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verify Microsite Privacy Policy");
				adriver.click(MSLoginPage.btnSignin, "MS Sign-in Tab");
				Thread.sleep(2000);
				adriver.type(MSLoginPage.txtusername, prop.getProperty("username"), "Username textbox");
				adriver.type(MSLoginPage.txtpassword, prop.getProperty("password"), "Password textbox");
				adriver.click(MSLoginPage.btnLogin, "Login Button");
				adriver.click(MSLoginPage.checkboxTC, "T&C checkbox");
				adriver.click(MSLoginPage.btnOK, "Accept T&C OK button");
				adriver.click(MSHomePage.BannerClose, "Banner Close Icon");
				adriver.click(MSHomePage.tabWheelIcon, "Settings Wheel Icon tab");
				Thread.sleep(3000);
				adriver.click(MSHomePage.linkPrivacyPolicy, "Privacy Policy Link");
				adriver.switchTab("Switching to Another tab");
				
				
			}
			
			public String getTextFromURL() throws Exception {
				return adriver.getCurrentURL();
			}
	

}
