Mini Banking App
Mini Banking App is a comprehensive banking application that allows users to manage accounts, transfer funds, and perform user authentication. It is built with Spring Boot and related technologies.

📑 Table of Contents
Technologies Used 
Setup Instructions
REST API Details
Project Structure
Runtime Environment

🚀 Technologies Used
Java 17: Programming language for application development.
Spring Boot 3: Core framework of the application.
Spring Security: For authentication and authorization.
H2 Database: Lightweight and fast database solution.
Spring Data JPA: ORM tool for database operations.
PasswordEncoder: For password encryption.
Lombok: Simplifies boilerplate code.
Maven: Project and dependency management.

🛠️ Setup Instructions
1. Prerequisites
Ensure you have Java 17 installed.
Maven should be installed.
2. Running the Project
Clone the repository:
bash
Copy code
git clone https://github.com/your-repo/bankingapp.git
Navigate to the project directory:
bash
Copy code
cd bankingapp
Install dependencies:
bash
Copy code
mvn clean install
Run the application:
bash
Copy code
mvn spring-boot:run
3. Default Application URL
The application runs at http://localhost:8080 by default.

🌐 REST API Details
1. User Management
1.1 Register User
URL: /users/register
HTTP Method: POST
Request Body:
json
Copy code
{
  "username": "john_doe",
  "password": "password123"
}
Response:
json
Copy code
{
  "id": "UUID",
  "username": "john_doe",
  "createdAt": "2024-11-26T10:00:00",
  "updatedAt": "2024-11-26T10:00:00"
}
1.2 Login
URL: /users/login
HTTP Method: POST
Request Body:
json
Copy code
{
  "username": "john_doe",
  "password": "password123"
}
Response:
Successful login: true
Failed login: false
2. Account Management
2.1 Create Account
URL: /accounts
HTTP Method: POST
Request Body:
json
Copy code
{
  "name": "John's Savings",
  "balance": 1000.0
}
Response:
json
Copy code
{
  "id": "UUID",
  "name": "John's Savings",
  "balance": 1000.0
}
2.2 Get Account Details
URL: /accounts/{id}
HTTP Method: GET
Response:
json
Copy code
{
  "id": "UUID",
  "name": "John's Savings",
  "balance": 1000.0
}
3. Transactions
3.1 Transfer Funds
URL: /transactions/transfer
HTTP Method: POST
Request Body:
json
Copy code
{
  "fromAccountId": "UUID",
  "toAccountId": "UUID",
  "amount": 100.0
}
Response:
json
Copy code
{
  "id": "UUID",
  "fromAccountId": "UUID",
  "toAccountId": "UUID",
  "amount": 100.0,
  "transactionDate": "2024-11-26T10:00:00",
  "status": "SUCCESS"
}
3.2 Transaction History
URL: /transactions/history/{accountId}
HTTP Method: GET
Response:
json
Copy code
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

📂 Project Structure
bash
Copy code
src/main/java/com/example/bankingapp/
    ├── model/          # Database models (Account, Transaction, User)
    ├── repository/     # JPA Repositories
    ├── service/        # Business logic layer
    │   ├── impl/       # Service implementations
    │   └── interfaces/ # Service interfaces
    ├── controller/     # REST controllers
    ├── config/         # Application configurations
   
🌍 Runtime Environment
Java Version: 17
Default Port: 8080
Database: H2 (default, in-memory)
Security: Spring Security
Password Encryption: BCryptPasswordEncoder
