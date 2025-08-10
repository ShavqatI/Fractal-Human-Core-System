 package com.fractal.domain.navigation.menu.action.dto;

 import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
 import com.fractal.domain.navigation.action.dto.ActionCompactResponse;

 import java.time.LocalDateTime;

 public record MenuActionResponse(
         Long id,
         Menu menu,
         ActionCompactResponse action,
         StatusCompactResponse status,
         LocalDateTime createdDate
) {
  public record Menu(Long id, String name){}
 }

