


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Main.Main;
import Pagepackage.HomePage;
import Pagepackage.MyAccount;
public class MyAccountTest extends Main{
	
	HomePage Hp;
	
	MyAccount MyAcnt;
	public MyAccountTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		Hp= new HomePage();
		
		MyAcnt= new MyAccount();
		
		
		MyAcnt=Hp.verifylogin(Prop.getProperty("username"), Prop.getProperty("password"));
		Hp.signin();
		

		logger.info("setting up the Homepage");
		try {
			MyAcnt.takeScreenshot();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	@BeforeTest
	public void beforeTest() {
		extent.attachReporter(Spark);
	}
	
@Test
	public void FourthTest() {
		 ExtentTest test = extent.createTest("verify Signin").assignAuthor("sai").assignCategory("Regression test").assignDevice("firefox");
		    test.info("Signin Button displayed");
		    test.pass("Verifying Login Credentials");
	}
		   
@Test(priority=1)

public void Verifytitle() {
	String actualtitle=MyAcnt.verifyTitle();
	String expected= "Welcome Back";
	
	AssertJUnit.assertEquals(actualtitle, expected);
	
	ExtentTest test = extent.createTest("verify Signin").assignAuthor("sai").assignCategory("Regression test").assignDevice("firefox");
    test.info("Signin Button displayed");
    test.pass("Verifying Login Credentials");
	
}
@Test(priority=2)
public boolean verifyTab1() {
	boolean  LOGO=MyAcnt.verifylogo();
	return LOGO;
}
	

@Test(priority=3)
public boolean verifyTab2() {
boolean NewMSG= MyAcnt.verifylogo();
return NewMSG;
	
	
	 }
@Test
public boolean verifyTab3() {
	boolean NOTICE= MyAcnt.verifyDashboard();
	return NOTICE;

}



@AfterTest
public void afterTest() {
	extent.flush();
}

@AfterMethod

public void Teardown() {
	driver.close();
}

}



