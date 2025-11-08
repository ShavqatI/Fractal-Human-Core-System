/*
package com.fractal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.util.Base64;

@Configuration
public class CryptoConfig {

    @Bean
    public TextEncryptor textEncryptor(
            @Value("${encryption.password}") String base64Password,
            @Value("${encryption.salt}") String base64Salt) {
        String password = decryptBase64(base64Password);
        String salt = decryptBase64(base64Salt);
        return Encryptors.text(password, salt);
    }
    private String decryptBase64(String base64Salt) {
        byte[] saltBytes = Base64.getDecoder().decode(base64Salt);
        return new String(saltBytes);
    }
}
*/
