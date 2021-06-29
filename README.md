# Opera-app
 The goal of this project is to create a simple interaction service for the user to purchase a ticket for an opera session. 
 The user has the ability to access the available session, buy a ticket, create an order, register, login.

## Implementation details and technologies
Project based on 3-layer architecture:
- Presentation layer (controllers)
- Application layer (services)
- Data access layer (DAO)

## Person without role can:
* register
* view all available sessions
* view all performances
* view all stages

## Admin can:
* view a list of all performances
* find user by email
* add new performance
* add new stage
* add new performance session, delete or update

## User can:
* process the order
* view a history of all the orders
* add the ticket for movie to the shopping cart
* view all the tickets in the shopping cart

### Technologies
* Apache Tomcat - version 9.0.46
* MySQL - version 8.0.25
* Spring Core/Web/MVC/Rest
* Hibernate
* Json

## Setup
1. Configure Tomcat (Local) with : Deployment - war_exploded, context address - "/"
2. Install MySQL and MySQL Workbench
3. File src/main/resources/db.properties is to be configured:
   - db.driver=YOUR_DRIVER
   - db.url=YOUR_URL
   - db.username=YOUR_USERNAME
   - db.password=YOUR_PASSWORD   
4. Start the application
5. Admin and User will be added to your database when program start. You can log in as: Admin: (name: "admine@gmail.com", password:"qwerty12"), or User: (name: "user@domain.com", password:"qwerty")
