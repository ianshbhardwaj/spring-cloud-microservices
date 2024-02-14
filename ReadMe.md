Create a new maven project in intellij.

File -> New -> Project -> (Select New Project) and choose maven build system.

Part 1: Setting Up Eureka Service

Create a EurekaService Module that will act as a service registry for your microservices.

Create Eureka Service Project:
Right click on project  New -> Module.
Choose Spring Initializr and set the Project SDK to your JDK version. (Choose Java as language and Maven as type)
Click Next, enter EurekaService as the project name, and choose a suitable location for your project.
Click Next, and from the dependencies section, choose:
Spring Boot Actuator
Spring Cloud Eureka Server
Click Finish to create the project.
Configure application.properties:
Navigate to src/main/resources/application.properties.
Add the following properties:
server.port=8761

eureka.client.register-with-eureka=false

eureka.client.fetch-registry=false



Run EurekaService:
Create eureka server by using
@EnableEurekaServer in EurekaServiceApplication Class

Right-click on the project and choose Run 'EurekaService'.
Ensure the service is up and running on http://localhost:8761.








Part 2: Setting Up Movie Service Module

Create a MovieService module that will register with Eureka and provide movie-related operations.

Create Movie Service Project:
Follow the same steps as in Part 1 to create a new project named MovieService.
Choose the following dependencies:
Spring Boot Actuator
Spring Data JPA
Spring Web
Spring Cloud Eureka Client
H2 Database
Lombok
Eureka discovery Client
Spring Boot DevTools


Configure application.properties:
Navigate to src/main/resources/application.properties.
Add the following properties:


server.port=0
spring.application.name=movie-service
info.app.name="movie-service"
info.app.description="Movie Service Application"
info.app.version="1.0.0"
eureka.instance.prefer-ip-address=true
eureka.client.fetch-registry=true
eureka.client.register-with-eureka=true
eureka.client.region=default
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.instance-id=movie-service:${spring.application.instance_id:${random.value}}
eureka.client.registry-fetch-interval-seconds=5
management.endpoints.web.exposure.include=info,health ,shutdown
management.endpoint.shutdown.enabled=true
management.info.env.enabled=true



Create Movie Model and Repository:
Create a new Java class Movie in the model package and annotate it with @Entity.
Define properties for the Movie entity (like id, title, etc.) and annotate them with JPA annotations.
Create an interface MovieRepository in the repository package.
Annotate MovieRepository with @RepositoryRestResource and extend JpaRepository.
Create Seeder to Populate Movies:
Create a new class DbSeeder and use it to populate the MovieRepository with some initial movies.
Run MovieService:
Right-click on the project and choose Run 'MovieService'.
Ensure it registers with Eureka and is accessible.
Add a rest endpoint (controller) to fetch movies.


Part 3: Setting Up User Service Module

Create a UserService module that will register with Eureka and consume MovieService to fetch movies

Create User Service Project:
Follow the same steps as in Part 1 to create a new project named UserService.
Choose the following dependencies:
Spring Boot Actuator
Spring Web
Spring Cloud Eureka Client
OpenFeign
Spring Boot DevTools
Configure application.properties similar to MovieService.
Implement Fetching movie functionality using OpenFeign
Create Feign client to communicate with MovieService.
Configure Feign client by adding @EnableFeignClients to the application
Implement endpoints to fetch all movies
Implement a rest service to fetch all movies (just to test that the feign client is working. In reality this is unnecessary.)
Run ReviewService:
Right-click on the project and choose Run UserService.
Ensure it registers with Eureka and is accessible.
Testing Services:
Use a REST client like Postman or use your browser to interact with your services.
Ensure MovieService and ReviewService are communicating properly and Eureka dashboard shows all services.