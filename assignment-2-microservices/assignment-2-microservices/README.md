# School Management System Microservices MVP

Java Spring Boot microservices demo with separate Student and Course services and a simple Spring Cloud Gateway. Designed for a university assignment using Spring Boot 3.3.x and Java 17.

## Folder Structure
```
assignment-2-microservices/
  student-service/
  course-service/
  api-gateway/
  README.md
```

## Prerequisites
- JDK 17
- Maven
- VS Code or IntelliJ IDEA
- Postman
- Git
- Chrome or Edge

## How to Run
Open three terminals and start each service:

**Student service**
```
cd student-service
mvn spring-boot:run
```

**Course service**
```
cd course-service
mvn spring-boot:run
```

**API gateway**
```
cd api-gateway
mvn spring-boot:run
```

## URLs to Test
- Direct: `http://localhost:8081/students`, `http://localhost:8082/courses`
- Swagger: `http://localhost:8081/swagger-ui.html`, `http://localhost:8082/swagger-ui.html`
- Gateway: `http://localhost:8080/student-service/students`, `http://localhost:8080/course-service/courses`

## Example JSON (POST)
**Student**
```json
{
  "name": "John Silva",
  "email": "john@gmail.com"
}
```

**Course**
```json
{
  "courseName": "Microservices",
  "lecturer": "Dr Perera"
}
```

## Notes for Slide Deck Screenshots
- Run each service and capture Swagger UI pages for both microservices.
- Show H2 console (`/h2-console`) if you want to illustrate the in-memory DB.
- Demonstrate both direct URLs and gateway URLs to prove routing works on a single public port (8080).
- Include a simple Postman screenshot showing a POST then GET for each service.
