package com.fractal.domain.finance.expense.resource.mapper;

import com.fractal.domain.finance.expense.resource.ExpenseResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class ExpenseResourceMapperServiceImpl implements ExpenseResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(ExpenseResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public ExpenseResource toEntity(ResourceRequest dto) {
        return (ExpenseResource) mapperService.toEntity(dto);
    }

    @Override
    public ExpenseResource toEntity(MultipartFile file, String url) {
        return (ExpenseResource) mapperService.toEntity(file,url);
    }

    @Override
    public ExpenseResource toEntity(ExpenseResource resource, ResourceRequest dto) {
        return (ExpenseResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
