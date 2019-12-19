package OR;

import org.openqa.selenium.By;

public class MSLoginPage {
	public static By btnSignin = By.xpath("//button//div[contains(text(),'Log In')]");
	public static By txtusername = By.id("SignInEmail");
	public static By txtpassword = By.id("SignInPassword");
	public static By btnLogin = By.xpath("//button[@type='submit']");
	public static By checkboxTC = By.id("RulesOfConductAgree");
	public static By btnOK = By.id("ModalButton0");

}
