Feature: Elements Page

  Background: Navigate to Elements Page
    When I click on the Element Option

	@elementsPage
  Scenario: Verify Elements Page
  	When I click on the Element Option
  	Then I should navigate to the Element Page
  
  @elementsPage @textBox
  Scenario: Verify Text Box Form Submission
    When I click on the Text Box Option
    And I Fill the following details "<Full Name>" "<Email>" "<Current Address>" "<Permanent Address>"
    And I Submit the Form
    Then I should see the submitted details "<Full Name>" "<Email>" "<Current Address>" "<Permanent Address>"

    Examples: 
      | Full Name | Email          | Current Address                        | Permanent Address                      |
      | Joseph    | J123@gmail.com | 120/1,Ramrajan Street, Chennai, 600035 | 130/2,Sterling Street, Chennai, 600035 |
  		|	Anand			 | A123@gmail.com	| 130/1,Ramrajan Street, Chennai, 600035	| 140/2,Sterling Street, Chennai, 600035 |
 
  @elementsPage @checkBox
   Scenario: Verify CheckBox Selection
    When I click on the Check Box Option
    And I Expand the Check Box Tree
    And I Select the Checkboxes "Desktop,Documents"
    Then I should see the selected Checkboxes "Desktop,Documents,Notes,Commands,WorkSpace,React,Angular,Veu,Office,Public,Private,Classified,General"
   
  @elementsPage @checkBox
   Scenario: Verify Parent-Child Checkbox Deselection
    When I click on the Check Box Option
    And I Expand the Check Box Tree
    And I Select the Checkboxes "Desktop"
   	And I deselect the checkbox "Desktop"
  	Then I should not see the selected Checkboxes "Desktop,Notes,Commands"
  	
   @elementsPage @radioButton
    Scenario: Verify Radio button selection
    	When I click on the Radio button Option
    	And I select the "<Radio button>" in Radio button
    	Then the "<Radio button>" should get selected
   # 	And I should see the message "You have selected <Radio button>"
    	
    	Examples:
  	    	|Radio button|
    			|Yes				 |
    			|Impressive	 |   
    			 	 
    @elementsPage @radioButton	 
    Scenario: Verify "No" Radio button is Disabled
    	When I click on the Radio button Option
    	Then the "No" Radio button should be disabled 
    	
    @elementsPage @webTable 
    Scenario: Add a new record to the Web Table
    	When I click on the WebTable option
    	And I click on the Add button
    	And I enter the "<First Name>""<Last Name>""<Age>""<Email>""<Salary>""<Department>" 
    	And I submit the form
    	Then the record "<First Name>""<Last Name>""<Age>" should be added to the table
 
   Examples:  	
    	|First Name	|Last Name | Age| Email					 |Salary	| Department			 | 	 
    	|Joseph			|Anand Raj | 25	| J123@gmail.com |23000   | Quality Assurance|
    	
  #  @elementsPage @webTable
    Scenario: Search for a record in the table
    	When I search for "Joseph"
  		Then the table should display only records that contain "Joseph."

 #   @elementsPage @webTable
    Scenario: Edit an existing record in the Web Table
    	Given a record exists with the First Name "Joseph"
    	When I find row containing "Joseph" and click the Edit button
    	And I update the "Last Name" field to "Anand Raj O" 
    	And I submit changes
    	Then the record should get updated in the table 
    	
  #  @elementsPage @webTable
    Scenario: Delete an existing record in the Web Table
   		Given a record exists with the First Name "Joseph"
   		When I delete the record
   		Then the record should get deleted from the table
   		
  # 	@elementsPage @webTable
   	Scenario: Verify sorting the "First Name" column in ascending Order
   		When I click on the "First Name" column header "1" time
   		Then the record should be sorted in ascending order
   	
  # 	@elementsPage @webTable
   	Scenario Outline: Verify sorting by "<Column>" in "<Order>" order
    	When I click on the "<Column>" column header "<Click Count>" times
    	Then the records should be sorted in "<Order>" order based on "<Column>"

		Examples:
    | Column     | Order      | Click Count |
    | First Name | ascending  | 1          |
    | First Name | descending | 2          |
    | Age        | ascending  | 1          |
    | Age        | descending | 2          |
    | Salary     | ascending  | 1          |
    | Salary     | descending | 2          |
    
    #Need to check Pagination next/previous/number of rows
    #Need to check the data available in table without searching the data
   		
   	
    
   	
    
  
  	
    