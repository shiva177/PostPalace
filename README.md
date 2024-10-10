# Blog Project Backend
Postpalace Project Spring Boot REST API's

## Tools and Technologies

### Technologies:
- Java 8+
- Spring Boot
- Spring MVC
- Spring Data JPA ( Hibernate)
- Spring Security
- JWT
- Tomcat

### IDE:
- Intellij IDEA

### Database:

- MySQL database

### Tools:
 
- Swagger - API documentation
- Postman - Test REST API
- Maven - Build Tool

### Deployment on Production:
- AWS

## To do
MySql  -->  create database myblog;

## What is inside
- REST API's Design for Blog Application
- Building CRUD REST API's for Post Resource
- Pagination and Sorting Support
- Building CRUD REST API's for Comment Resource
- Using ModelMapper-Map Entity to DTO and Vice Versa
- Exception Handling in Spring Boot App
- Spring Boot REST API Validation
- Securing REST API's
- Log in / Sign in and Register / Sign up REST API's
- JWT ( Json Web Tokens) - Securing REST API's with JWT
- Versioning REST API's
- Swagger REST API Documentation
- Deploying Spring Boot Blog App on AWS Cloud

## Entity relations in database
###### one to many
 ![](https://github.com/gltnlkl/BlogProject/blob/master/src/main/java/com/gulukal/blogspringtrestapi/utils/image/one%20to%20many%20bi-direct..jpg)
 
###### many to many
 ![](https://github.com/gltnlkl/BlogProject/blob/master/src/main/java/com/gulukal/blogspringtrestapi/utils/image/many%20to%20many.jpg)
 
## The ways to versioning Blog App REST APIs

1. Versioning through URI Path
- One way to version a REST API is to include the version number in the URI path.
#### Examples:
- http://www.example.com/api/1/products 
- http://www.example.com/api/v1/products

2. Versioning through query parameters
- Another option for versioning a REST API is to include the version number as a query parameter.
#### Examples:
- http://www.example.com/api/products?version=1 
- http://www.example.com/api/products?version=2

3. Versioning through custom headers
- REST APIs can also be versioned by providing custom headers with the version number included as an attribute.
- The main difference between this approach and the two previous ones is that it doesn’t clutter the URI with versioning information.
#### Examples:
- http://localhost:8080/api/products headers=[X-API-VERSION=1]
- http://localhost:8080/api/products headers=[X-API-VERSION=2]
##### Pros: It doesn’t clutter the URI with versioning information
##### Cons: It requires custom headers

4. Versioning through content negotiation
- The last strategy we are addressing is versioning through content negotiation.
- In this approach, we use the Accept header in the request.
#### Examples:
- http://localhost:8080/api/products headers[Accept=application/vnd.javaguides-v1+json] 
- http://localhost:8080/api/products headers[Accept=application/vnd.javaguides-v2+json]

## REST Documentation with Swagger
### Why the Swagger is used for
Swagger is used for answer those questions between REST API Developer and REST API Consumer
- What are rest endpoints available
- What is response codes
- What is dto structure
- What are error codes
- What are HTTP methods
- What are standart error messages
