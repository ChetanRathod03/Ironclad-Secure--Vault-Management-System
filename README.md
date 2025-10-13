# Ironclad-Secure--Vault-Management-System

📌 Project Overview

Ironclad Vault Management System is a secure, encrypted file storage and management application built using Spring Boot and Java.  
The system allows users to upload, download, delete, and search files, with role-based access and audit logging for security and transparency.

Purpose of the Project: 
The primary goal is to create a centralized, secure vault system for storing sensitive files. It ensures data confidentiality via AES encryption, provides user authentication via JWT, and maintains a full audit trail of all file operations. Ideal for organizations requiring secure file storage with granular access control.
The Ironclad Vault Management System is designed to solve a critical problem in modern digital environments: secure and organized management of sensitive files. In today’s world, organizations, institutions, and individuals deal with massive amounts of confidential documents — ranging from financial records, legal contracts, certificates, and personal data.
This project provides a secure, role-based, and auditable platform where users can safely store, access, and manage digital files without fear of unauthorized access, data leaks, or accidental deletion. Its primary goals are:
Data Security and Privacy – Encrypts files and secures user credentials using strong standards such as AES encryption and BCrypt hashing.
Controlled Access – Implements role-based access control so only authorized personnel can view, download, or delete files.
Accountability & Auditability – Maintains detailed audit logs of every file operation, ensuring transparency and traceability.
Ease of Use – Provides a simple interface for performing file operations with minimal technical complexity.

The Ironclad Vault Management System is not just a file storage application; it is a security-first platform that:
Protects sensitive digital assets.
Ensures accountability through audit trails.
Enables organizations, institutions, and individuals to manage files efficiently and securely.
Provides a strong foundation for building enterprise-grade document management systems.
It exists in the real world as a solution for data security, controlled access, and operational transparency, making it valuable in any context where confidential information needs to be securely stored and managed.


🏗️ Project Structure

src/main/java/com/java/IroncladVaultManagementSystem/
├── config/ # Security, JWT, and Spring configurations
├── controller/ # REST Controllers for Users, Vault, and Audit Logs
├── dto/ # Data Transfer Objects (AuthRequest, AuthResponse, FileResponse)
├── model/ # Entity classes (User, FileEntity, AuditLog)
├── repository/ # JPA Repositories
├── service/ # Business logic (UserService, FileService)
├── util/ # Utility classes (AES encryption)
└── IroncladVaultManagementSystemApplication.java



🛠️ Technology Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Security with JWT
- AES-256 Encryption for file security
- MySQL Database
- Maven
- REST API



🔗 REST API Endpoints

User Management
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/v1.0/users/register` | POST | Register a new user |
| `/api/v1.0/users/login` | POST | Authenticate user and return JWT token |

Vault Management
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/vault/upload` | POST | Upload a new file (encrypted) |
| `/vault/files` | GET | List files (role-based access) |
| `/vault/download/{filename}` | GET | Download a file (decrypted) |
| `/vault/delete/{filename}` | DELETE | Delete a file (admin only) |
| `/vault/search?name={filename}` | GET | Search files by name |
| `/vault/audit-logs` | GET | Retrieve audit logs (admin only) |

Audit Logs
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/audit-logs` | GET | List all audit logs (for admins and managers) |

---

🔐 Security & Authentication

- JWT Authentication: Ensures secure user login and role-based access.  
- Password Hashing: Passwords are stored securely using BCrypt hashing.  
- File Encryption: All uploaded files are encrypted with AES-256 before storage.  
- Roles & Permissions:  
  - `ADMIN` – Full access (upload, download, delete, view all logs)  
  - `MANAGER` – Can upload, download, view files of others  
  - `USER` – Can upload/download/view only their own files  
- Audit Logging: Tracks all file operations (UPLOAD, DOWNLOAD, DELETE) for accountability.



 💾 Database Schema

User Table
| Column | Description |
|--------|-------------|
| id | UUID Primary Key |
| username | Unique username |
| passwordHash | BCrypt hashed password |
| role | Role (ADMIN, MANAGER, USER) |

FileEntity Table
| Column | Description |
|--------|-------------|
| id | UUID Primary Key |
| filename | Original file name |
| filepath | Storage path of encrypted file |
| owner_id | Foreign key referencing User |
| createdAt | Timestamp |

AuditLog Table
| Column | Description |
|--------|-------------|
| id | UUID Primary Key |
| user_id | User who performed the action |
| action | UPLOAD / DOWNLOAD / DELETE |
| file_id | File affected |
| timestamp | Action timestamp |

📈 Features

Secure file upload/download with encryption
JWT-based authentication and role management
Audit logging of all file actions
Search files by name
Role-based access control
User-friendly REST API design

🧑‍💻 Roles and Access Control
Role	 Upload 	ViewAll Files	     Download	 Delete	  Search	View Audit Logs
Admin  	✅	    ✅	                 ✅	       ✅	      ✅	      ✅
Manager	✅	    ✅ (all)           	 ✅	       ❌    	✅ 	      ❌
User	  ✅	    ✅ (own)	           ✅ (own)	 ❌    	✅ (own)	✅ (own)

🧰 API Endpoints
User Authentication
Method	Endpoint	Description
POST	/api/v1.0/users/register	Register a new user
POST	/api/v1.0/users/login	Authenticate and get JWT token

File Operations
Method	Endpoint	                        Description
POST	  /vault/upload                     Upload a file
GET   	/vault/files	                    List available files
GET	    /vault/download/{filename}      	Download a specific file
DELETE	/vault/delete/{filename}	        Delete file (Admin only)
GET	/vault/search?name={filename}       	Search file by name

Audit Logs
Method	Endpoint	        Description
GET	   /vault/audit-logs	View audit trail (Admin/User-specific)


🧠 How It Works (Internally)
User registers → password is hashed using BCrypt.
User logs in → server issues a JWT token.
User uploads/downloads files → JWT is validated by JwtRequestFilter.
Each action is logged in AuditLog.
Role-based security controls access to endpoints dynamically.
