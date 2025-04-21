package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;

public class FormPage {
	
	WebDriver driver;
	
	public FormPage(WebDriver driver) {
		 this.driver = DriverManager.getDriver();
	}
	
	private By forms = By.xpath("//h5[text()='Forms']");
	private By formsOption = By.xpath("//div[text()='Forms']");
	private By practiceForm = By.xpath("//span[text()='Practice Form']");
	
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("userEmail");
	private By mobileNumber = By.id("userNumber");
	private By dob = By.id("dateOfBirthInput");
	private By subjects = By.id("subjectsInput");
	private By picture = By.id("uploadPicture");
	private By currentAddress = By.id("currentAddress");
	private By state = By.xpath("//div[text()='Select State']");
	private By city = By.id("city");
	private By submitbtn = By.id("submit");
	private By cnfMsg = By.id("example-modal-sizes-title-lg"); 
	
	public void clickForms() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement formsMenu = wait.until(ExpectedConditions.elementToBeClickable(forms));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",formsMenu);

		driver.findElement(formsOption).click();
		 WebElement practiceFormOption = wait.until(ExpectedConditions.elementToBeClickable(practiceForm));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceFormOption);
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",practiceFormOption);
	}
	
	public void enterFirstName(String firstNameInput) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstNameOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		firstNameOption.sendKeys(firstNameInput);
	}
	   
	public void enterLastName(String lastNameInput) {
	        driver.findElement(lastName).sendKeys(lastNameInput);
	 }	
	
	 public void enterEmail(String emailInput) {
	        driver.findElement(email).sendKeys(emailInput);
	    }
	 
	 public void selectGender(String genderInput) {
		 WebElement genderOption = driver.findElement(By.xpath("//label[text()='"+genderInput+"']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);
		 genderOption.click();
	 }
	 
	 public void enterMobileNumber(String mobileInput) {
	        driver.findElement(mobileNumber).sendKeys(mobileInput);
	    }
	 
	 public void selectDOB(String dobInput) {
		WebElement dobfield = driver.findElement(dob);
		dobfield.sendKeys(Keys.CONTROL+"a");
		dobfield.sendKeys(dobInput);
		dobfield.sendKeys(Keys.ENTER);
	 }
		
	 public void enterSubjects(String subjectsInput) {
		 String[] subjectArray = subjectsInput.split(",");
	     WebElement subject = driver.findElement(subjects);

		 for(String subjects: subjectArray) {
			 subject.sendKeys(subjects);
		     subject.sendKeys(Keys.ENTER);
		 }
		 
	    }
	 
	 public void hobbies(String hobbieInput) {
		 String[] hobbiesArray = hobbieInput.split(",");
		 
		 for(String hobbie: hobbiesArray) {
		 WebElement hobbiesOption = driver.findElement(By.xpath("//label[text()='"+hobbie+"']"));
		 hobbiesOption.click();
		 }
	 }
	 
	 public void uploadPicture(String picturePath) {
	        driver.findElement(picture).sendKeys(picturePath);
	    }
	 
	 public void enterCurrentAddress(String addressInput) {
	        driver.findElement(currentAddress).sendKeys(addressInput);
	    }
	 
	 public void selectState(String stateInput) {
		 WebElement dropdown = driver.findElement(state);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		 dropdown.click();
		 
		 WebElement input = driver.findElement(By.id("react-select-3-input"));
		 input .sendKeys(stateInput);
		 input.sendKeys(Keys.ENTER);
	 }
	 
	 public void SelectCity(String cityInput) {
		 driver.findElement(city).click();
		 WebElement input = driver.findElement(By.id("react-select-4-input"));
		 input.sendKeys(cityInput);
		 input.sendKeys(Keys.ENTER);
	 }
	 
	 public void clickSubmit() {
		 driver.findElement(submitbtn).click();
	 }
	 
	 public String ConfirmationMessage() {
		return driver.findElement(cnfMsg).getText();
	 }
	 
	 public String getPopupFieldValue(String fieldName) {
		return driver.findElement(By.xpath("//td[contains(text(),'"+fieldName+"')]/following-sibling::td")).getText();
	 }
	 
	 	 
	 private static void waitForInteraction()  {
		 try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

		
	}

