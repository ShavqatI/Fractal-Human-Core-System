package com.fractal.domain.authorization.user;

import com.fractal.domain.authorization.user.dto.*;
import com.fractal.domain.authorization.user.mapper.UserMapperService;
import com.fractal.domain.authorization.user.role.UserRole;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapperService mapperService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    @Transactional
    public User create(UserRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User with username:" + username + " not found"));
        return user;
    }

    @Override
    @Transactional
    public User update(Long id, UserRequest dto) {
        return mapperService.toEntity(findById(id), dto);
    }

    @Override
    public void resetPassword(Long id, ResetPasswordRequest dto) {
        try {
            var user = findById(id);
            user.setPassword(passwordEncoder.encode(dto.password()));
            save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void changePassword(Long id, ChangePasswordRequest dto) {
        try {
            var user = findById(id);
            if (passwordEncoder.matches(dto.oldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(dto.newPassword()));
                save(user);
            } else throw new RuntimeException("Old password is wrong!" + dto.oldPassword());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public UserResponse toDTO(User user) {
        return mapperService.toDTO(user);
    }

    @Override
    public UserCompactResponse toCompactDTO(User user) {
        return mapperService.toCompactDTO(user);
    }

    @Override
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRole> getActiveRoles(Long id) {
        return findById(id).getUserRoles().stream()
                .filter(userRole -> userRole.getStatus().getCode().equals("ACTIVE"))
                .collect(Collectors.toList());
    }


    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
    }


}

