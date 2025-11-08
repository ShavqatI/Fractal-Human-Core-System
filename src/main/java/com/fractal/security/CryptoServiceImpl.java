/*
package com.fractal.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
class CryptoServiceImpl implements CryptoService {

    private final TextEncryptor textEncryptor;


    @Override
    public String encrypt(BigDecimal decimal) {
        return textEncryptor.encrypt(String.valueOf(decimal));
    }

    @Override
    public String decrypt(String string) {
        return textEncryptor.decrypt(string);
    }
}
*/
