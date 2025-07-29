 package com.fractal.domain.navigation.menu.action.dto;

 import com.fractal.domain.dictionary.status.dto.StatusResponse;
 import com.fractal.domain.navigation.action.dto.ActionResponse;

 import java.time.LocalDateTime;

 public record MenuActionResponse(
        Long id,
        Menu menu,
        ActionResponse action,
        StatusResponse status,
        LocalDateTime createdDate
) {
  public record Menu(Long id, String name){}
 }

