package com.fractal.domain.localization.layout_label;

import com.fractal.domain.localization.layout_label.dto.LayoutLabelRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;
import com.fractal.domain.localization.layout_label.mapper.LayoutLabelMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LayoutLabelServiceImpl implements LayoutLabelService {

    private final LayoutLabelMapperService mapperService;
    private final LayoutLabelRepository layoutLabelRepository;

    @Override
    @Transactional
    public LayoutLabel create(LayoutLabelRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<LayoutLabel> getAll() {
        return layoutLabelRepository.findAll();
    }

    @Override
    public LayoutLabel getByName(String name) {
        return layoutLabelRepository.findByName(name).orElseThrow(()-> new ResourceNotFoundException("LayoutLabel with name: " + name + " not found"));
    }

    @Override
    public LayoutLabel getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public LayoutLabel update(Long id, LayoutLabelRequest dto) {
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
        layoutLabelRepository.delete(findById(id));
    }

    @Override
    public LayoutLabelResponse toDTO(LayoutLabel layoutLabel) {
        return mapperService.toDTO(layoutLabel);
    }



    @Override
    public LayoutLabel save(LayoutLabel layoutLabel) {
        try {
            return layoutLabelRepository.save(layoutLabel);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LayoutLabel findById(Long id) {
        return layoutLabelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("LayoutLabel with id: " + id + " not found"));
    }
}
