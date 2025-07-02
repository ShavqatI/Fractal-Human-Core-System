package com.fractal.domain.authorization.user.dto;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        List<String> roles
) { }
