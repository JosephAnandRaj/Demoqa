package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.DriverManager;

public class HomePageSteps {

	WebDriver driver;
	HomePage homepage = new HomePage();
	
    @Given("I am on the DemoQA homepage")
	public void iAmOnTheDemoQAHomePage() {
    	Assert.assertTrue("HomePage not displayed!", homepage.isHomePageDisplayed());

	}
	@Then ("I verify HomePage is displayed")
	public void verifyHomePage() {
	Assert.assertTrue("HomePage not displayed!", homepage.isHomePageDisplayed());
	}
	
	@After
	public void teardown() {
		DriverManager.quitDriver();
	}
	
}
