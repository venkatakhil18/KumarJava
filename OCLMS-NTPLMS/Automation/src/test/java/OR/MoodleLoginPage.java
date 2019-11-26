package OR;

import org.openqa.selenium.By;

public class MoodleLoginPage {
	
	public static By txtusername= By.id("username");
	public static By txtpassword= By.id("password");
	public static By btnlogin=By.id("loginbtn");
	public static By textarea=By.xpath("//div[@class='loginerrors']//span[contains(text(),'Invalid login, please try again')]");
	public static By txtsignup = By.id("signup");
	public static By btnAcceptTC = By.xpath("//*[@id=\"modal-footer\"]/div/div[1]/form/div/input[1]");
	public static By btnDntAcptTC = By.xpath("//*[@id=\"modal-footer\"]/div/div[2]/form/div/input[1]");
	public static By MsgLoggedout = By.xpath("//footer//div[@class='logininfo']");

}
