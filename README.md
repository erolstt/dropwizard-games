# A Dropwizard example
An example Dropwizard application to demonstrate how to use Dropwizard using JDBI to interact with postgresql (or any db).

How to start the application
---
Before start the application, you need to create database.

Creating Database
-

To setup the postgresql database, run the following:

```docker run -p 5432:5432 -e POSTGRES_PASSWORD=password postgres```

then create the database by running:

```java -jar target/dropwizard-games-1.0.0.jar db migrate teams-local-conf.yml```

Now you can start the application.

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-games-1.0.0.jar server teams-local-conf.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Deploy with Docker Compose
---
To run application with docker compose, run following in the root directory where docker-compose.yml file exists

`docker-compose up`

To stop and remove the the containers run following

`docker-compose down` 