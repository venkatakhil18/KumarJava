package OR;

import org.openqa.selenium.By;

public class CreateAccountPage {
	
	public static By txtEmail = By.id("id_username");
	public static By txtPwd = By.id("id_password");
	public static By txtCnfmEmail = By.id("id_email");
	public static By txtFN = By.id("id_firstname");
	public static By txtLN = By.id("id_lastname");
	public static By btnSubmit = By.id("id_submitbutton");
	public static By errorMsg = By.xpath("//div//span[contains(text(),'Invalid email address')]");
	public static By lnkBadPwdList = By.linkText("Bad password list");
	public static By switchtab = By.cssSelector("body");
	public static By txtBadPwd = By.xpath("//body//h1[contains(text(),'Forbidden words in passwords')]");
	
	

}
