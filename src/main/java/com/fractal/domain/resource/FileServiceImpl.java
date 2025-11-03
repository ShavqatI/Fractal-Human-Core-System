package com.fractal.domain.resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
class FileServiceImpl implements FileService {
    @Override
    public String save(MultipartFile file, String path) {
        var uploadPath = Path.of(path);
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
