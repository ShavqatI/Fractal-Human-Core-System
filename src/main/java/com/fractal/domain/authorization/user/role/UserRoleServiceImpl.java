package com.fractal.domain.authorization.user.role;

import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserService userService;
    private final RoleService roleService;
    @Override
    public UserRole create(Long userId,UserRoleRequest dto) {
        var user = userService.getById(userId);
        var userRole = toEntity(dto);
        user.addRole(userRole);
        return userRole;
    }

    @Override
    public UserRole getById(Long userId,Long id) {
        var user = userService.getById(userId);
        return user.getUserRoles()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("User role with id: " + id + " not found"));
    }

    @Override
    public List<UserRole> getAllByUserId(Long userId) {
        return userRoleRepository.findAllByUserId(userId);
    }

    @Override
    public UserRole update(Long userId,Long id, UserRoleRequest dto) {
        var user = userService.getById(userId);
        var userRole = user.getUserRoles()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("User role with id: " + id + " not found"));
        userRole = save(toEntity(userRole,dto));
        userService.save(user);
        return userRole;
    }

    @Override
    public void delete(Long userId,Long id) {
        var user = userService.getById(userId);
        var userRole = user.getUserRoles()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("User role with id: " + id + " not found"));
        user.removeRole(userRole);
        userRoleRepository.delete(userRole);
    }

    @Override
    public UserRoleResponse toDTO(UserRole userRole) {
        return new UserRoleResponse(
                userRole.getId(),
                userRole.getRole().getName(),
                userRole.getStatus().getName(),
                userRole.getCreatedDate(),
                userRole.getUpdatedDate()
        );
    }

    private UserRole save(UserRole userRole) {
        try {
            return userRoleRepository.save(userRole);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private UserRole toEntity(UserRoleRequest dto) {
        return UserRole.builder().role(roleService.getById(dto.roleId())).build();
    }
    private UserRole toEntity(UserRole userRole,UserRoleRequest dto) {
        userRole.setRole(roleService.getById(dto.roleId()));
        return userRole;
    }
}

