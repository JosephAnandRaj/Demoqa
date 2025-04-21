package steps;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;
import utilities.ConfigReader;

public class Hooks {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		DriverManager.getDriver().get(ConfigReader.get("url"));

	}
	
	@After
	public void teardown() {
		DriverManager.quitDriver();
	}

}
