package com.fractal.domain.learning_develpment.learning.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.Learning;
import com.fractal.domain.learning_develpment.learning.category.LearningCategoryService;
import com.fractal.domain.learning_develpment.learning.delivery_mode.LearningDeliveryModeService;
import com.fractal.domain.learning_develpment.learning.dto.LearningCompactResponse;
import com.fractal.domain.learning_develpment.learning.dto.LearningRequest;
import com.fractal.domain.learning_develpment.learning.dto.LearningResponse;
import com.fractal.domain.learning_develpment.learning.level.LearningLevelService;
import com.fractal.domain.learning_develpment.learning.session.mapper.LearningSessionMapperService;
import com.fractal.domain.learning_develpment.learning.type.LearningTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class LearningMapperServiceImpl implements LearningMapperService {

    private final LearningSessionMapperService sessionMapperService;
    private final StatusService statusService;
    private final LearningTypeService typeService;
    private final LearningCategoryService categoryService;
    private final LearningDeliveryModeService deliveryModeService;
    private final LearningLevelService levelService;

    @Override
    public LearningResponse toDTO(Learning learning) {
        return new LearningResponse(
                learning.getId(),
                typeService.toDTO(learning.getType()),
                categoryService.toCompactDTO(learning.getCategory()),
                levelService.toDTO(learning.getLevel()),
                deliveryModeService.toDTO(learning.getDeliveryMode()),
                learning.getCode(),
                learning.getTitle(),
                learning.getDescription(),
                learning.getStartTime(),
                learning.getEndTime(),
                learning.getCapacity(),
                learning.getMandatory(),
                Optional.ofNullable(learning.getSessions())
                        .orElse(emptyList())
                        .stream()
                        .map(sessionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(learning.getStatus()),
                learning.getCreatedDate()

        );
    }

    @Override
    public LearningCompactResponse toCompactDTO(Learning learning) {
        return new LearningCompactResponse(
                learning.getId(),
                typeService.toDTO(learning.getType()),
                categoryService.toCompactDTO(learning.getCategory()),
                levelService.toDTO(learning.getLevel()),
                deliveryModeService.toDTO(learning.getDeliveryMode()),
                learning.getCode(),
                learning.getTitle(),
                learning.getDescription(),
                learning.getStartTime(),
                learning.getEndTime(),
                learning.getCapacity(),
                learning.getMandatory(),
                statusService.toCompactDTO(learning.getStatus()),
                learning.getCreatedDate()
        );
    }

    @Override
    public Learning toEntity(LearningRequest dto) {
        return mapToEntity(new Learning(), dto);
    }

    @Override
    public Learning toEntity(Learning learning, LearningRequest dto) {
        return mapToEntity(learning, dto);
    }

    private Learning mapToEntity(Learning learning, LearningRequest dto) {
        learning.setType(typeService.getById(dto.learningTypeId()));
        learning.setCategory(categoryService.getById(dto.learningCategoryId()));
        learning.setLevel(levelService.getById(dto.learningLevelId()));
        learning.setDeliveryMode(deliveryModeService.getById(dto.learningDeliveryModeId()));
        learning.setCode(dto.code());
        learning.setTitle(dto.title());
        learning.setDescription(dto.description());
        learning.setStartTime(dto.startTime());
        learning.setEndTime(dto.endTime());
        learning.setCapacity(dto.capacity());
        learning.setMandatory(dto.mandatory());
        learning.setStatus(statusService.getById(dto.statusId()));
        dto.sessions().forEach(session -> learning.addSession(sessionMapperService.toEntity(session)));
        return learning;
    }
}
