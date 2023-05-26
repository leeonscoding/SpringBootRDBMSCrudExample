# Building a CRUD application using Spring boot

This is a simple Spring boot application. Here is the rest API deign.

|URL|VERB|Description|
|---|---|--- |
|/pastes|POST|Create a paste
|/pastes?start=0&size=10|GET|Get the first set of Pastes
|/pastes/7|GET|Get a specific paste
|/pastes/7|PUT|Update a specific paste
|/pastes/7|DELETE|Delete a specific paste

### Technologies
* Java 17
* Spring boot 3.1.0
* PostgreSQL database

### Dependencies
* Spring web
* Spring Data JPA
* Postgresql Driver
* Lombook
* Jakarta bean validator

*I've added the postman exported file for testing. It's name is CRUD_example_postman_collection.json. You can locate it in the root.*

### How to run
You can run the main() method in the CrudExampleApplication.java class.
Or you can use the gradle. The command is
```bash
./gradlew bootRun
```
