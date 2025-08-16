package com.fractal.domain.education.grade_point_average;

import com.fractal.domain.education.grade_point_average.dto.GradePointAverageRequest;
import com.fractal.domain.education.grade_point_average.dto.GradePointAverageResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class GradePointAverageServiceImpl implements GradePointAverageService {

    private final GradePointAverageRepository gradePointAverageRepository;

    @Override
    public GradePointAverage create(GradePointAverageRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<GradePointAverage> getAll() {
        return gradePointAverageRepository.findAll();
    }



    @Override
    public GradePointAverage getById(Long id) {
        return findById(id);
    }

    @Override
    public GradePointAverage update(Long id, GradePointAverageRequest dto) {
        try {
            GradePointAverage gradePointAverage = findById(id);
            gradePointAverage.setValue(dto.value());
            gradePointAverage.setScale(dto.scale());
            return save(gradePointAverage);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      gradePointAverageRepository.delete(findById(id));
    }

    @Override
    public GradePointAverageResponse toDTO(GradePointAverage gradePointAverage) {
        return new GradePointAverageResponse(
                gradePointAverage.getId(),
                gradePointAverage.getValue(),
                gradePointAverage.getScale(),
                gradePointAverage.getCreatedDate()
        );
    }

    private GradePointAverage toEntity(GradePointAverageRequest dto) {
        return GradePointAverage.builder()
                .value(dto.value())
                .scale(dto.scale())
                .build();
    }

    private GradePointAverage save(GradePointAverage gradePointAverage) {
        try {
            return gradePointAverageRepository.save(gradePointAverage);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private GradePointAverage findById(Long id) {
        return gradePointAverageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grade Point Average with id: " + id + " not found"));
    }

}
