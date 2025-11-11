package com.fractal.domain.resource;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String save(MultipartFile file,String path);
    void delete(String path);

    String copy(String url);
    String copy(String from,String to);
}
