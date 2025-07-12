package com.fractal.domain.localization.layout_label.detail;

import com.fractal.domain.localization.layout_label.LayoutLabelService;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;
import com.fractal.domain.localization.layout_label.detail.mapper.LayoutLabelDetailMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LayoutLabelDetailServiceImpl implements LayoutLabelDetailService {

    private final LayoutLabelDetailRepository layoutLabelDetailRepository;
    private final LayoutLabelDetailMapperService mapperService;
    private final LayoutLabelService layoutLabelService;



    @Override
    @Transactional
    public LayoutLabelDetail create(Long menuId, LayoutLabelDetailRequest dto) {
        var layoutLabel = layoutLabelService.getById(menuId);
        var detail = mapperService.toEntity(dto);
        layoutLabel.addDetail(detail);
        layoutLabelService.save(layoutLabel);
        return detail;
    }
    @Override
    public List<LayoutLabelDetail> getAllByLayoutLabelId(Long layoutLabelId) {
        return layoutLabelDetailRepository.findAllByLayoutLabelId(layoutLabelId);
    }

    @Override
    public LayoutLabelDetail getById(Long layoutLabelId,Long id) {
        return layoutLabelDetailRepository.findByLayoutLabelIdAndId(layoutLabelId,id).orElseThrow(()->new ResourceNotFoundException("Layout Label Detail with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public LayoutLabelDetail update(Long layoutLabelId,Long id, LayoutLabelDetailRequest dto) {
        var layoutLabel = layoutLabelService.getById(layoutLabelId);
        var detail = layoutLabel.getLayoutLabelDetails().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Layout Label Detail with id: " + id + " not found"));
        detail = layoutLabelDetailRepository.save(mapperService.toEntity(detail,dto));
        layoutLabelService.save(layoutLabel);
        return detail;
    }

    @Override
    @Transactional
    public void delete(Long layoutLabelId, Long id) {
        var layoutLabel = layoutLabelService.getById(layoutLabelId);
        var detail = layoutLabel.getLayoutLabelDetails().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Layout Label Detail with id: " + id + " not found"));
        layoutLabelDetailRepository.delete(detail);
        layoutLabelService.save(layoutLabel);
    }

    @Override
    public LayoutLabelDetailResponse toDTO(LayoutLabelDetail layoutLabelDetail) {
        return mapperService.toDTO(layoutLabelDetail);
    }
}
