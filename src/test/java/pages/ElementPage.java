package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;

public class ElementPage {
	
	WebDriver driver;
	
	public ElementPage() {
		this.driver = DriverManager.getDriver();
	}
	
	//Element Page
	private By elementField  = By.xpath("//div[text()='Elements']");
	
	// === TextBox ===
	private By textBoxOption = By.xpath("//span[text()='Text Box']");
	private By fullNameField = By.id("userName");
	private By emailField    = By.id("userEmail");
	private By currentAddressField = By.id("currentAddress");
	private By permanentAddressField = By.id("permanentAddress");
	private By submitBtnTxt  	 = By.id("submit");
	private By output 	= By.id("output");
	
	// === CheckBox === 
	private By checkBoxOption = By.xpath("//span[text()='Check Box']");
	private By expandcheckBox = By.xpath("//button[@title='Expand all']");
	
	// === RadioButton === 
	private By radioButtonOption = By.xpath("//span[text()='Radio Button']");
	private By radioOutput = By.xpath("//p[@class='mt-3']");
	
	// === WebTables ===
	private By webTableOption = By.xpath("//span[text()='Web Tables']");
	private By addBtn = By.id("addNewRecordButton");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("userEmail");
	private By age   = By.id("age");
	private By salary = By.id("salary");
	private By department = By.id("department");
	private By submitbtnWebTable = By.id("submit");
	
	
	
	
	
	
	public boolean isElementPageDisplayed() {
		return driver.findElement(elementField).isDisplayed();
	}
	
	// === TextBox ===
	
	public void clickTextBoxOption() {
		driver.findElement(textBoxOption).click();
	}
	
