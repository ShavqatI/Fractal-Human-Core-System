package com.fractal.domain.finance.expense.resource;

import com.fractal.domain.finance.expense.ExpenseService;
import com.fractal.domain.finance.expense.resource.mapper.ExpenseResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseResourceServiceImpl implements ExpenseResourceService {

    private final ExpenseResourceRepository resourceRepository;
    private final ExpenseResourceMapperService resourceMapperService;
    private final ExpenseService expenseService;

    @Override
    public ExpenseResource create(Long expenseId, MultipartFile file) {
        var expense = expenseService.getById(expenseId);
        var resource = resourceMapperService.toEntity(file,null);
        expense.addResource(resource);
        expenseService.save(expense);
        return resource;
    }

    @Override
    public List<ExpenseResource> getAllByExpenseId(Long expenseId) {
        return resourceRepository.findAllByExpenseId(expenseId);
    }

    @Override
    public ExpenseResource getById(Long expenseId, Long id) {
        return resourceRepository.findByExpenseIdAndId(expenseId,id).orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource with id: " + id + " not found"));
    }

    @Override
    public ExpenseResource update(Long expenseId, Long id, MultipartFile file) {
        var expense = expenseService.getById(expenseId);
        var resource = expense.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        expenseService.save(expense);
        return resource;
    }

    @Override
    public void delete(Long expenseId, Long id) {
        var expense = expenseService.getById(expenseId);
        var resource = expense.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resourceRepository.delete(resource);
        expenseService.save(expense);
    }

    @Override
    public ResourceResponse toDTO(ExpenseResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
