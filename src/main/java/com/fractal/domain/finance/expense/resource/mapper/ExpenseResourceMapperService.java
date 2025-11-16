package com.fractal.domain.finance.expense.resource.mapper;

import com.fractal.domain.finance.expense.resource.ExpenseResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ExpenseResourceMapperService {
    ResourceResponse toDTO(ExpenseResource resource);

    ExpenseResource toEntity(ResourceRequest dto);

    ExpenseResource toEntity(MultipartFile file, String url);

    ExpenseResource toEntity(ExpenseResource resource, ResourceRequest dto);

    ResourceRequest fileToRequest(MultipartFile file, String url);
}


