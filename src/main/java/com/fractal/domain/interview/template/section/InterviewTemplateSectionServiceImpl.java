/*
package com.fractal.domain.interview.template.section;

import com.fractal.domain.interview.template.InterviewTemplateService;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionCompactResponse;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionRequest;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionResponse;
import com.fractal.domain.interview.template.section.mapper.InterviewTemplateSectionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewTemplateSectionServiceImpl implements InterviewTemplateSectionService {

    private final InterviewTemplateSectionRepository sectionRepository;
    private final InterviewTemplateSectionMapperService mapperService;
    private final InterviewTemplateService interviewTemplateService;


    @Override
    @Transactional
    public InterviewTemplateSection create(Long templateId, InterviewTemplateSectionRequest dto) {
        var template = interviewTemplateService.getById(templateId);
        var section = mapperService.toEntity(dto);
        template.addSection(section);
        interviewTemplateService.save(template);
       return section;
    }

    @Override
    public List<InterviewTemplateSection> getAllByInterviewTemplateId(Long templateId) {
        return sectionRepository.findAllByInterviewTemplateId(templateId);
    }

    @Override
    public InterviewTemplateSection getById(Long templateId, Long id) {
        return sectionRepository.findByInterviewTemplateIdAndId(templateId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public InterviewTemplateSection update(Long templateId, Long id, InterviewTemplateSectionRequest dto) {
        var template = interviewTemplateService.getById(templateId);
        var section = template.getSections()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        section = sectionRepository.save(mapperService.toEntity(section,dto));
        interviewTemplateService.save(template);
        return section;
    }

    @Override
    @Transactional
    public void delete(Long templateId, Long id) {
        var template = interviewTemplateService.getById(templateId);
        var section = template.getSections()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        template.removeSection(section);
        interviewTemplateService.save(template);
    }

    @Override
    public InterviewTemplateSectionResponse toDTO(InterviewTemplateSection section) {
        return mapperService.toDTO(section);
    }

    @Override
    public InterviewTemplateSectionCompactResponse toCompactDTO(InterviewTemplateSection section) {
        return mapperService.toCompactDTO(section);
    }

    @Override
    public InterviewTemplateSection addChild(Long id, InterviewTemplateSectionRequest dto) {
        var section = getById(id);
        var child = mapperService.toEntity(dto);
        section.addChild(child);
        return save(section);
    }

    @Override
    public InterviewTemplateSection updateChild(Long id, Long childId, InterviewTemplateSectionRequest dto) {
        var section = getById(id);
        var child = section.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceWithIdNotFoundException(this,childId));
        try {
            child = mapperService.toEntity(child,dto);
            save(child);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
        return save(section);
    }

    @Override
    public InterviewTemplateSection deleteChild(Long id, Long childId) {
        var section = getById(id);
        var child = section.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceWithIdNotFoundException(this,childId));
        section.removeChild(child);
        return section;
    }

    @Override
    public InterviewTemplateSection getById(Long id) {
        return sectionRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public InterviewTemplateSection save(InterviewTemplateSection section) {
        try {
            return sectionRepository.save(section);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
*/
