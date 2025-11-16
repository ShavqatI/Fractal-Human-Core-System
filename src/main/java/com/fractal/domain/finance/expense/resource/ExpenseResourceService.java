package com.fractal.domain.finance.expense.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExpenseResourceService {

    ExpenseResource create(Long expenseId, MultipartFile file);

    List<ExpenseResource> getAllByExpenseId(Long expenseId);

    ExpenseResource getById(Long expenseId, Long id);

    ExpenseResource update(Long expenseId, Long id, MultipartFile file);

    void delete(Long expenseId, Long id);

    ResourceResponse toDTO(ExpenseResource resource);

}