	public void fillDetails(String fullName, String email, String CurrentAddress, String PermanentAddress){
		driver.findElement(fullNameField).sendKeys(fullName);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(currentAddressField).sendKeys(CurrentAddress);
		driver.findElement(permanentAddressField).sendKeys(PermanentAddress);
	} 
	
	
	public void clickSubmit() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement option = wait.until(ExpectedConditions.elementToBeClickable(submitBtnTxt));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",option);

	}

	
	public boolean verifySubmittedDetails(String fullname, String email, String currentAddress, String permanentAddress) {
		
		String outputText = driver.findElement(output).getText();
		//System.out.println(outputText);
		String [] lines = outputText.split("\n");
		
		String extractName = lines[0].split(":")[1].trim();
		String extractEmail = lines[1].split(":")[1].trim();
		String extractCurrentAddress = lines[2].split(":",2)[1].trim();
		String extractPermanentAddress = lines[3].split(":",2)[1].trim();
		
		System.out.println("Original Name: "+fullname+" Table Name: "+extractName);
		System.out.println("Original Email: "+email+" Table Email: "+extractEmail);
		System.out.println("Original CurrentAddress: "+currentAddress+" Table CurrentAddress: "+extractCurrentAddress);
		System.out.println("Original PermanentAddress: "+permanentAddress+" Table PermanentAddress: "+extractPermanentAddress);

		
		return extractName.equals(fullname) && extractEmail.equals(email)
				&& extractCurrentAddress.equals(currentAddress)&& extractPermanentAddress.equals(permanentAddress);
		
			}
	
	// === CheckBox === 

	public void clickCheckBoxOption() {
		driver.findElement(checkBoxOption).click();
	}
	
	public void expandCheckBox() {
		driver.findElement(expandcheckBox).click();
	}
	
	public void selectCheckBox(List<String> checkboxes) {
		for(String checkbox: checkboxes) {
		WebElement checkboxElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/preceding-sibling::input[@type='checkbox']"));
		
		if(!checkboxElement.isSelected()) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",checkboxElement);
		}
	}	}
	
	
	public void verifyCheckbox(List<String> expectedcheckboxes) {
		
		
		for(String checkbox:expectedcheckboxes) {
			WebElement checkboxElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/preceding-sibling::input[@type='checkbox']"));
	//		System.out.println(checkboxElement.getTagName()); 
			boolean isChecked = checkboxElement.isSelected();
		      System.out.println("Verifying checkbox: " + checkbox + " -> Selected: " + isChecked);
			  Assert.assertTrue("Checkbox "+checkbox+" is not selected!",checkboxElement.isSelected());
		}
	}
	
	public void deselectCheckbox(List<String> checkboxes) {
		for(String checkbox: checkboxes) {
			WebElement checkboxElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/preceding-sibling::input[@type='checkbox']"));
			
			if(checkboxElement.isSelected()) {
				((JavascriptExecutor)driver).executeScript("arguments[0].click();",checkboxElement);
			}
		}
		
	}
	
	public void verifyCheckboxDeselection(List<String> expectedcheckboxes) {
		
		for(String checkbox: expectedcheckboxes) {
			WebElement checkboxElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/preceding-sibling::input[@type='checkbox']"));
			System.out.println("Tag Name: " + checkboxElement.getTagName());
			
			boolean isChecked = checkboxElement.isSelected();
	        System.out.println("Verifying checkbox: " + checkbox + " -> Deselected: " + !isChecked);
			Assert.assertFalse("Still the element is selected: ", checkboxElement.isSelected());
		}
	
	}
	
	// === RadioButton === 
	
	public void click_radioButtonOption() {
		driver.findElement(radioButtonOption).click();
	}
	
	public void select_radioButton(String radioButton) {
	WebElement radio = driver.findElement(By.xpath("//label[text()='"+radioButton+"']"));
	radio.click();
	}
	
	public void verifyRadioMessage(String message) {
		String expected = message;
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(radioOutput));
		
		String result = driver.findElement(radioOutput).getText();
		System.out.println("Expected: "+expected);
		System.out.println("Actual: "+result);


		Assert.assertEquals("The Radio button is not selected!", expected, result);
	}
	
	public void verifyRadioButtonSelected(String radioButton) {
		WebElement radio = driver.findElement(By.xpath("//label[text()='"+radioButton+"']/preceding-sibling::input"));
		System.out.println("Radio selection "+radioButton+"->"+radio.isSelected());
		Assert.assertTrue("The Radio button is not selected!", radio.isSelected());
	}
	
	public void verifyNoButton(String radioButton) {
		WebElement radioInput = driver.findElement(By.xpath("//label[text()='"+radioButton+"']/preceding-sibling::input"));
		
		// Debugging print statements
		System.out.println("No is Enabled?: "+radioInput.isEnabled());
		
		Assert.assertFalse("The Radio button is selected!", radioInput.isEnabled());
	}	
	
	// === Web Table ===
	
	public void clickWebTableOption() {
		driver.findElement(webTableOption).click();
	}
	
	public void clickAddBtn() {
		driver.findElement(addBtn).click();
	}
	
	public void enterRegFormDetails(String fName, String lName, String ageVal, String emailVal, String salaryVal, String deptVal) 
	{	driver.findElement(firstName).sendKeys(fName); // passed fname because pageelement variable name and argument name should not be same
	    driver.findElement(lastName).sendKeys(lName);
	    driver.findElement(age).sendKeys(ageVal);
		driver.findElement(email).sendKeys(emailVal);
		driver.findElement(salary).sendKeys(salaryVal);
		driver.findElement(department).sendKeys(deptVal);
	}
	
	public void clickSubmitBtnWebTable() {
		driver.findElement(submitbtnWebTable).click();
	}
	
	public boolean isRecordPresent(String firstName, String lastName, String age) {
		WebElement table = driver.findElement(By.className("rt-table"));
		List<WebElement> allRows = table.findElements(By.className("rt-tr-group"));
		
		for (WebElement row: allRows) {
			List<WebElement> cells = row.findElements(By.className("rt-td"));
			if(cells.size()>3) {
				String actualFirstName = cells.get(0).getText().trim();
				String actualLastName = cells.get(1).getText().trim();
				String actualAge  = cells.get(2).getText().trim();
				
				System.out.println("Expected Name: "+firstName+ " Actual Name -> "+actualFirstName);
				
				if(actualFirstName.equalsIgnoreCase(firstName) 
						&& actualLastName.equalsIgnoreCase(lastName)
						&& actualAge.equalsIgnoreCase(age)) {
					return true;
				}
			}
		}
		return false;
	}
}
