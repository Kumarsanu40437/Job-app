# Job Application Management System

## Overview
This is a **Spring Boot-based** Job Application Management System that allows users to add, view, and manage job listings. The project uses **JWT for authentication** and **Redis for caching** to enhance performance.

## Features
- **Job Posting & Retrieval**: Users can add new job listings and view all jobs.
- **JWT Authentication**: Secure login and access control using JSON Web Tokens.
- **Redis Caching**: Improves performance by caching job listings.
- **Spring Boot & MVC Architecture**: Ensures scalability and clean separation of concerns.
- **Embedded Tomcat Server**: Runs the application as a standalone web service.

## Technologies Used
- **Spring Boot** - Backend framework
- **Spring Security** - JWT authentication
- **Redis** - Caching layer
- **H2 Database / MySQL** - Data persistence
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management
- **Thymeleaf** - View rendering (optional if using frontend framework)

## Installation and Setup
### Prerequisites
- Java 21 or later
- Maven
- Redis (installed and running)
- MySQL (if using a persistent database)

### Steps to Run
1. **Clone the repository**
   ```sh
   git clone https://github.com/your-username/jobapp.git
   cd jobapp
   ```

2. **Configure application.properties**
   Modify `src/main/resources/application.properties` for database and Redis settings.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/jobapp_db
   spring.datasource.username=root
   spring.datasource.password=root
   spring.redis.host=localhost
   spring.redis.port=6379
   jwt.secret=your-secret-key
   ```

3. **Run the application**
   ```sh
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:9090`

## API Endpoints
### Authentication
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/auth/login` | User login, returns JWT token |
| POST | `/auth/register` | New user registration |

### Job Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/jobs` | Get all jobs (cached with Redis) |
| POST | `/jobs/add` | Add a new job (requires authentication) |

## Project Structure
```
Jobapp
│── src
│   ├── main
│   │   ├── java/com/sanu/Jobapp
│   │   │   ├── controller/JobController.java
│   │   │   ├── service/JobService.java
│   │   │   ├── repo/JobRepo.java
│   │   │   ├── model/JobPost.java
│   │   │   ├── security/JwtUtil.java
│   │   ├── resources
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   ├── application.properties
│── pom.xml
```

## How JWT Works in This Project
1. **User logs in** and receives a JWT token.
2. **JWT is sent** in the Authorization header with each request.
3. **Spring Security validates** the JWT before allowing access.

## How Redis is Used
- **Job listings are cached** in Redis for faster access.
- **When a new job is added**, cache is updated automatically.

## Contributing
1. Fork the repo
2. Create a new branch (`feature-xyz`)
3. Commit your changes
4. Push the branch and create a PR

## License
This project is licensed under the MIT License.

---
### Author :Kumar Sanu
[GitHub Profile](https://github.com/Kumarsanu40437)

