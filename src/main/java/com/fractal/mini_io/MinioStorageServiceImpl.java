package com.fractal.mini_io;

import com.fractal.config.MinioConfig;
import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class MinioStorageServiceImpl implements MinioStorageService {

    private final MinioClient minioClient;
    private final MinioConfig config;

    public void uploadFile(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(config.getBucket())
                        .object(file.getOriginalFilename())
                        .stream(inputStream, file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );
    }

    public byte[] downloadFile(String filename) throws Exception {
        try (GetObjectResponse response = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(config.getBucket())
                        .object(filename)
                        .build())) {
            return response.readAllBytes();
        }
    }

    public String getFileUrl(String filename) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(config.getBucket())
                        .object(filename)
                        .build());
    }

    @Override
    public void createFolder(String bucket, String dirPath) throws Exception {
        ByteArrayInputStream emptyContent = new ByteArrayInputStream(new byte[] {});
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucket)
                        .object(dirPath)
                        .stream(emptyContent, 0, -1)
                        .build()
        );
    }
}
