package com.fractal.domain.location.area_type;

import com.fractal.domain.location.area_type.dto.AreaTypeRequest;
import com.fractal.domain.location.area_type.dto.AreaTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class AreaTypeServiceImpl implements AreaTypeService {

    private final AreaTypeRepository areaTypeRepository;

    @Override
    public AreaType create(AreaTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<AreaType> getAll() {
        return areaTypeRepository.findAll();
    }

    @Override
    public AreaType getByCode(String code) {
        return areaTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public AreaType getById(Long id) {
        return findById(id);
    }

    @Override
    public AreaType update(Long id, AreaTypeRequest dto) {
        try {
            AreaType areaType = findById(id);
            areaType.setCode(dto.code());
            areaType.setName(dto.name());
            return save(areaType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        areaTypeRepository.delete(findById(id));
    }

    @Override
    public AreaTypeResponse toDTO(AreaType areaType) {
        return new AreaTypeResponse(
                areaType.getId(),
                areaType.getCode(),
                areaType.getName(),
                areaType.getCreatedDate()
        );
    }

    private AreaType toEntity(AreaTypeRequest dto) {
        return AreaType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AreaType save(AreaType areaType) {
        try {
            return areaTypeRepository.save(areaType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private AreaType findById(Long id) {
        return areaTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
