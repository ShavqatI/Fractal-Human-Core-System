package com.fractal.mini_io;

import org.springframework.web.multipart.MultipartFile;

public interface MinioStorageService {
    void uploadFile(MultipartFile file) throws Exception;
    byte[] downloadFile(String filename) throws Exception;
    String getFileUrl(String filename) throws Exception;
    void createFolder(String bucket, String dirPath) throws Exception;
}
