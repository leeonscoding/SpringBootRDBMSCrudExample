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
Before running this application, you should create a database and modify it in the application.yaml file. In this application, I've used the PostgreSQL database.
```yaml
url: jdbc:postgresql://localhost/paste
username: root
password: root
```
If you don't have PostgreSQL installed in your machine but docker, you can spin up a database using this command.
```bash
docker run --name local-pg-1 \
	--network pg_network1 \
	-p 5432:5432 \
	-e POSTGRES_USER=root \
	-e POSTGRES_PASSWORD=root \
	-d postgres
```

You can run the main() method in the CrudExampleApplication.java class.
Or you can use the gradle. The command is
```bash
./gradlew bootRun
```
