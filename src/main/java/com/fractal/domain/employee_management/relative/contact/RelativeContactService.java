package com.fractal.domain.employee_management.relative.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface RelativeContactService {
    RelativeContact create(Long relativeId, ContactRequest dto);

    List<RelativeContact> getAllByRelativeId(Long relativeId);

    RelativeContact getById(Long relativeId, Long id);

    RelativeContact update(Long relativeId, Long id, ContactRequest dto);

    void delete(Long relativeId, Long id);

    ContactResponse toDTO(RelativeContact contact);
}
