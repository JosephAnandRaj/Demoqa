package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {
	WebDriver driver;
	
	public void basicAlert() throws InterruptedException {
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		
		System.out.println("Basic alert: "+alert.getText());
		alert.accept();
	}
	
	public void confirmAlert() throws InterruptedException {
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Prompt Alert:"+alert.getText());
		alert.accept();
	}
	
	public void promptAlert() throws InterruptedException {
		
		WebElement promptButton = driver.findElement(By.id("promtButton"));
		
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptButton);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", promptButton);

		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Joseph");
		alert.accept();
	//	alert.dismiss();
		
		String result = driver.findElement(By.id("promptResult")).getText();
		System.out.println(result);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Alerts a = new Alerts();
		a.driver = Setups.browser("alert");
	//	a.basicAlert();
	//	a.confirmAlert();
		a.promptAlert();
		Setups.quitBrowser();
	}

}
