package TestCases;

import org.testng.annotations.Test;

import Reuse.BusinessFunctions;
import Scripts.MoodleTC;
import base.LaunchBrowser;

public class OCLMS_3791 extends LaunchBrowser{
	
	@Test
	public void AcceptTC() throws Exception {
		
		BusinessFunctions bfs = new BusinessFunctions();
		MoodleTC mtc= new MoodleTC();
		
		bfs.goToApplication();
		bfs.login();
		mtc.MoodleAcceptTC();
		
		String Actual = mtc.getTextFromApp();
		System.out.println(Actual);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of User Logged in after clicking Accept TC");
		if(Actual.contains("You are logged in as ")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual : "+ Actual    + "  Expected is : You are logged in as ");
			throw new Exception();
		}
		
		bfs.logout();
		bfs.login();

        mtc.MoodleDntAcptTC();
       
        String Actual1 = mtc.getTextfromMoodleHome();
		System.out.println(Actual1);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of user not Accepting TC");
		if(Actual1.contains("You are not logged in.")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual1 : "+ Actual1    + "  Expected is : You are not logged in. ");
			throw new Exception();
		}
		
	}

	

}
