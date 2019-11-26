package TestCases;

import org.testng.annotations.Test;

import Reuse.BusinessFunctions;
import Scripts.MoodleBadPassword;
import Scripts.MoodleTC;
import base.LaunchBrowser;

public class OCLMS_5893 extends LaunchBrowser {
	
	@Test
	public void MoodleBadPwd() throws Exception {
		
		BusinessFunctions bfs = new BusinessFunctions();
		MoodleBadPassword mbp= new MoodleBadPassword();
		
		bfs.goToApplication();
		mbp.MIncorrectEmail();
		
		
		String Actual = mbp.getTextFromApp();
		System.out.println(Actual);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of Bad Password List");
		if(Actual.contains("forbidden_words.html")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual : "+ Actual    + "  Expected is : forbidden_words.html");
			throw new Exception();
		}
	}

}
