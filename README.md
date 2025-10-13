Ironclad Secure Vault Management System

📌 Project Overview

Ironclad Vault Management System is a secure, encrypted file storage and management application built using Spring Boot and Java.
The system allows users to upload, download, delete, and search files, with role-based access and audit logging for security and transparency.

Purpose
The primary goal is to create a centralized, secure vault system for storing sensitive files.
It ensures:
Data Security and Privacy: Encrypts files using AES-256 and stores user credentials securely with BCrypt hashing.
Controlled Access: Role-based access control ensures only authorized personnel can view, download, or delete files.
Accountability and Auditability: Maintains detailed audit logs of every file operation for transparency and traceability.
Ease of Use: Provides a simple interface for performing file operations with minimal technical complexity.
Ironclad Vault Management System is ideal for organizations, institutions, and individuals handling confidential documents like financial records, legal contracts, certificates, and personal data.
It exists in the real world as a solution for:
Secure storage of sensitive digital assets
Controlled access to confidential files
Transparent operational audit trails
Foundation for enterprise-grade document management systems

🏗️ Project Structure

```text
IroncladVaultManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/java/IroncladVaultManagementSystem/
│   │   │       ├── config/
│   │   │       │   ├── AppConfig.java
│   │   │       │   ├── JwtRequestFilter.java
│   │   │       │   ├── JwtUtil.java
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── controller/
│   │   │       │   ├── AuditLogController.java
│   │   │       │   ├── UserController.java
│   │   │       │   └── VaultController.java
│   │   │       ├── dto/
│   │   │       │   ├── AuthRequest.java
│   │   │       │   ├── AuthResponse.java
│   │   │       │   └── FileResponse.java
│   │   │       ├── model/
│   │   │       │   ├── AuditLog.java
│   │   │       │   ├── FileEntity.java
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   ├── AuditLogRepository.java
│   │   │       │   ├── FileRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       ├── service/
│   │   │       │   ├── FileService.java
│   │   │       │   └── UserService.java
│   │   │       └── util/
│   │   │           └── AESUtil.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/        # Static resources (css, js, images)
│   │       └── templates/     # Thymeleaf HTML templates
│   └── test/
│       └── java/
│           └── com/java/IroncladVaultManagementSystem/
│               ├── AuthControllerTests.java
│               └── IroncladVaultManagementSystemApplicationTests.java
├── vault_storage/               # Folder to store encrypted files
├── pom.xml                      # Maven project descriptor
└── README.md                    # Project documentation
```

🛠️ Technology Stack

Java 17+
Spring Boot 3.x
Spring Data JPA
Spring Security with JWT
AES-256 Encryption for file security
MySQL Database
Maven
REST API

🔗 REST API Endpoints
| Endpoint                 | Method | Description                            |
| ------------------------ | ------ | -------------------------------------- |
| /api/v1.0/users/register | POST   | Register a new user                    |
| /api/v1.0/users/login    | POST   | Authenticate user and return JWT token |


Vault Management
| Endpoint                      | Method | Description                      |
| ----------------------------- | ------ | -------------------------------- |
| /vault/upload                 | POST   | Upload a new file (encrypted)    |
| /vault/files                  | GET    | List files (role-based access)   |
| /vault/download/{filename}    | GET    | Download a file (decrypted)      |
| /vault/delete/{filename}      | DELETE | Delete a file (admin only)       |
| /vault/search?name={filename} | GET    | Search files by name             |
| /vault/audit-logs             | GET    | Retrieve audit logs (admin only) |


Audit Logs
| Endpoint    | Method | Description                                   |
| ----------- | ------ | --------------------------------------------- |
| /audit-logs | GET    | List all audit logs (for admins and managers) |


🔐 Security and Authentication
JWT Authentication: Ensures secure user login and role-based access
Password Hashing: Passwords stored securely using BCrypt
File Encryption: All uploaded files are encrypted with AES-256 before storage

Roles and Permissions
| Role    | Upload | View All Files | Download  | Delete | Search    | View Audit Logs |
| ------- | ------ | -------------- | --------- | ------ | --------- | --------------- |
| ADMIN   | Yes    | Yes            | Yes       | Yes    | Yes       | Yes             |
| MANAGER | Yes    | Yes (all)      | Yes       | No     | Yes       | No              |
| USER    | Yes    | Yes (own)      | Yes (own) | No     | Yes (own) | Yes (own)       |


Audit Logging: Tracks all file operations (UPLOAD, DOWNLOAD, DELETE) for accountability.

💾 Database Schema

User Table
| Column       | Description                 |
| ------------ | --------------------------- |
| id           | UUID Primary Key            |
| username     | Unique username             |
| passwordHash | BCrypt hashed password      |
| role         | Role (ADMIN, MANAGER, USER) |


FileEntity Table
| Column    | Description                    |
| --------- | ------------------------------ |
| id        | UUID Primary Key               |
| filename  | Original file name             |
| filepath  | Storage path of encrypted file |
| owner_id  | Foreign key referencing User   |
| createdAt | Timestamp                      |

AuditLog Table
| Column    | Description                   |
| --------- | ----------------------------- |
| id        | UUID Primary Key              |
| user_id   | User who performed the action |
| action    | UPLOAD / DOWNLOAD / DELETE    |
| file_id   | File affected                 |
| timestamp | Action timestamp              |


📈 Features

Secure file upload/download with AES encryption
JWT-based authentication and role management
Audit logging of all file actions
Search files by name
Role-based access control
User-friendly REST API design

🧠 How It Works (Internally)
User registers, password is hashed using BCrypt
User logs in, server issues a JWT token
User uploads/downloads files, JWT is validated by JwtRequestFilter
Each action is logged in AuditLog
Role-based security controls access to endpoints dynamically

🧑‍💻 Roles and Access Control
| Role    | Upload | View All Files | Download  | Delete | Search    | View Audit Logs |
| ------- | ------ | -------------- | --------- | ------ | --------- | --------------- |
| ADMIN   | Yes    | Yes            | Yes       | Yes    | Yes       | Yes             |
| MANAGER | Yes    | Yes (all)      | Yes       | No     | Yes       | No              |
| USER    | Yes    | Yes (own)      | Yes (own) | No     | Yes (own) | Yes (own)       |

🧰 API Endpoints Summary

User Authentication
| Method | Endpoint                 | Description                    |
| ------ | ------------------------ | ------------------------------ |
| POST   | /api/v1.0/users/register | Register a new user            |
| POST   | /api/v1.0/users/login    | Authenticate and get JWT token |


File Operations
| Method | Endpoint                      | Description              |
| ------ | ----------------------------- | ------------------------ |
| POST   | /vault/upload                 | Upload a file            |
| GET    | /vault/files                  | List available files     |
| GET    | /vault/download/{filename}    | Download a specific file |
| DELETE | /vault/delete/{filename}      | Delete file (Admin only) |
| GET    | /vault/search?name={filename} | Search file by name      |


Audit Logs
| Method | Endpoint          | Description                            |
| ------ | ----------------- | -------------------------------------- |
| GET    | /vault/audit-logs | View audit trail (Admin/User-specific) |
