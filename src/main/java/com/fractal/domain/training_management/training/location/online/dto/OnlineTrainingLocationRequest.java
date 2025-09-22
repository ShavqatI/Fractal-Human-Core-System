package com.fractal.domain.training_management.training.location.online.dto;

public record OnlineTrainingLocationRequest(
        Long onlinePlatformId,
        String link,
        String username,
        String password,
        Integer capacity,
        Long statusId
) { }
