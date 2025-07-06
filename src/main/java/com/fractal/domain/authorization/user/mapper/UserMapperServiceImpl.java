package com.fractal.domain.authorization.user.mapper;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.dto.UserResponse;
import com.fractal.domain.authorization.user.role.UserRoleService;
import com.fractal.domain.authorization.user.role.mapper.UserRoleMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserMapperServiceImpl implements UserMapperService {

    private final PasswordEncoder passwordEncoder;
    private final UserRoleMapperService userRoleMapperService;

    @Override
    public UserResponse toDTO(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }

    @Override
    public User toEntity(UserRequest dto) {
        return mapToEntity(new User(),dto);
    }

    @Override
    public User toEntity(User user, UserRequest dto) {
       return mapToEntity(user,dto);
    }

    private User mapToEntity(User user, UserRequest dto) {
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        dto.userRoles().forEach(userRole-> user.addRole(userRoleMapperService.toEntity(userRole)));
        return user;
    }

}
