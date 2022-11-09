package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static WebDriver driver;
	public static Properties Prop;
	public static Logger logger;
	public Main() {
	Prop= new Properties()	;
	
	try {
		
	FileInputStream Fls= new FileInputStream( "/Users/sasi/eclipse-workspace/Facebook/src/main/java/Config/Config");
	Prop.load(Fls);
	
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	public static void initialization () {
	
	String browserName=	Prop.getProperty("browser");
		
		WebDriverManager.chromedriver().setup();
		if(browserName.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "/Users/sasi/eclipse-workspace/Facebook/src/main/resources/Browsers/chromedriver");
		driver =new ChromeDriver();
		
		
		}
		
			else if(browserName.equals("firefox")) {
				System.setProperty("WebDriver.gecko.driver", "");
			driver =new FirefoxDriver();
		
			}
		driver.manage().window().maximize();
		

		logger= LogManager.getLogger("logs");
		logger.info("maximizing the Browser Window");
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url"));
		logger.info("getting url");
		}
		

	public static void takeScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("/Users/sasi/IdeaProjects/AutomationProject/src/main/Screenshots");
        FileUtils.copyFile(srcFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));

}
	protected ExtentReports extent = new ExtentReports();
	protected ExtentSparkReporter Spark = new ExtentSparkReporter("Extentreport.html");
	
}


