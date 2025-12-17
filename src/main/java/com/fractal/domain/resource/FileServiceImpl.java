package com.fractal.domain.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
            if (path != null)
                Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String copy(String url) {
        Path path = Path.of(url);
        String fileName = path.getFileName().toString();
        String newFileName = UUID.randomUUID() + "_" + fileName;
        Path target = path.resolveSibling(newFileName);
        try {
            Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return target.toString();
    }

    @Override
    public String copy(String from, String to) {
        Path fromPath = Path.of(from);
        Path toPath = Path.of(to);
        String fileName = fromPath.getFileName().toString();
        String newFileName = UUID.randomUUID() + "_" + fileName;
        Path target = toPath.resolveSibling(newFileName);
        try {
            Files.copy(fromPath, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return target.toString();
    }

    @Override
    public ResponseEntity<StreamingResponseBody> view(Path path) {
        if (!Files.exists(path)) {
            return ResponseEntity.noContent().build();
        }
        try {
            String filename = path.getFileName().toString();
            String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8);

            StreamingResponseBody responseBody = outputStream -> {
                Files.copy(path, outputStream);
                outputStream.flush();
                Files.deleteIfExists(path);
            };
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + encodedFilename + "\"")
                    .body(responseBody);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<org.springframework.core.io.Resource> download(Path path) {
        try {
            Resource resource = new FileSystemResource(path);
            String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8);
            if (!resource.exists()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"")
                    .body(resource);


        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
