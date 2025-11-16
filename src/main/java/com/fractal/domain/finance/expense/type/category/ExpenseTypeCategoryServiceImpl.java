package com.fractal.domain.finance.expense.type.category;

import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryRequest;
import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class ExpenseTypeCategoryServiceImpl implements ExpenseTypeCategoryService {

    private final ExpenseTypeCategoryRepository expenseTypeCategoryRepository;

    @Override
    public ExpenseTypeCategory create(ExpenseTypeCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ExpenseTypeCategory> getAll() {
        return expenseTypeCategoryRepository.findAll();
    }

    @Override
    public ExpenseTypeCategory getByCode(String code) {
        return expenseTypeCategoryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Status Category with code: " + code + " not found"));

    }

    @Override
    public ExpenseTypeCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public ExpenseTypeCategory update(Long id, ExpenseTypeCategoryRequest dto) {
        try {
            ExpenseTypeCategory expenseTypeCategory = findById(id);
            expenseTypeCategory.setCode(dto.code());
            expenseTypeCategory.setName(dto.name());
            return save(expenseTypeCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        expenseTypeCategoryRepository.delete(findById(id));
    }

    @Override
    public ExpenseTypeCategoryResponse toDTO(ExpenseTypeCategory expenseTypeCategory) {
        return new ExpenseTypeCategoryResponse(
                expenseTypeCategory.getId(),
                expenseTypeCategory.getCode(),
                expenseTypeCategory.getName(),
                expenseTypeCategory.getCreatedDate()
        );
    }


    private ExpenseTypeCategory toEntity(ExpenseTypeCategoryRequest dto) {
        return ExpenseTypeCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private ExpenseTypeCategory save(ExpenseTypeCategory expenseTypeCategory) {
        try {
            return expenseTypeCategoryRepository.save(expenseTypeCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExpenseTypeCategory findById(Long id) {
        return expenseTypeCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Status Category with id: " + id + " not found"));
    }

}
