package com.myproject.media.service.impl;

import com.myproject.media.config.FileSystemConfig;
import com.myproject.media.entity.Media;
import com.myproject.media.service.FileSystemService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author nguyenle
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileSystemServiceImpl implements FileSystemService {

    private final FileSystemConfig fileSystemConfig;

    @PostConstruct
    private void init() {
        File rootDirectory = new File(fileSystemConfig.getDirectory());
        if (!checkDirectoryExisted(rootDirectory)) {
            log.error("Directory not existed");
            throw new IllegalStateException(
                    String.format("Directory %s does not exist.", fileSystemConfig.getDirectory())
            );
        }
        if (checkDirectoryAccessible(rootDirectory)) {
            log.error("Directory not accessible");
            throw new IllegalStateException(
                    "Directory " + fileSystemConfig.getDirectory() + " is not accessible."
            );
        }
        Media test = new Media();
    }

    private boolean checkDirectoryExisted(File directory) {
        return directory.exists();
    }

    private boolean checkDirectoryAccessible(File directory) {
        return !directory.canRead() || !directory.canWrite();
    }
    
    @Override
    public String persistFile(String fileName, byte[] fileContent) throws IOException {
        Path filePath = buildFilePath(fileName);
        Files.write(filePath, fileContent);
        log.info("File saved: {}", fileName);
        return filePath.toString();
    }

    private Path buildFilePath(String fileName) throws IOException {
        if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")) {
            throw new IllegalArgumentException("Invalid filename");
        }

        // Normalize the path
        Path filePath = Paths.get(fileSystemConfig.getDirectory(), fileName).toRealPath();

        // Ensure the file is within the base directory
        if (!filePath.startsWith(fileSystemConfig.getDirectory())) {
            throw new IllegalArgumentException("Invalid file path");
        }
        return filePath;
    }

    @Override
    @SneakyThrows
    public InputStream getFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IllegalStateException(
                    String.format("Directory %s does not exist.", fileSystemConfig.getDirectory())
            );
        }
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}
