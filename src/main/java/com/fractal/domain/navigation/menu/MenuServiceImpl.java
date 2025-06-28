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
        return null;
    }
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
