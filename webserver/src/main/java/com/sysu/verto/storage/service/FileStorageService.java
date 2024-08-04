package com.sysu.verto.storage.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String fileDir;

    public void saveFile(String fileName, byte[] fileContent) throws IOException {
        Path targetLocation = Paths.get(fileDir, fileName);
        Files.write(targetLocation, fileContent);
    }

    public byte[] getFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileDir, fileName);
        return Files.readAllBytes(filePath);
    }

    public void deleteFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileDir, fileName);
        Files.deleteIfExists(filePath);
    }
}