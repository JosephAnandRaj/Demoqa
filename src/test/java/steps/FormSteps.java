package steps;

import java.io.File;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormPage;

public class FormSteps {
	
	WebDriver driver;
	FormPage formpage = new FormPage(driver);
	
	@When("I click on the forms Option")
	public void I_click_on_the_forms_Option() {
		formpage.clickForms();
	}
	
	@When("I fill the form with valid details {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
	public void fillFormDetails(String firstName,String lastName,String email,String gender, String mobile,String dob,String subjects,String hobbie,String picture,String address,String state,String city) {
		formpage.enterFirstName(firstName);
		formpage.enterLastName(lastName);
		formpage.enterEmail(email);
		formpage.selectGender(gender);
		formpage.enterMobileNumber(mobile);
		formpage.selectDOB(dob);
		formpage.enterSubjects(subjects);
		formpage.hobbies(hobbie);
		formpage.uploadPicture(picture);
		formpage.enterCurrentAddress(address);
		formpage.selectState(state);
		formpage.SelectCity(city);
	}
	
	@And("I Submit the form")
	public void i_Submit_the_form() throws InterruptedException {
		formpage.clickSubmit();
	}
	
    @Then("I should see the form submission success message")
    public void i_should_see_the_form_submission_success_message() {
    	String expectedMsg = "Thanks for submitting the form";
    	String actualMsg = formpage.ConfirmationMessage();
    	Assert.assertEquals("Confirmation Message not displayed! ", expectedMsg, actualMsg);
    	System.out.println("Expected -> "+expectedMsg+" Actual -> "+actualMsg);
    }
    
    @And("The submitted data should be displayed correctly in Popup {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void the_submitted_data_should_be_displayed_correctly_in_Popup(String firstName, String lastName, String email, String gender, String mobile, String dob, String subjects, String hobbie, String picture, String address, String state, String city) {
        
        // Create SoftAssertions instance
        SoftAssertions softAssertions = new SoftAssertions();
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Student Name"))
                .as("Student Name is mismatched") 
                .isEqualTo(firstName + " " + lastName);

        softAssertions.assertThat(formpage.getPopupFieldValue("Student Email"))
                .as("Student Email is mismatched") 
                .isEqualTo(email);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Gender"))
                .as("Gender is mismatched") 
                .isEqualTo(gender);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Mobile"))
                .as("Mobile is mismatched") 
                .isEqualTo(mobile);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Date of Birth"))
                .as("Date of Birth is mismatched") 
                .isEqualTo(dob);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Subjects").replace(" ", ""))
                .as("Subjects are mismatched") 
                .isEqualTo(subjects);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Hobbies").replace(" ", ""))
                .as("Hobbies are mismatched") 
                .isEqualTo(hobbie);
        
        String expectedPicture = new File(picture).getName();
        softAssertions.assertThat(formpage.getPopupFieldValue("Picture"))
                .as("Picture is mismatched") 
                .isEqualTo(expectedPicture);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("Address"))
                .as("Address is mismatched") 
                .isEqualTo(address);
        
        softAssertions.assertThat(formpage.getPopupFieldValue("State and City"))
                .as("State and City are mismatched") 
                .isEqualTo(state + " " + city);
        
        // Perform all soft assertions at the end
        softAssertions.assertAll();
    }
}
