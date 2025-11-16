package com.fractal.domain.recruitment.vacncy.duty;

import com.fractal.domain.recruitment.vacncy.duty.dto.DutyRequest;
import com.fractal.domain.recruitment.vacncy.duty.dto.DutyResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DutyServiceImpl implements DutyService {

    private final DutyRepository dutyRepository;

    @Override
    public DutyResponse toDTO(Duty duty) {
        return new DutyResponse(
                duty.getId(),
                duty.getDescription(),
                duty.getCreatedDate()
        );
    }

    @Override
    public Duty toEntity(DutyRequest dto) {
        return Duty.builder().description(dto.description()).build();
    }

    @Override
    public Duty findById(Long id) {
        return dutyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Responsibility with id: " + id + " not found"));
    }

    @Override
    public Duty update(Long id, DutyRequest dto) {
        Duty duty = findById(id);
        duty.setDescription(dto.description());
        return dutyRepository.save(duty);
    }

    @Override
    public void delete(Duty duty) {
        dutyRepository.delete(duty);
    }
}
