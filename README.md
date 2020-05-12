Required Softwares :
- JDK 1.8
- Maven 3.x

Installation and Getting Started
Steps for running the application
- Check out the source from git hub
- Run the command "mvn spring-boot:run"(start spring boot application)

The application reads incoming(localhost:8080/incoming) JSON data using a POST method and performs the following operations
-	Select the largest number from the array numbersMeetNumbers
-	Find any duplicates in the string findDuplicates
-	Remove whitespaces from whiteSpacesGalore without using replace()
-   Saves the incoming request JSON data to Mongodb as IncomingJsonData
-   Saves the processed output of JSON to Mongodb as OutGoingJsonData

Note : The application has been developed using Spring boot(api) with the intention of saving the output from the above values to the Mongodb
Pending items : 
- Validation of data types in the incoming JSON object
- Test cases for mongodb save operations
- Negitive scenario based unit test for the Service layer

Additional :
Run "mvn install" to run all the testcases and package the application as a spring boot jar to be deployed.
