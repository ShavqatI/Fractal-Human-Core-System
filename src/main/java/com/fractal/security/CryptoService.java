package com.fractal.security;

import java.math.BigDecimal;

public interface CryptoService {

    String encrypt(BigDecimal decimal);
    String decrypt(String string);
}
