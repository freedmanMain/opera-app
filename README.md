# Opera-app
 The goal of this project is to create a simple interaction service for the user to purchase a ticket for an opera session. 
 The user has the ability to access the available session, buy a ticket, create an order, register, login.

## Implementation details and technologies
Project based on 3-layer architecture:
- Presentation layer (controllers)
- Application layer (services)
- Data access layer (DAO)
Password hashing is implemented.

### Technologies
* Apache Tomcat - version 9.0.46
* MySQL - version 8.0.25
* Spring Core/Web/MVC
* Hibernate
* Json

## Setup
1. Configure Apache Tomcat 
2. Install MySQL and MySQL Workbench
3. File src/main/resources/db.properties is to be configured:
- db.driver=YOUR_DRIVER
- db.url=YOUR_URL
- db.username=YOUR_USERNAME
- db.password=YOUR_PASSWORD   
4. Start the application
