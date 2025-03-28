## Part C 
Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

File Name: `mainscreen.html`

Change:

On line 19, changed "Shop" to "Crazy Computer Shop"

On line 21, changed "Parts" to "Internal Parts"

On line 53, changed "Products" to "Prebuilt Computers"

   
## Part D
Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

File Name: mainscreen.html

 **New files:** aboutscreen.html in templates, and AboutPageController.java in controllers 

Change:

aboutscreen.html is just a html template that the AboutPageController.java can use when /aboutscreen is reached in the URL
The aboutscreen.html gives information about the company and includes a button to get back to the mainscreen

On line 21 of mainscreen.html, added a new button that moves the user to the new about screen

## Part E
Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the data

File Name: BootStrapData.java in bootstrap, InhousePart.java in domain, OutsourcedPart.java in domain

Change: 
        
On line 46-58 of BootStrapData.java, I create 3 outsourced parts, 2 in house parts and save them to their respective repositories.

On line 80-92 of BootStrapData.java, I create 5 Products and save them to the product repository

On line 20-24 of InhousePart.java, I created a new constructor that lets me put all the attributes instead of having to individually set them after the construction

On line 20-27 of OutsourcedPart.java, I created a new constructor that lets me put all the attributes instead of having to individually set them after the construction

These last two changes were not required but I implemented for ease of use

## Part F
Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
-  The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
-  Display a message that indicates the success or failure of a purchase.

File Name: 

Change:

added two new templates for confirmation and error of the buy now button in the forms of `confirmationbuyproduct.html` and `genericerror.html`

added `BuyProductController.java` which implements a route to /buyProduct and uses the passed down ID to find the product in the repository/database. Then using that Product sets its inventory to one less then what it currently is.

On line 88-89 of mainscreen.html, added a "buy now" button to the table which also passed the productID of that rows product to the controller


## Part G
Modify the parts to track maximum and minimum inventory by doing the following:
-  Add additional fields to the part entity for maximum and minimum inventory.
-  Modify the sample inventory to include the maximum and minimum fields.
-  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
-  Rename the file the persistent storage is saved to.
-  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

File Name: 

Change:
    
On line 27-30 of OutsourcedPartForm.html, added two new table fields for max and min inventory
On line 26-29 of InhousePartForm.html, added two new table fields for max and min inventory
On line 55-87 of Part.java added new constructor with max/min inv fileds and create setter and getter methods for both variables, as well as a new CheckInv method to ensure Inv is within range
on line 26-27 of OutsourcedPart.java I modified the constructor to include the min and max fields
On line 20-21 of InhousePart.java I modified the constructor to include the min and max fields
On line 49-51 of AddInhousePartController.java, I added the new checkInv method to check that the Inv is between min and max for Inhouse parts
On line 50-52 of AddOutsourcedPartController.java I add the CheckInv method to check inv size against min and max values before saving.

## Part H
Add validation for between or at the maximum and minimum fields. The validation must include the following:
-  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
-  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
-  Display error messages when adding and updating parts if the inventory is greater than the maximum.

File Name: 

Change:

On Line 32-33 of OutsourcedPartForm.html, added hidden elements that only appear if inventory is above or below limits
On Line 34-35 of InhousePartForm.html, added hidden elements that only appear if inventory is above or below limits
On Line 64-71 added new methods for just checking lowInv or High Inv
On line 50-57 of AddOutsourcedPartController.java added the new methods and trigger the hidden elements to appear by adding an attribute to the model
On line 49-56 of AddInhousePartController.java added the new methods and trigger the hidden elements to appear by adding an attribute to the model


## Part I
Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

File Name: 

Change:
        
On line 159-172 of PartTest.java, added two new tests, that tests the new maxInv limits and Low Inv limits

## Part J
Remove the class files for any unused validators in order to clean your code.

File Name: 

Change:
    
On line X, changed ...

<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
