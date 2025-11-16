package com.fractal.domain.finance.expense.type;

import com.fractal.domain.finance.expense.type.category.ExpenseTypeCategoryService;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeRequest;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

    private final ExpenseTypeRepository expenseTypeRepository;
    private final ExpenseTypeCategoryService expenseTypeCategoryService;

    @Override
    public ExpenseType create(ExpenseTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ExpenseType> getAll() {
        return expenseTypeRepository.findAll();
    }

    @Override
    public ExpenseType getByCode(String code) {
        return expenseTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Status with code: " + code + " not found"));

    }

    @Override
    public ExpenseType getById(Long id) {
        return findById(id);
    }

    @Override
    public ExpenseType update(Long id, ExpenseTypeRequest dto) {
        try {
            ExpenseType expenseType = findById(id);
            expenseType.setCode(dto.code());
            expenseType.setName(dto.name());
            expenseType.setExpenseTypeCategory(expenseTypeCategoryService.getById(dto.categoryId()));
            expenseType.setDescription(dto.description());
            return save(expenseType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        expenseTypeRepository.delete(findById(id));
    }

    @Override
    public ExpenseTypeResponse toDTO(ExpenseType expenseType) {
        return new ExpenseTypeResponse(
                expenseType.getId(),
                expenseType.getCode(),
                expenseType.getName(),
                expenseTypeCategoryService.toDTO(expenseType.getExpenseTypeCategory()),
                expenseType.getDescription(),
                expenseType.getCreatedDate()
        );
    }

    @Override
    public ExpenseTypeCompactResponse toCompactDTO(ExpenseType expenseType) {
        return new ExpenseTypeCompactResponse(
                expenseType.getId(),
                expenseType.getCode(),
                expenseType.getName()
        );
    }

    private ExpenseType toEntity(ExpenseTypeRequest dto) {
        return ExpenseType.builder()
                .code(dto.code())
                .name(dto.name())
                .expenseTypeCategory(expenseTypeCategoryService.getById(dto.categoryId()))
                .description(dto.description())
                .build();
    }

    private ExpenseType save(ExpenseType expenseType) {
        try {
            return expenseTypeRepository.save(expenseType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExpenseType findById(Long id) {
        return expenseTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Status with id: " + id + " not found"));
    }

}
