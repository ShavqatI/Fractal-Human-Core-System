package com.fractal.domain.authorization.role;

import com.fractal.domain.authorization.role.dto.RoleRequest;
import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.authorization.role.menu.mapper.RoleMenuMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMenuMapperService roleMenuMapperService;

    @Override
    public Role create(RoleRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public Role getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Long id, RoleRequest dto) {
        try {
            var role = findById(id);
            role.setCode(dto.code());
            role.setName(dto.name());
            return save(role);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(Long id) {
       roleRepository.delete(findById(id));
    }

    @Override
    public RoleResponse toDTO(Role role) {
        return new RoleResponse(
              role.getId(),
              role.getCode(),
              role.getName(),
              role.getCreatedDate(),
              role.getUpdatedDate()
        );
    }
    @Override
    public Role save(Role role) {
        try {
            return roleRepository.save(role);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role with id: " + id + " not found"));
    }

    private Role toEntity(RoleRequest dto) {
       var role = Role.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
       dto.menus().forEach(menu-> role.addMenu(roleMenuMapperService.toEntity(menu)));
       return role;
    }
}

