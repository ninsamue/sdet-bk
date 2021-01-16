package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login page$")
	public void user_is_on_google_home_page() throws Throwable {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);

		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	 @When("^User enters \"(.*)\" and \"(.*)\"$")
	 public void enter_username_password_any(String username,String password){
		 
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		 
	 }
	 
	 
	 @When("^User enters username and password$")
	 public void enter_username_password(){
		 
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("password");
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		 
	 }
	 
	 @Then("^Read the page title and confirmation message$")
	 public void read_title_message(){
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
	        
	        //Read the page title and heading
	        String pageTitle = driver.getTitle();
	        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
	        
	        //Print the page title and heading
	        System.out.println("Page title is: " + pageTitle);
	        System.out.println("Login message is: " + confirmMessage);
	 }
	    
	 @And("^Close the Login Form Webpage$")
	 public void close_browser(){
		 driver.close();
	 }

}
