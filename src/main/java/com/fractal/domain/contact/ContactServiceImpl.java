package com.fractal.domain.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.type.ContactTypeService;
import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactTypeService contactTypeService;


    @Override
    public ContactResponse toDTO(Contact contact) {
        return new ContactResponse(
                contact.getId(),
                contact.getContactType().getName(),
                contact.getValue(),
                contact.getCreatedDate()
        );
    }

    @Override
    public Contact toEntity(ContactRequest dto) {
        return Contact.builder()
                .contactType(contactTypeService.getById(dto.contactTypeId()))
                .value(dto.value())
                .build();
    }
}
