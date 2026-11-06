SauceDemo – Java Selenium Automation

Project Overview

This project contains automated UI tests for the SauceDemo web application.

The purpose of this project is to validate key e-commerce functionalities, including user authentication, product management, shopping cart operations, checkout, product filtering, and logout.

Technologies and Tools

Java

Selenium WebDriver 4.38.0

JUnit

Page Object Model (POM)

JSON test data

Selenium Manager

Eclipse IDE

Automated Test Scenarios

The project covers the following scenarios:

Valid Login – Verify login using valid standard user credentials.

Invalid Login – Verify login behavior with incorrect or missing credentials.

Locked-Out User Login – Verify that a locked-out user cannot access the application.

Shopping Cart Management – Add and remove products from the shopping cart.

Product Purchase – Verify product details, cart contents, checkout information, order overview, and order completion.

Product Filtering – Verify all available product sorting options.

Logout – Verify that users can successfully log out.

Project Structure

The project follows the Page Object Model (POM) design pattern to separate page elements, application interactions, and test logic.

Test data is managed using JSON files.

Test Execution

Clone or download this repository.

Import the project into Eclipse as an existing Java project.

Make sure the required Java and Selenium dependencies are available.

Open the desired test class.

Right-click the test and select Run As → JUnit Test.

Selenium Manager is used to manage the browser driver.

Application Under Test

SauceDemo

Author

Florin Steopoaie

GitHub: SteopoaieFlorin
