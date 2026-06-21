# AI-Powered Distributed E-Commerce Platform
> **Repository Folder:** `Microservice E-commerce`

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring AI & MCP](https://img.shields.io/badge/Spring_AI_%26_MCP-%235A45FF.svg?style=for-the-badge&logo=probot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Netflix Eureka](https://img.shields.io/badge/Netflix_Eureka-%23E50914.svg?style=for-the-badge&logo=netflix&logoColor=white)

## 🛠️ Tech Stack

### 🟦 **Core Frameworks & AI Integration**
* **Java (JDK 21)** – Core programming language maximizing modern language features.
* **Spring Boot 4.07** – Underlying framework for building robust, production-ready microservices.
* **Spring AI** – Framework used to build the **Model Context Protocol (MCP) server**, orchestrating LLMs for tool-calling and parameter extraction.

---

### 🟩 **Microservices Architecture & Cloud-Native Routing**
* **Spring Cloud Gateway** – Centralized API gateway acting as a reverse proxy for intelligent routing, security, and rate limiting.
* **Spring Cloud Netflix Eureka** – Service Registry for dynamic service discovery, completely eliminating hardcoded endpoints.
* **Spring Cloud Config** – Centralized, externalized configuration management across distributed environments.
* **Declarative HTTP Clients** – Integrated **Spring RestClient** and **HttpExchange** annotations for clean, type-safe, synchronous inter-service communication.

---

### 🟨 **Polyglot Storage & Data Layer**
* **PostgreSQL** – Relational database handling transactions requiring strict **ACID compliance** (Orders, Inventory).
* **MongoDB** – NoSQL document database used for the user profile layer to leverage schema flexibility and high-throughput reads/writes.
* **Spring Data JPA / Spring Data MongoDB** – Data access abstractions for seamless repository management.

---

### 🟥 **DevOps, Containerization & Telemetry**
* **Docker & Docker Compose** – Containerization of individual microservices and database instances to ensure rapid, immutable environment orchestration.
* **Spring Boot Actuator** – Production-ready features to expose real-time application health metrics, telemetry, and system info.

DevOps, Containerization & Telemetry
Docker & Docker Compose – Containerization of individual microservices and database instances to ensure rapid, immutable environment orchestration.

Spring Boot Actuator – Production-ready features to expose real-time application health metrics, telemetry, and system info.
