package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {
	
	 WebDriver driver;
	 
	 public HomePage() {
		 this.driver = DriverManager.getDriver();
	 }
	 
	 private By pageHeader = By.xpath("//a[contains(@href, 'demoqa.com')]/img");
	 private By elementsOption = By.xpath("//h5[contains(text(),'Elements')]");

	 
	 //Actions
	 public boolean isHomePageDisplayed() {
		 return driver.findElement(pageHeader).isDisplayed();

	 }
	 
	 public void clickElementsOption() {
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement option = wait.until(ExpectedConditions.elementToBeClickable(elementsOption));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",option);

	 }
	 
	


}
