# 🚀 Jobs Posting App Backend

A backend service for managing job postings, built using Spring Boot. This application provides APIs to create, update, delete, and retrieve job listings.

---

## 📌 Features

* Create job postings
* Update job details
* Delete jobs
* Fetch all jobs / specific job
* RESTful API design

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Docker

---

## ▶️ How to Run

### 🔹 1. Clone the repository

```bash
git clone <your-repo-url>
cd <project-folder>
```

---

### 🔹 2. Build the application

```bash
mvn clean package
```

---

### 🔹 3. Run the application

```bash
java -jar target/<your-jar-name>.jar
```

---

## 🧾 Requirements

Make sure you have installed:

* Java 17+
* Maven
* Docker (optional, for containerized setup)
* MySQL (if not using Docker)

---

## 🗄️ Database Setup

### 🔹 Option 1: Using MySQL locally

1. Create database:

```sql
CREATE DATABASE jobhood;
```

2. Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobhood
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

### 🔹 Option 2: Using Docker (Recommended)

Run MySQL container:

```bash
docker run -d \
  --name my_mysql_app \
  -e MYSQL_ROOT_PASSWORD=your_password \
  -e MYSQL_DATABASE=jobhood \
  -p 3306:3306 \
  mysql:8.0
```

Update Spring Boot config:

```properties
spring.datasource.url=jdbc:mysql://my_mysql_app:3306/jobhood
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## 🐳 Run with Docker (App)

```bash
docker build -t jobs-app .
docker run -d -p 8080:8080 --name jobs_app jobs-app
```

---

## 🌐 API Base URL

```text
http://localhost:8080
```

---

## 🎯 Purpose

This project is built to:

* Practice backend development with Spring Boot
* Learn Docker containerization
* Understand database integration

---

## 👨‍💻 Author

Suyog Mahajan
