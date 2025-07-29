package com.fractal.domain.navigation.menu;

import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import com.fractal.domain.navigation.menu.mapper.MenuMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class MenuServiceImpl implements MenuService {

    private final MenuMapperService mapperService;
    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public Menu create(MenuRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getByUrl(String url) {
        return menuRepository.findByUrl(url).orElseThrow(()-> new ResourceNotFoundException("Menu with url: " + url + " not found"));
    }

    @Override
    public Menu getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Menu update(Long id, MenuRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id),dto));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        menuRepository.delete(findById(id));
    }

    @Override
    public MenuResponse toDTO(Menu menu) {
        return mapperService.toDTO(menu);
    }

    @Override
    @Transactional
    public Menu addChild(Long id, MenuRequest dto) {
        var menu = findById(id);
        var child = mapperService.toEntity(dto);
        if (menu.getLevel().equals(child.getLevel())) {
            throw new RuntimeException("Child can not have same level as parent ");
        }
        menu.addChild(child);
        return save(menu);
    }

    @Override
    @Transactional
    public Menu updateChild(Long id, Long childId, MenuRequest dto) {
        var menu = findById(id);
        var child = menu.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(),dto);
        return save(menu);
    }

    @Override
    public Menu deleteChild(Long id, Long childId) {
        var menu = findById(id);
        var child = menu.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        menu.removeChild(child);
        return save(menu);
    }

    @Override
    public Menu save(Menu menu) {
        try {
            return menuRepository.save(menu);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Menu with id: " + id + " not found"));
    }
}
