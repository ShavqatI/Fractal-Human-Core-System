package com.fractal.domain.authorization.role.menu;

import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuRepository roleMenuRepository;
    private final MenuService menuService;
    private final StatusService statusService;
    private final RoleService roleService;
    @Override
    public RoleMenu create(Long roleId, RoleMenuRequest dto) {
        var role = roleService.getById(roleId);
        var roleMenu = toEntity(dto);
        role.addMenu(roleMenu);
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
        roleMenu = save(toEntity(roleMenu,dto));
        roleService.save(role);
        return roleMenu;
    }

    @Override
    public void delete(Long roleId,Long id) {
        var role = roleService.getById(roleId);
        var roleMenu = role.getRoleMenus()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Role menu with id: " + id + " not found"));
        roleMenuRepository.delete(roleMenu);
        roleService.save(role);
    }

    @Override
    public RoleMenuResponse toDTO(RoleMenu roleMenu) {
        return new RoleMenuResponse(
                roleMenu.getId(),
                roleMenu.getMenu().getName(),
                roleMenu.getStatus().getName(),
                roleMenu.getCreatedDate(),
                roleMenu.getUpdatedDate()
        );
    }

    private RoleMenu save(RoleMenu roleMenu) {
        try {
            return roleMenuRepository.save(roleMenu);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private RoleMenu toEntity(RoleMenuRequest dto) {
        return RoleMenu.builder()
                .menu(menuService.getById(dto.menuId()))
                .status(statusService.getById(dto.statusId()))
                .build();
    }
    private RoleMenu toEntity(RoleMenu roleMenu,RoleMenuRequest dto) {
        roleMenu.setMenu(menuService.getById(dto.menuId()));
        roleMenu.setStatus(statusService.getById(dto.statusId()));
        return roleMenu;
    }
}

