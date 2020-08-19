package stepDefinition;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	String path=System.getProperty("user.dir")+"/ApplicationPath/index.html";
	public static Logger logger;
	
	
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		logger=Logger.getLogger("Basware");
		PropertyConfigurator.configure("log4j.properties");
		driver.get(path);
		logger.info("Url is opened");
		
	}
	
	public void tearDown(){
		driver.quit();
		
	}

}
