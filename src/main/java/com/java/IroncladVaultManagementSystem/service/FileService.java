 package com.java.IroncladVaultManagementSystem.service;



import org.springframework.stereotype.Service;
import com.java.IroncladVaultManagementSystem.model.AuditLog;
import com.java.IroncladVaultManagementSystem.model.FileEntity;
import com.java.IroncladVaultManagementSystem.model.User;
import com.java.IroncladVaultManagementSystem.repository.AuditLogRepository;
import com.java.IroncladVaultManagementSystem.repository.FileRepository;
import com.java.IroncladVaultManagementSystem.util.AESUtil;

import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final AuditLogRepository auditLogRepository;

    // ⚡ For now, generate one static key (better: store securely in DB or Vault)
    private final SecretKey secretKey;

    public FileService(FileRepository fileRepository,
                       AuditLogRepository auditLogRepository) throws Exception {
        this.fileRepository = fileRepository;
        this.auditLogRepository = auditLogRepository;

        // Generate a new AES Key at service startup
        this.secretKey = AESUtil.generateKey();
    }

    public FileEntity uploadFile(String filename, byte[] fileData, User owner) throws IOException {
        try {
            // Ensure storage directory exists
            Files.createDirectories(Paths.get("vault_storage"));

            // ✅ Encrypt file data before saving
            String encryptedData = AESUtil.encrypt(Base64.getEncoder().encodeToString(fileData), secretKey);

            // Save encrypted data as file
            String storagePath = "vault_storage/" + UUID.randomUUID() + "_" + filename;
            try (FileOutputStream fos = new FileOutputStream(storagePath)) {
                fos.write(encryptedData.getBytes());
            }

            // Save metadata in DB
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFilename(filename);
            fileEntity.setFilepath(storagePath);
            fileEntity.setOwner(owner);
            FileEntity saved = fileRepository.save(fileEntity);

            // Log action
            AuditLog log = new AuditLog();
            log.setUser(owner);
            log.setAction("UPLOAD");
            log.setFile(saved);
            auditLogRepository.save(log);

            return saved;
        } catch (Exception e) {
            throw new IOException("Error encrypting file", e);
        }
    }

    public byte[] downloadFile(UUID fileId, User user) throws IOException {
        try {
            FileEntity fileEntity = fileRepository.findById(fileId)
                    .orElseThrow(() -> new RuntimeException("File not found"));

            // Read encrypted data from file
            String encryptedData = new String(Files.readAllBytes(Paths.get(fileEntity.getFilepath())));

            // ✅ Decrypt the data
            String decryptedBase64 = AESUtil.decrypt(encryptedData, secretKey);
            byte[] decryptedBytes = Base64.getDecoder().decode(decryptedBase64);

            // Log download
            AuditLog log = new AuditLog();
            log.setUser(user);
            log.setAction("DOWNLOAD");
            log.setFile(fileEntity);
            auditLogRepository.save(log);

            return decryptedBytes;
        } catch (Exception e) {
            throw new IOException("Error decrypting file", e);
        }
    }

    public byte[] downloadFile(String filename, User user) throws IOException {
        try {
            FileEntity fileEntity = fileRepository.findByOwnerAndFilename(user, filename)
                    .orElseThrow(() -> new RuntimeException("File not found"));

            // Read encrypted data from file
            String encryptedData = new String(Files.readAllBytes(Paths.get(fileEntity.getFilepath())));

            // ✅ Decrypt the data
            String decryptedBase64 = AESUtil.decrypt(encryptedData, secretKey);
            byte[] decryptedBytes = Base64.getDecoder().decode(decryptedBase64);

            // Log download
            AuditLog log = new AuditLog();
            log.setUser(user);
            log.setAction("DOWNLOAD");
            log.setFile(fileEntity);
            auditLogRepository.save(log);

            return decryptedBytes;
        } catch (Exception e) {
            throw new IOException("Error decrypting file", e);
        }
    }

    public List<FileEntity> listFiles(User owner) {
        return fileRepository.findByOwner(owner);
    }
    
    public FileEntity getFileEntityById(UUID id, User currentUser) throws IOException {
        return fileRepository.findById(id)
                .filter(f -> f.getOwner().getId().equals(currentUser.getId()))
                .orElseThrow(() -> new IOException("File not found or access denied"));
    }

    public void deleteFile(String filename, User user) throws IOException {
        try {
            FileEntity fileEntity = fileRepository.findByOwnerAndFilename(user, filename)
                    .orElseThrow(() -> new RuntimeException("File not found"));

            // Delete the file from storage
            Files.deleteIfExists(Paths.get(fileEntity.getFilepath()));

            // Delete from DB
            fileRepository.delete(fileEntity);

            // Log delete
            AuditLog log = new AuditLog();
            log.setUser(user);
            log.setAction("DELETE");
            log.setFile(fileEntity);
            auditLogRepository.save(log);
        } catch (Exception e) {
            throw new IOException("Error deleting file", e);
        }
    }

    public List<FileEntity> searchFiles(User user, String name) {
        return fileRepository.findByOwnerAndFilenameContaining(user, name);
    }

    public List<AuditLog> getAuditLogs(User user) {
        return auditLogRepository.findByUser(user);
    }

    public List<FileEntity> listAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<FileEntity> findByFilename(String filename) {
        return fileRepository.findByFilename(filename);
    }

    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    public List<FileEntity> searchAllFiles(String name) {
        return fileRepository.findByFilenameContaining(name);
    }
}

