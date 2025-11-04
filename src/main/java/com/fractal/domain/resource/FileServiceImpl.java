package com.fractal.domain.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class FileServiceImpl implements FileService {

    @Override
    public String save(MultipartFile file, String path) {
        var uploadPath = Path.of(path).toAbsolutePath().normalize();
        Path filePath = uploadPath.resolve(UUID.randomUUID() + "_" + file.getOriginalFilename()).toAbsolutePath();
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String path) {
        try {
            if(path != null)
            Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
