package com.fractal.domain.authorization.user.dto;

public record ChangePasswordRequest(String oldPassword,String newPassword) {
}
