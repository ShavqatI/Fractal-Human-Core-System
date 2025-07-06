package com.fractal.domain.authorization.user;

import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.dto.UserResponse;
import com.fractal.domain.authorization.user.mapper.UserMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapperService mapperService;
    private final UserRepository userRepository;

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
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("User with username:" + username + " not found"));
    }

    @Override
    @Transactional
    public User update(Long id, UserRequest dto) {
        return mapperService.toEntity(findById(id),dto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public UserResponse toDTO(User user) {
        return mapperService.toDTO(user);
    }

    @Override
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
    }


}

