package com.fractal.domain.authorization.user;

import com.fractal.domain.authorization.user.dto.ChangePasswordRequest;
import com.fractal.domain.authorization.user.dto.ResetPasswordRequest;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.dto.UserResponse;
import com.fractal.domain.authorization.user.role.UserRole;

import java.util.List;

public interface UserService {
    User create(UserRequest dto);
    User getById(Long id);
    User findByUsername(String username);
    List<User> getAll();
    User update(Long id, UserRequest dto);
    void resetPassword(Long id, ResetPasswordRequest dto);
    void changePassword(Long id, ChangePasswordRequest dto);
    void deleteById(Long id);
    User save(User user);
    List<UserRole> getActiveRoles(Long id);
    UserResponse toDTO(User user);

}
