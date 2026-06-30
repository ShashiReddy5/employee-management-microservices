# 👥 Employee Management Microservices

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

A scalable **Employee Management System** built using a microservices architecture with Spring Boot and Spring Cloud. Each domain is an independent service with its own database, communicating via REST APIs and an API Gateway.

---

## 🏗️ Microservices Architecture

```
                        ┌─────────────────┐
                                                │   API Gateway   │  :8080
                                                                        │ (Spring Cloud)  │
                                                                                                └────────┬────────┘
                                                                                                                                 │
                                                                                                                                           ┌──────────────────────┼──────────────────────┐
                                                                                                                                                     │                      │                      │
                                                                                                                                                       ┌───────▼───────┐    ┌─────────▼───────┐   ┌─────────▼───────┐
                                                                                                                                                         │  Employee     │    │  Department     │   │  Payroll        │
                                                                                                                                                           │  Service      │    │  Service        │   │  Service        │
                                                                                                                                                             │  :8081        │    │  :8082          │   │  :8083          │
                                                                                                                                                               └───────┬───────┘    └─────────┬───────┘   └─────────┬───────┘
                                                                                                                                                                         │                      │                      │
                                                                                                                                                                               MySQL DB              MySQL DB               MySQL DB
                                                                                                                                                                               ```
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## 🛠️ Tech Stack
                                                                                                                                                                               
                                                                                                                                                                               | Layer | Technology |
                                                                                                                                                                               |---|---|
                                                                                                                                                                               | Language | Java 17 |
                                                                                                                                                                               | Framework | Spring Boot 3.x |
                                                                                                                                                                               | Service Discovery | Spring Cloud Eureka |
                                                                                                                                                                               | API Gateway | Spring Cloud Gateway |
                                                                                                                                                                               | Database | MySQL (per service) |
                                                                                                                                                                               | ORM | Spring Data JPA / Hibernate |
                                                                                                                                                                               | Communication | REST (OpenFeign) |
                                                                                                                                                                               | Containerization | Docker & Docker Compose |
                                                                                                                                                                               | Cloud | AWS (EC2, RDS, ECS) |
                                                                                                                                                                               | Build Tool | Maven |
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## ✨ Features
                                                                                                                                                                               
                                                                                                                                                                               - ✅ Independent microservices with separate databases (Database per Service pattern)
                                                                                                                                                                               - ✅ Service Discovery with Eureka Server
                                                                                                                                                                               - ✅ Centralized routing via API Gateway
                                                                                                                                                                               - ✅ Inter-service communication using OpenFeign
                                                                                                                                                                               - ✅ Full CRUD operations for Employee, Department, and Payroll
                                                                                                                                                                               - ✅ Docker Compose for local multi-service orchestration
                                                                                                                                                                               - ✅ Global exception handling and validation
                                                                                                                                                                               - ✅ RESTful API design with proper HTTP status codes
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## 📡 API Endpoints
                                                                                                                                                                               
                                                                                                                                                                               ### Employee Service (`/api/employees`)
                                                                                                                                                                               
                                                                                                                                                                               | Method | Endpoint | Description |
                                                                                                                                                                               |---|---|---|
                                                                                                                                                                               | GET | `/api/employees` | Get all employees |
                                                                                                                                                                               | GET | `/api/employees/{id}` | Get employee by ID |
                                                                                                                                                                               | POST | `/api/employees` | Create new employee |
                                                                                                                                                                               | PUT | `/api/employees/{id}` | Update employee |
                                                                                                                                                                               | DELETE | `/api/employees/{id}` | Delete employee |
                                                                                                                                                                               
                                                                                                                                                                               ### Department Service (`/api/departments`)
                                                                                                                                                                               
                                                                                                                                                                               | Method | Endpoint | Description |
                                                                                                                                                                               |---|---|---|
                                                                                                                                                                               | GET | `/api/departments` | Get all departments |
                                                                                                                                                                               | GET | `/api/departments/{id}` | Get department by ID |
                                                                                                                                                                               | POST | `/api/departments` | Create new department |
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## 🏁 Getting Started
                                                                                                                                                                               
                                                                                                                                                                               ### Prerequisites
                                                                                                                                                                               
                                                                                                                                                                               - Java 17+
                                                                                                                                                                               - Maven 3.8+
                                                                                                                                                                               - Docker & Docker Compose
                                                                                                                                                                               - MySQL 8+
                                                                                                                                                                               
                                                                                                                                                                               ### Run with Docker Compose
                                                                                                                                                                               
                                                                                                                                                                               ```bash
                                                                                                                                                                               # Clone the repository
                                                                                                                                                                               git clone https://github.com/ShashiReddy5/employee-management-microservices.git
                                                                                                                                                                               cd employee-management-microservices
                                                                                                                                                                               
                                                                                                                                                                               # Start all services
                                                                                                                                                                               docker-compose up --build
                                                                                                                                                                               
                                                                                                                                                                               # Services will be available at:
                                                                                                                                                                               # API Gateway:        http://localhost:8080
                                                                                                                                                                               # Employee Service:   http://localhost:8081
                                                                                                                                                                               # Department Service: http://localhost:8082
                                                                                                                                                                               # Eureka Dashboard:   http://localhost:8761
                                                                                                                                                                               ```
                                                                                                                                                                               
                                                                                                                                                                               ### Run Locally
                                                                                                                                                                               
                                                                                                                                                                               ```bash
                                                                                                                                                                               # Start services in order:
                                                                                                                                                                               # 1. Eureka Server
                                                                                                                                                                               # 2. Employee Service
                                                                                                                                                                               # 3. Department Service
                                                                                                                                                                               # 4. API Gateway
                                                                                                                                                                               
                                                                                                                                                                               cd eureka-server && mvn spring-boot:run
                                                                                                                                                                               cd employee-service && mvn spring-boot:run
                                                                                                                                                                               cd department-service && mvn spring-boot:run
                                                                                                                                                                               cd api-gateway && mvn spring-boot:run
                                                                                                                                                                               ```
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## 📁 Project Structure
                                                                                                                                                                               
                                                                                                                                                                               ```
                                                                                                                                                                               employee-management-microservices/
                                                                                                                                                                               ├── eureka-server/              # Service Discovery
                                                                                                                                                                               ├── api-gateway/                # API Gateway (Spring Cloud Gateway)
                                                                                                                                                                               ├── employee-service/           # Employee CRUD microservice
                                                                                                                                                                               ├── department-service/         # Department CRUD microservice
                                                                                                                                                                               ├── payroll-service/            # Payroll management microservice
                                                                                                                                                                               ├── docker-compose.yml          # Multi-container orchestration
                                                                                                                                                                               └── README.md
                                                                                                                                                                               ```
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ## 👤 Author
                                                                                                                                                                               
                                                                                                                                                                               **Shashidhar Reddy**
                                                                                                                                                                               - GitHub: [@ShashiReddy5](https://github.com/ShashiReddy5)
                                                                                                                                                                               - LinkedIn: [linkedin.com/in/shashidhar-reddy](https://linkedin.com/in/shashidhar-reddy)
                                                                                                                                                                               
                                                                                                                                                                               ---
                                                                                                                                                                               
                                                                                                                                                                               ⭐ Star this repo if you find it helpful!
