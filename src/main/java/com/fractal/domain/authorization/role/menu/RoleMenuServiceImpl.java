package com.fractal.domain.authorization.role.menu;

import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.authorization.role.menu.mapper.RoleMenuMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuRepository roleMenuRepository;
    private final RoleService roleService;
    private final RoleMenuMapperService mapperService;
    @Override
    public RoleMenu create(Long roleId, RoleMenuRequest dto) {
        var role = roleService.getById(roleId);
        var roleMenu = mapperService.toEntity(dto);
        role.addMenu(roleMenu);
        roleService.save(role);
        return roleMenu;
    }

    @Override
    public RoleMenu getById(Long roleId, Long id) {
        var role = roleService.getById(roleId);
        return role.getRoleMenus()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Role menu with id: " + id + " not found"));
    }

    @Override
    public List<RoleMenu> getAllByRoleId(Long roleId) {
        return roleMenuRepository.findAllByRoleId(roleId);
    }

    @Override
    public RoleMenu update(Long roleId, Long id, RoleMenuRequest dto) {
        var role = roleService.getById(roleId);
        var roleMenu = role.getRoleMenus()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Role menu with id: " + id + " not found"));
        roleMenu = save(mapperService.toEntity(roleMenu,dto));
        roleService.save(role);
        return roleMenu;
    }

    @Override
    public void delete(Long roleId,Long id) {
        var role = roleService.getById(roleId);
        var roleMenu = role.getRoleMenus()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Role menu with id: " + id + " not found"));
        role.removeMenu(roleMenu);
        roleService.save(role);
    }

    @Override
    public RoleMenuResponse toDTO(RoleMenu roleMenu) {
        return mapperService.toDTO(roleMenu);
    }

    private RoleMenu save(RoleMenu roleMenu) {
        try {
            return roleMenuRepository.save(roleMenu);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}

