package com.fractal.domain.authorization.user.mapper;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.dto.UserResponse;
import com.fractal.domain.employee_management.address.EmployeeAddress;

public interface UserMapperService {
    UserResponse toDTO(User user);
    User toEntity(UserRequest dto);
    User toEntity(User user, UserRequest dto);
}


