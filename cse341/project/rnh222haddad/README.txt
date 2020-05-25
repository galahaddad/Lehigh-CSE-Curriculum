#CSE 341 - Final Project - Nickel Bank
Ralph Haddad, Spring 2020

File Information:
+rnh222haddad
| +rnh222: 
| | +project.java - the main java file of my project, contains a menu to transfer between object classes and allows for modularizeability
| | +Customer.java - the bulk java class setup in an object-oriented manner that signs in a user, stores user information as it is input for later use in other methods
| ~
| +Customer.class
| +Manifest.txt
| +ojdbc8.jar
| +project.class
| +README.txt - you read it :D
| +rnh222.jar - run the program with ```java -jar rnh222.jar```

##Interface Overview
Once you run the program you will be prompted to login to the Edgar SQL database. Afterwards you should see an ASCII menu appear allowing you to pick between running customer
commands or entering as Bank Management. The interface is complete for 5 of the 7 interface options described in the project outline. The two missing features are 
bank management and taking out a new loan, which I have replaced with fun little messages to bring the database to life with out current reality. All the data for this bank
was generated from Mockaroo. 

##Customer Menu Interface
The customer menu requests a user login which includes the user's ID and Social Securit Number. A full implemented user is Annalise Mucklow. She was used for testing throughout
the programming of the interface. If you want to see an overall view of how this program works, login with these credentials:
User ID: 36608     SSN: 310-01-9000

Once you enter the menu you do also have the option to create a new customer account! This randomly generates an ID and savings account based on your input credentials. 
(Note: current version of the interface does not create a checkings account and therefore new users cannot access features using a checkings account)

The menu once you have logged in prompts you with 9 options on what you would like to do with the account. Every menu option does not expose the user to any SQL and simply
works the user through the process they are trying to complete. Any wrong input sends the user back to the beginning of whichever menu they were at to reattempt inputs in 
the case they fail to query in the database. All my methods use simple queries with constraints to prevent improper querying rather than triggers or procedures. If I was
to continue with this project further, I would include more methods to be done on the SQL side to allow further modularizeability.

###Getters and Setters
setConnection() sets the id and password for the sql setConnection
setTab()/getTab() was an experimental setter and getter that was never used for menu traversal
setIdentifier() sets the current customer identifiers once they are logged in, so they can be accessed wherever needed in the class

###customerMenu()
Signs user in and sees if user needs to be registered. Otherwise sends the user to the customer update menu to allow for modifications to their account

###customerUpdate()
Presents a 9 option menu to send the user to the needed interface to modify their account

###savingsDeposit()
Allows the user to add money to a savings account by taking only the absolute value of what they are looking to deposit. Then the interface proceeds to create a generic
transaction of what was added after a sucessful deposit. It then returns the user back to customerUpdate.

###savingsWithdraw()
Allows the user to withdraw money from a savings account and ensuring the amount does not exceed the balance. Once that is sucessful, a generic transaction is created 
and the user is sent back to customerUpdate.

###checkingsWithdraw()
Works similar to savings withdraw but following a withdrawl checks if the balance is below a limit and incurs a $50 charge on the same account. This continues with every
withdrawl until the user deposits on the checkings account past the limit. Following, a generic transaction is saved for the amount and the user is returned to customerUpdate.

###payment()
Payment works to deal with loan and card payments. Both work under the same logic where a user's loan information or card information is shown and the user works through prompts
in order to complete their payment sucessfully. Based on what transaction went through a payment transaction is logged and on sucess the user is sent back to customerUpdate.

###newCard()
New cards require a checkings account for the user to link to the card. Once a credit or debit card is selected, the user is walked through the process of opening a new card.
On sucess, the user returns to customerUpdate.

###cardPurchase()
A card purchase begins with the user being shown which cards they can use to make the purchase. Based on that, the use chooses what card type they will use and is lead through
a set of steps to get information on the purchase information before enacting the purchase. On sucess, the debit card withdraws from the linked checkings account or the credit
card is credited further unless either process ends up with an overdraft. On sucess, the purchase is logged as a tranasction and the user is sent back to customerUpdate.
