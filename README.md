# Message Board

This is the backend component of the Message Board Application. The frontend portion can be found [here](https://github.com/wanderpgomes/message-board-ui).

### SetUp 

1. Clone git repository: `git clone https://github.com/wanderpgomes/message-board.git`
2. Create database main schema: `CREATE SCHEMA 'messageborad'`
3. Create database test schema: `CREATE SCHEMA 'messageborad_test'`
4. Run `create-tables.sql` and `seed-users.sql` on both schemas.
5. Run the maven build: `mvn clean install`
  

### Running the Application

Run Spring Boot application with Maven: `mvn spring-boot:run`

### Running Tests

1. The `mvn clean install` will run all Unit and Integration Tests.
2. To verify if the application is actually running:
* `curl -X GET --header 'Accept: text/plain' 'https://localhost:8443/ping'`

### Rest Api Documentation

Swagger documentation for the REST Api can be found at: [https://localhost:8443/swagger-ui.html](https://localhost:8443/swagger-ui.html)

### Continuous Integration

Jenkins job for this project is at: [http://localhost:8080/job/message-board/](http://localhost:8080/job/message-board/)

### Release Notes

* **1.0** Project Genesis

