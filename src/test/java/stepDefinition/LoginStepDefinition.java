package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition extends BaseClass {
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		setUp();
	    
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String uname, String pwd) throws Throwable {
		
		logger.info("Entering login details....");
		
		driver.findElement(By.xpath("//form[@id='login_form']/input[2]")).clear();
		driver.findElement(By.xpath("//form[@id='login_form']/input[2]")).sendKeys(uname);
		driver.findElement(By.xpath("//form[@id='login_form']/input[3]")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='i_submit']")).click();
	    
	}

	@Then("^User should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Test App"));
		String actualTitle=driver.getTitle();
	    String expectedTitle="Test App";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    
	    logger.info("Login Test completed...");
	    
	    tearDown();
	}


}
