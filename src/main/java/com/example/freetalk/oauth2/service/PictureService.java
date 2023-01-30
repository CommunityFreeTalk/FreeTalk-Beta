package com.example.freetalk.oauth2.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PictureService {

    @Value("${site-file.upload-dir}")
    private String uploadDir;

    @Value("${site-file.upload-path}")
    private String realPath;

    public String uploadPic(MultipartFile filedata) throws IOException {
        String result = realPath;
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.isDirectory(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        MultipartFile mFile = filedata;
        UUID tempFileName = UUID.randomUUID();
        String originalFileName = mFile.getOriginalFilename();
        String fileExt = FilenameUtils.getExtension(originalFileName);

        if (originalFileName.toLowerCase().endsWith(".tar.bz2")) {
            fileExt = "tar.bz2";
        } else if (originalFileName.toLowerCase().endsWith(".tar.gz")) {
            fileExt = "tar.gz";
        }
        String logicalFileName = tempFileName.toString() + "." + fileExt;

        byte[] fileBytes = mFile.getBytes();
        Path filePath = uploadPath.resolve(logicalFileName);
        Files.write(filePath, fileBytes);

        return "<img src='" + result + logicalFileName + "'>";
    }

}
