
This microservice contains some APIs to create, get and delete skole info-- Task.

#Prerequisites
Before you begin, ensure you have the following installed:

1. Java Development Kit (JDK): Download and Install JDK
2. Gradle: Download and Install Maven

#Backend Setup

####Build and run the Spring Boot application:
1. ./gradlew build - for building the backend application
2. ./gradlew bootRun - to run the application or to start the server from terminal or
3. run the class in which main method exist which is Application.java.

By default the server will be up and running on port 8080.

##Accessing the application or Usage 

1. When the server is started, access the endpoint for :
    POST
    GET
    DELETE
   
2. Root url for the api is : http://localhost:8080/api/school
3. To POST or create the end point is http://localhost:8080/api/school/create and required body should be passed.
   And the information is validated against an external API and store in Databas.
4. There is a GET endpoint that can filter on the postal code and/or passive field
   url: http://localhost:8080/api/school/{postNummer}/{passiv}
5. There is a GET endpoint that can get the releationship data for school owner by calling an external API 
   url: http://localhost:8080/api/school/relasjonsdata.
6. And a DELETE end point which deletes the school info from local in memory database on organistaion number.



