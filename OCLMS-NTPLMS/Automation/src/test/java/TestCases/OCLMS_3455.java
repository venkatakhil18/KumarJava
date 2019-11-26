package TestCases;

import org.testng.annotations.Test;

import Reuse.BusinessFunctions;
import Scripts.MoodleIncorrectEmail;
import base.LaunchBrowser;

public class OCLMS_3455 extends LaunchBrowser{
	
	@Test
	public void VerifyInvalidEmail() throws Exception {
		
		BusinessFunctions bfs = new BusinessFunctions();
		MoodleIncorrectEmail mie= new MoodleIncorrectEmail();
		
		bfs.goToApplication();
		mie.MIncorrectEmail();
		
		String Actual = mie.getTextFromApp();
		System.out.println(Actual);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of Error Message");
		if(Actual.contains("Invalid email address")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual : "+ Actual    + "  Expected is : Invalid email address");
			throw new Exception();
		}
	}

}
