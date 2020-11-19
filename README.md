# Simple_CRUD_Api
This is Simple REST api for performing CRUD operation and some basic validation.
# Requirements :
  1. Intellij IDEA or any IDE
  2. JDK
  3. Mysql database server
  4. Postman or SOUP UI
# Steps to setup :
  1. Create mysql database with name “userdb”.
  2. Start the mysql server.
  3. Change mysql username and password as per your installation
    a. Open src/main/resources/application.properties
    b. Change spring.datasource.username and spring.datasource.password
  4. Build and run app using maven
        mvn spring-boot:run
  5. The app will start running at http:localhost:8080
  6. Open the postman app and explore the following rest apis
 
    a. Method – Post
        URL- http://localhost:8080/newuser
        Body- {
        “name”:”xyz”,
        “username”:”xyz”,
        “password”:”12345678”
        “age”:10
        }
    
    b. Method – Get
        URL- http://localhost:8080/allusers
    
    c. Method – Put
        URL- http://localhost:8080/updateuser/1
        Body-{
        “name”:”pqr”,
        “username”:”xyz”,
        “password”:”12345678”
        “age”:12
        }
    
    d. Method – Delete
        URL – http://locahost:8080/deleteuser/1
