package Pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Main.Main;

public class MyAccount extends Main{
	
	@FindBy (xpath="//a[@class=\"oxd-brand\"]")
	WebElement LOGO;
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	WebElement Profile;
	@FindBy(xpath="//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	WebElement Dashboard;
	
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle(){
		String Title = driver.getTitle();
		return Title;
		

	}
	public boolean verifylogo() {
		boolean logo = LOGO.isDisplayed();
		return logo;
	
	
	}
	public boolean verifyAccount() {
		boolean Prfl =Profile.isDisplayed();
		return Prfl;
		
	}	
	public boolean verifyDashboard() {
		boolean Notice =Dashboard.isDisplayed();
		return Notice;
		
	}	
	

}
