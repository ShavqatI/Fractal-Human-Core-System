package com.fractal.domain.authorization.permission;

import com.fractal.domain.authorization.permission.dto.PermissionRequest;
import com.fractal.domain.authorization.permission.dto.PermissionResponse;
import com.fractal.domain.authorization.permission.mapper.PermissionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapperService mapperService;

    @Override
    public Permission create(PermissionRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public Permission getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> getAllByRoleId(Long roleId) {
        return permissionRepository.findAllByRoleId(roleId);
    }

    @Override
    public List<Permission> getAllByMenuId(Long menuId) {
        return permissionRepository.findAllByMenuActionMenuId(menuId);
    }

    @Override
    public List<Permission> getAllByRoleIdMenuId(Long roleId,Long menuId) {
        return permissionRepository.findAllByRoleIdAndMenuActionMenuId(roleId,menuId);
    }

    @Override
    public Permission update(Long id, PermissionRequest dto) {
        try {
            var permission = findById(id);
            return save(mapperService.toEntity(permission,dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(Long id) {
      permissionRepository.delete(findById(id));
    }

    @Override
    public PermissionResponse toDTO(Permission permission) {
        return mapperService.toDTO(permission);
    }

    private Permission save(Permission permission) {
        try {
            return permissionRepository.save(permission);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Permission findById(Long id) {
        return permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Permission with id: " + id + " not found"));
    }
}

