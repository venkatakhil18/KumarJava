package TestCases;

import org.testng.annotations.Test;

import Reuse.BusinessFunctions;
import Scripts.MoodleIncorrectLogin;
import base.LaunchBrowser;

public class OCLMS_3456 extends LaunchBrowser {
	 
	@Test
	public void testHomePage() throws Exception {
		
		BusinessFunctions bfs = new BusinessFunctions();
		MoodleIncorrectLogin mil= new MoodleIncorrectLogin();
		
		bfs.goToApplication();
		mil.MIncorrectLogin();
		
		String Actual = mil.getTextFromApp();
		System.out.println(Actual);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of Error Message");
		if(Actual.contains("Invalid login, please try again")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual : "+ Actual    + "  Expected is : Invalid login, please try again");
			throw new Exception();
		}
		
	}

}
