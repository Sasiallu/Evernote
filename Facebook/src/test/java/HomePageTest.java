
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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



public class HomePageTest extends Main{
	
	HomePage Hp;
MyAccount MyAcnt;
	

	public HomePageTest() {
		super();
		
		try {
			Hp.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setup() {
		initialization();
		Hp= new HomePage();
		MyAcnt= new MyAccount();
		MyAcnt=Hp.verifylogin(Prop.getProperty("username"), Prop.getProperty("password"));
		
		
		try {
			MyAcnt.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		   
@Test

public void Verifytitle() {
	String actualtitle=Hp.verifyTitle();
	String expected= "Welcome Back";
	
	Assert.assertEquals(actualtitle, expected);
	
}
@Test
public MyAccount verifysignin() {
	MyAcnt=Hp.verifylogin(Prop.getProperty("username"), Prop.getProperty("password"));
	 return new MyAccount();
	
}

@AfterTest

public void aftertest() {
	extent.flush();
}

@AfterMethod
public void aftermethod() {
	driver.quit();
}
}




