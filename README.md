# Employee Management Microservices

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

A scalable **Employee Management System** built using a microservices architecture with Spring Boot and Spring Cloud. Each domain is an independent service with its own database, communicating via REST APIs and an API Gateway.

---

## Architecture Overview

```
API Gateway (port 8080)
    |
    |-- Employee Service   (port 8081) --> MySQL DB
    |-- Department Service (port 8082) --> MySQL DB
    |-- Payroll Service    (port 8083) --> MySQL DB

Eureka Server (port 8761) - Service Discovery
```

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| Service Discovery | Spring Cloud Eureka |
| API Gateway | Spring Cloud Gateway |
| Database | MySQL (per service) |
| ORM | Spring Data JPA / Hibernate |
| Communication | REST (OpenFeign) |
| Containerization | Docker and Docker Compose |
| Cloud | AWS (EC2, RDS, ECS) |
| Build Tool | Maven |

---

## Features

- Autonomous microservices with separate databases (Database-per-Service pattern)
- - Service discovery and registration via Eureka Server
  - - Centralized routing via Spring Cloud API Gateway
    - - Inter-service communication using OpenFeign REST clients
      - - Full CRUD operations for Employee, Department, and Payroll domains
        - - Docker Compose for seamless local multi-service orchestration
          - - Global exception handling and bean validation
            - - RESTful API design following HTTP standards
             
              - ---

              ## API Endpoints

              ### Employee Service `/api/employees`

              | Method | Endpoint | Description |
              |---|---|---|
              | GET | /api/employees | Get all employees |
              | GET | /api/employees/{id} | Get employee by ID |
              | POST | /api/employees | Create new employee |
              | PUT | /api/employees/{id} | Update employee |
              | DELETE | /api/employees/{id} | Delete employee |

              ### Department Service `/api/departments`

              | Method | Endpoint | Description |
              |---|---|---|
              | GET | /api/departments | Get all departments |
              | GET | /api/departments/{id} | Get department by ID |
              | POST | /api/departments | Create department |

              ---

              ## Getting Started

              ### Prerequisites

              - Java 17+
              - - Maven 3.8+
                - - Docker and Docker Compose
                  - - MySQL 8+
                   
                    - ### Run with Docker Compose
                   
                    - ```bash
                      git clone https://github.com/ShashiReddy5/employee-management-microservices.git
                      cd employee-management-microservices
                      docker-compose up --build
                      ```

                      Services available at:
                      - API Gateway: http://localhost:8080
                      - - Employee Service: http://localhost:8081
                        - - Department Service: http://localhost:8082
                          - - Eureka Dashboard: http://localhost:8761
                           
                            - ---

                            ## Project Structure

                            ```
                            employee-management-microservices/
                            ├── eureka-server/
                            ├── api-gateway/
                            ├── employee-service/
                            ├── department-service/
                            ├── payroll-service/
                            ├── docker-compose.yml
                            └── README.md
                            ```

                            ---

                            ## Author

                            **Shashidhar Reddy**
                            - GitHub: [@ShashiReddy5](https://github.com/ShashiReddy5)
                            - - LinkedIn: [linkedin.com/in/shashidharreddy-java](https://www.linkedin.com/in/shashidharreddy-java/)
