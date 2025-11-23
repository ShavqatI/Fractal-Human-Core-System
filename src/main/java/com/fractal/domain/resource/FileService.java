package com.fractal.domain.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;

public interface FileService {
    String save(MultipartFile file, String path);
    void delete(String path);
    String copy(String url);
    String copy(String from, String to);
    ResponseEntity<StreamingResponseBody> view(Path path);
    ResponseEntity<org.springframework.core.io.Resource> download(Path path);
}
