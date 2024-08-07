package com.sysu.verto.storage.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String fileDir;

    public void saveFile(String fileName, byte[] fileContent) throws IOException {
        Path targetLocation = Paths.get(fileDir).toAbsolutePath().normalize().resolve(fileName);
        System.out.println("Saving file to: " + targetLocation.toString());
        Files.createDirectories(targetLocation.getParent());
        Files.write(targetLocation, fileContent);
    }

    public byte[] getFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileDir).toAbsolutePath().normalize().resolve(fileName);
        System.out.println("Reading file from: " + filePath.toString());
        return Files.readAllBytes(filePath);
    }

    public void deleteFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileDir).toAbsolutePath().normalize().resolve(fileName);
        System.out.println("Deleting file from: " + filePath.toString());
        Files.deleteIfExists(filePath);
    }
}
