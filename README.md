# Banking App

![Banking App](https://via.placeholder.com/800x200?text=Banking+App)

**Banking App** is a comprehensive banking application that allows users to manage accounts, transfer funds, and perform user authentication. It is built with Spring Boot and related technologies.

---

## 📑 Table of Contents
- [Technologies Used](#-technologies-used)
- [Setup Instructions](#-setup-instructions)
- [REST API Details](#-rest-api-details)
- [Project Structure](#-project-structure)
- [Runtime Environment](#-runtime-environment)

---

## 🚀 Technologies Used

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green?style=flat-square&logo=springboot)  
![H2 Database](https://img.shields.io/badge/H2%20Database-InMemory-blue?style=flat-square&logo=h2)  
![Maven](https://img.shields.io/badge/Maven-Build-red?style=flat-square&logo=apachemaven)  
![Spring Security](https://img.shields.io/badge/Spring%20Security-Security-brightgreen?style=flat-square&logo=springsecurity)  

---

## 🛠️ Setup Instructions

### 1. Prerequisites
- Ensure you have **Java 17** installed.
- Maven should be installed.

### 2. Running the Project
```bash
# Clone the repository
git clone https://github.com/your-repo/bankingapp.git

# Navigate to the project directory
cd bankingapp

# Install dependencies
mvn clean install

# Run the application
mvn spring-boot:run

### 3. Default Application URL
The application runs at:  
**`http://localhost:8080`**

---

## 🌐 REST API Details

### 1. User Management

#### 1.1 Register User
- **URL**: `/users/register`
- **HTTP Method**: `POST`
- **Request Body**:
    ```json
    {
      "username": "john_doe",
      "password": "password123"
    }
    ```
- **Response**:
    ```json
    {
      "id": "UUID",
      "username": "john_doe",
      "createdAt": "2024-11-26T10:00:00",
      "updatedAt": "2024-11-26T10:00:00"
    }
    ```

#### 1.2 Login
- **URL**: `/users/login`
- **HTTP Method**: `POST`
- **Request Body**:
    ```json
    {
      "username": "john_doe",
      "password": "password123"
    }
    ```
- **Response**:
  - **Successful login**: `true`  
  - **Failed login**: `false`

---

### 2. Account Management

#### 2.1 Create Account
- **URL**: `/accounts`
- **HTTP Method**: `POST`
- **Request Body**:
    ```json
    {
      "name": "John's Savings",
      "balance": 1000.0
    }
    ```
- **Response**:
    ```json
    {
      "id": "UUID",
      "name": "John's Savings",
      "balance": 1000.0
    }
    ```

#### 2.2 Get Account Details
- **URL**: `/accounts/{id}`
- **HTTP Method**: `GET`
- **Response**:
    ```json
    {
      "id": "UUID",
      "name": "John's Savings",
      "balance": 1000.0
    }
    ```

---

### 3. Transactions

#### 3.1 Transfer Funds
- **URL**: `/transactions/transfer`
- **HTTP Method**: `POST`
- **Request Body**:
    ```json
    {
      "fromAccountId": "UUID",
      "toAccountId": "UUID",
      "amount": 100.0
    }
    ```
- **Response**:
    ```json
    {
      "id": "UUID",
      "fromAccountId": "UUID",
      "toAccountId": "UUID",
      "amount": 100.0,
      "transactionDate": "2024-11-26T10:00:00",
      "status": "SUCCESS"
    }
    ```

#### 3.2 Transaction History
- **URL**: `/transactions/history/{accountId}`
- **HTTP Method**: `GET`
- **Response**:
    ```json
    [
      {
        "id": "UUID",
        "fromAccountId": "UUID",
        "toAccountId": "UUID",
        "amount": 100.0,
        "transactionDate": "2024-11-26T10:00:00",
        "status": "SUCCESS"
      }
    ]
    ```

---

## 📂 Project Structure
src/main/java/com/example/bankingapp/ ├── model/ # Database models (Account, Transaction, User) ├── repository/ # JPA Repositories ├── service/ # Business logic layer │ ├── impl/ # Service implementations │ └── interfaces/ # Service interfaces ├── controller/ # REST controllers ├── config/ # Application configurations
   
## 🌍 Runtime Environment
- **Java Version**: 17
- **Default Port**: 8080
- **Database**: H2 (default, in-memory)
- **Security**: Spring Security
- **Password Encryption**: BCryptPasswordEncoder

---
