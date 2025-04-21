Feature: Form Page

  Background: Navigate to Forms Page
    When I click on the forms Option

  Scenario Outline: Submit the Form
    When I fill the form with valid details "<firstName>""<lastName>""<email>""<gender>""<mobile>""<dob>""<subjects>""<hobbie>""<picture>""<address>""<state>""<city>"
    And I Submit the form
    Then I should see the form submission success message
    And The submitted data should be displayed correctly in Popup "<firstName>""<lastName>""<email>""<gender>""<mobile>""<expectedDob>""<subjects>""<hobbie>""<picture>""<address>""<state>""<city>"

  Examples:
    | firstName | lastName | email                | gender  | mobile     	 | dob        	 | expectedDob 		| subjects 				| hobbie 				| picture                                		  	| address       | state           | city |
    | John      | Doe      | john.doe@example.com | Female  |1234567890  	 | 17 Aug 1999 	 | 17 August,1999 |Maths,Arts     	| Reading,Music | C:\Users\Josep\Pictures\Screenshots\Test.png  | 123 Main St   | Uttar Pradesh   | Agra |
