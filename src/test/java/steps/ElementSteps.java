package steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ElementPage;
import pages.HomePage;

public class ElementSteps {
	
	WebDriver driver;
	HomePage homepage = new HomePage();
	ElementPage elementpage = new ElementPage();

	@When("I click on the Element Option")
	public void clickElementOption() {
		homepage.clickElementsOption();
	}
	
	@Then("I should navigate to the Element Page")
	public void verifyElementPage() {
		Assert.assertTrue("ElementPage not displayed!", elementpage.isElementPageDisplayed());
	}
	
	// === TextBox ===
	
	@When("I click on the Text Box Option")
	public void clickTextBoxOption() {
		elementpage.clickTextBoxOption();
	}
	
	@And("I Fill the following details {string} {string} {string} {string}")
	public void fillDetails(String fullName, String email, String CurrentAddress, String PermanentAddress) {
		elementpage.fillDetails(fullName, email, CurrentAddress, PermanentAddress);
	}
	
	@And("I Submit the Form")
	public void submitForm() {
		elementpage.clickSubmit();
	}
	
	@Then("I should see the submitted details {string} {string} {string} {string}")
	public void verifySubmittedDetails(String fullname, String email,String currentAddress, String permanentAddress) {
		Assert.assertTrue("Form details Incorrect", elementpage.verifySubmittedDetails(fullname, email, currentAddress, permanentAddress));
	}

	// === CheckBox ===
	
	@When("I click on the Check Box Option")
	public void i_click_on_the_check_box_option() throws InterruptedException {
		elementpage.clickCheckBoxOption();
		Thread.sleep(2000);

	}
	
	@When("I Expand the Check Box Tree")
	public void i_expand_the_check_box_tree() {
		elementpage.expandCheckBox();
	}
	
	@When("I Select the Checkboxes {string}")
		public void i_select_the_checkboxes(String checkboxnames) {
		    List<String> checkboxes = new ArrayList<>(Arrays.asList(checkboxnames.split(",")));
		    elementpage.selectCheckBox(checkboxes);
		}
	
	@Then("I should see the selected Checkboxes {string}")
	public void i_should_see_the_selected_checkboxes(String CheckboxNames) {
		List <String> expectedcheckboxes = new ArrayList<>(Arrays.asList(CheckboxNames.split(",")));
		elementpage.verifyCheckbox(expectedcheckboxes);
	}
	
	@When("I deselect the checkbox {string}")
	public void i_deselect_the_checkbox(String checkboxName) {
		List<String> checkbox = new ArrayList<>(Arrays.asList(checkboxName.split(",")));
		elementpage.deselectCheckbox(checkbox);
	}
	@Then("I should not see the selected Checkboxes {string}")
	public void i_should_not_see_the_selected_checkboxes(String expectedcheckboxes) throws InterruptedException {
		List<String> checkbox = new ArrayList<>(Arrays.asList(expectedcheckboxes.split(",")));
		elementpage.verifyCheckboxDeselection(checkbox);
		Thread.sleep(5000);
	    
	}
	
	// === RadioButton ===

	@When("I click on the Radio button Option")
	public void i_click_on_the_radio_button_option() {
	    elementpage.click_radioButtonOption();
	}
	
	@When("I select the {string} in Radio button")
	public void i_select_the_in_radio_button(String radioButton) {
		elementpage.select_radioButton(radioButton);
	}
	
	@Then("I should see the message {string}")
	public void i_should_see_the_message(String message) {
		elementpage.verifyRadioMessage(message);
	}
	
	@Then("the {string} should get selected")
	public void the_radio_button_should_get_selected(String radioButton){
		elementpage.verifyRadioButtonSelected(radioButton);
	}
	

	
	@Then("the {string} Radio button should be disabled")
	public void the_radio_button_should_be_disabled(String radiobutton) {
	    elementpage.verifyNoButton(radiobutton);
	}
	
	// === Web Table ===
	
	@When("I click on the WebTable option")
	public void clickWebTableOption() {
		elementpage.clickWebTableOption();
	}
	
	@When("I click on the Add button")
	public void i_click_on_the_add_button() {
	    elementpage.clickAddBtn();
	}
	
	@When("I enter the {string}{string}{string}{string}{string}{string}")
	public void i_enter_form_Details(String firstName, String lastName, String age, String email, String salary, String department) {
	    elementpage.enterRegFormDetails(firstName, lastName, age, email, salary, department);
	    
	}

	
	@When("I submit the form")
	public void i_submit_the_form() throws InterruptedException {
	    elementpage.clickSubmitBtnWebTable();
	    Thread.sleep(5000);
	}
	
	@Then("the record {string}{string}{string} should be added to the table")
	public void the_record_should_be_added_to_the_table(String firstName, String lastName, String age) {
	 boolean recordexists = elementpage.isRecordPresent(firstName,lastName,age);
	 Assert.assertTrue("Record not found!",recordexists);
	 
	}



	

}
