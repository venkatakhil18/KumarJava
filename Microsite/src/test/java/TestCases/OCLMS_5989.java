package TestCases;

import org.testng.annotations.Test;

import Reuse.BusinessFunctions;
import Scripts.MSLogin;
import base.LaunchBrowser;

public class OCLMS_5989 extends LaunchBrowser{
	
	@Test
	public void VerifyPrivacyPolicy() throws Exception {
		
		BusinessFunctions bfs = new BusinessFunctions();
		MSLogin msl= new MSLogin();
		
		bfs.goToApplication();
		msl.VerifyMSPrivacyPolicy();
		
		String Actual = msl.getTextFromURL();
		System.out.println(Actual);
		LaunchBrowser.childTest = LaunchBrowser.parentTest.createNode("Verification of Privacy Policy URL");
		if(Actual.contains("Privacy-Policy")) {
			LaunchBrowser.childTest.pass("Verification is successfull");
		} else {
			LaunchBrowser.childTest.fail("Verification is not successfull " + "Actual : "+ Actual    + "  Expected is : Privacy-Policy");
			throw new Exception();
		}
	}


}
