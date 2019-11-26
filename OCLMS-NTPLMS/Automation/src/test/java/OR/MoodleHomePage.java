package OR;

import org.openqa.selenium.By;

public class MoodleHomePage {
	public static By MsgLoggedin = By.xpath("//footer//div[contains(text(),'You are logged in as ')]");
    public static By BtnActMenu	= By.id("action-menu-toggle-0");
    

	//logout
	public static By btnLogout	= By.xpath("//li//a//span[contains(text(),'Log out')]");
    }
