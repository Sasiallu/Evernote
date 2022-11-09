package Pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Main.Main;



public class HomePage extends Main{
	
	
		
		@FindBy(xpath="//img[@src=\"/web/images/ohrm_branding.png?1666596668857\"]")
		WebElement Logo;
		
		@FindBy (xpath="//input[@name=\"username\"]")
		WebElement username;
		
		@FindBy(xpath="//input[@type=\"password\"]")
		WebElement password;
		
		@FindBy (xpath = "//button[@type=\"submit\"]")
		WebElement Signin;
		
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		public String verifyTitle(){
			String Title = driver.getTitle();
			return Title;
			
		}
		
		public boolean verifylogo() {
			boolean logo=Logo.isDisplayed();
			return logo;
		}
		
			
		public MyAccount verifylogin(String un,String pwd) {
				username.sendKeys(un);
				password.sendKeys(pwd);
				Signin.click();
				return  new MyAccount();
			
			
	}
		public MyAccount  signin() {
			Signin.submit();
			return new MyAccount();
		}
	}



