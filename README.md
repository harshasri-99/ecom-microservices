# Ecommerce Application using Microservices

This E-commerce application consists of different microservices : User, Product and Order Microservices.
User-sevice manages user realted CRUD operations like creating new user, get list of all users, get user details with id, delete user, update user details. Similarly Product-service also manages CRUD operations for products details like creating product, updating product quantity. 
Using Order-service we can place order, get order details. It interacts with User and Product microservice through Feign client using REST APIs.

Each microservice uses RESTful webservices - 
Spring boot for developing the application, worked with Spring JPA and H2 database for storing and accessing the data, Swagger documantation, Exception handling, Validation, static and dynamic Filtering, monitoring using Actuator.

Spring Cloud features for developing and accessing microservices -
Eureka as service registry where all the microservices register themselves so that other microservies can assess their services, Feign client for writing easier Rest Apis, spring config server for configuration management using git, Load balancer for dynamic scaling among different instances of each microservice, API gateway for routing the url and Fault tolerence and circuit breaker using Resilience4j.
Docker is used to containerize microservices by building images and container which makes deployment of microservices easy, docker-compose to ensure all microservices are up and running. Implemented additional features like Zipkin and RabbitMQ for asynchronous distributed tracing using their docker images.

![Screenshot (9)](https://user-images.githubusercontent.com/114099189/200158345-4a9f1c5e-a44f-423f-b46e-7dfc730dd8d6.png)

### Application Urls:
```
user-service : http://localhost:7000/users
product-service : http://localhost:7200/products
order-service : http://localhost:7100/orders
naming-server : http://localhost:8761/
place order url : http://localhost:8765/orders/10001/14323/4, http://localhost:7100/orders/10001/14325/2
```

