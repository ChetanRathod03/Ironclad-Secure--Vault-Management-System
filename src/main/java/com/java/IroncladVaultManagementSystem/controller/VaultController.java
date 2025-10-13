package com.java.IroncladVaultManagementSystem.controller;

import com.java.IroncladVaultManagementSystem.model.AuditLog;
import com.java.IroncladVaultManagementSystem.model.FileEntity;
import com.java.IroncladVaultManagementSystem.model.User;
import com.java.IroncladVaultManagementSystem.repository.AuditLogRepository;
import com.java.IroncladVaultManagementSystem.repository.FileRepository;
import com.java.IroncladVaultManagementSystem.service.FileService;
import com.java.IroncladVaultManagementSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vault")
public class VaultController {

    private final FileService fileService;
    private final UserService userService;
    private final FileRepository fileRepository;
    private final AuditLogRepository auditLogRepository;

    public VaultController(FileService fileService, UserService userService, FileRepository fileRepository, AuditLogRepository auditLogRepository) {
        this.fileService = fileService;
        this.userService = userService;
        this.fileRepository = fileRepository;
        this.auditLogRepository = auditLogRepository;
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            String username = auth.getName();
            return userService.findByUsername(username);
        }
        throw new RuntimeException("User not authenticated");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        User user = getCurrentUser();
        try {
            FileEntity saved = fileService.uploadFile(file.getOriginalFilename(), file.getBytes(), user);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileEntity>> listFiles() {
        User user = getCurrentUser();
        if ("ADMIN".equals(user.getRole()) || "MANAGER".equals(user.getRole())) {
            return ResponseEntity.ok(fileService.listAllFiles());
        } else {
            return ResponseEntity.ok(fileService.listFiles(user));
        }
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
        User user = getCurrentUser();
        Optional<FileEntity> fileOpt = fileService.findByFilename(filename);
        if (fileOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        FileEntity file = fileOpt.get();
        if ("ADMIN".equals(user.getRole()) || "MANAGER".equals(user.getRole()) || file.getOwner().getId().equals(user.getId())) {
            try {
                byte[] data = fileService.downloadFile(file.getId(), user);
                return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                    .body(data);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        User user = getCurrentUser();
        if ("ADMIN".equals(user.getRole())) {
            Optional<FileEntity> fileOpt = fileService.findByFilename(filename);
            if (fileOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            FileEntity file = fileOpt.get();
            try {
                Files.deleteIfExists(Paths.get(file.getFilepath()));
                fileRepository.delete(file);
                AuditLog log = new AuditLog();
                log.setUser(user);
                log.setAction("DELETE");
                log.setFile(file);
                auditLogRepository.save(log);
                return ResponseEntity.ok("File deleted");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Delete failed: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(403).body("Delete not allowed");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<FileEntity>> searchFiles(@RequestParam("name") String name) {
        User user = getCurrentUser();
        if ("ADMIN".equals(user.getRole()) || "MANAGER".equals(user.getRole())) {
            return ResponseEntity.ok(fileService.searchAllFiles(name));
        } else {
            return ResponseEntity.ok(fileService.searchFiles(user, name));
        }
    }

    @GetMapping("/audit-logs")
    public ResponseEntity<List<AuditLog>> getAuditLogs() {
        User user = getCurrentUser();
        if ("ADMIN".equals(user.getRole())) {
            return ResponseEntity.ok(fileService.getAllAuditLogs());
        } else {
            return ResponseEntity.ok(fileService.getAuditLogs(user));
        }
    }
}
