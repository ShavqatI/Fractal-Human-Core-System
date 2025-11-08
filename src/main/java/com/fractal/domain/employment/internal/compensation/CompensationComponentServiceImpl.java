package com.fractal.domain.employment.internal.compensation;

import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentResponse;
import com.fractal.domain.employment.internal.compensation.mapper.CompensationComponentMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CompensationComponentServiceImpl implements CompensationComponentService {

    private final CompensationComponentRepository compensationComponentRepository;
    private final CompensationComponentMapperService compensationComponentMapperService;
    private final InternalEmploymentService employmentService;

    @Override
    @Transactional
    public CompensationComponent create(Long employmentId, CompensationComponentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = compensationComponentMapperService.toEntity(dto);
        employment.addCompensationComponent(compensationComponent);
        employmentService.save(employment);
        return compensationComponent;
    }

    @Override
    public List<CompensationComponent> getAllByInternalEmploymentId(Long employmentId) {
        return compensationComponentRepository.findAllByInternalEmploymentId(employmentId);
    }

    @Override
    public CompensationComponent getById(Long employmentId, Long id) {
        return compensationComponentRepository.findByInternalEmploymentIdAndId(employmentId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public CompensationComponent update(Long employmentId, Long id, CompensationComponentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = employment.getCompensationComponents()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        compensationComponent = compensationComponentMapperService.toEntity(compensationComponent,dto);
        compensationComponentRepository.save(compensationComponent);
        employmentService.save(employment);
        return compensationComponent;
    }

    @Override
    @Transactional
    public void delete(Long employmentId, Long id) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = employment.getCompensationComponents()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        employment.removeCompensationComponent(compensationComponent);
        employmentService.save(employment);
    }

    @Override
    public CompensationComponentResponse toDTO(CompensationComponent agreement) {
        return compensationComponentMapperService.toDTO(agreement);
    }
    @Override
    public CompensationComponent save(CompensationComponent agreement) {
        try {
            return compensationComponentRepository.save(agreement);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public CompensationComponent getById(Long id) {
        return findById(id);
    }

    private CompensationComponent findById(Long id) {
        return compensationComponentRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
