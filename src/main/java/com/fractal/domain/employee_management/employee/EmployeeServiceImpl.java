package com.fractal.domain.employee_management.employee;

import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employee.mapper.EmployeeMapperService;
import com.fractal.domain.employee_management.employee.resource.EmployeeResourceService;
import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmploymentHistoryService employmentHistoryService;
    private final EmployeeResourceService resourceService;
    private final EmployeeMapperService employeeMapperService;

    @Override
    @Transactional
    public Employee create(EmployeeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getByTin(String tin) {
        return employeeRepository.findByTin(tin).orElseThrow(() -> new ResourceNotFoundException("Employee with tin: " + tin + " not found"));
    }

    @Override
    public Employee getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Employee update(Long id, EmployeeRequest dto) {
        var employee = employeeMapperService.toEntity(findById(id),dto);
        return employee;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      employeeRepository.delete(findById(id));
    }

    @Override
    public EmployeeResponse toDTO(Employee employee) {
       return employeeMapperService.toDTO(employee);
    }

    private Employee toEntity(EmployeeRequest dto) {
        return employeeMapperService.toEntity(dto);
    }

    @Override
    @Transactional
    public Employee addEmploymentHistory(Long id, EmploymentHistoryRequest dto) {
        var employee = findById(id);
        employee.addEmploymentHistory(employmentHistoryService.toEntity(dto));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmploymentHistory(Long id, Long employmentHistoryId, EmploymentHistoryRequest dto) {
        var employee = findById(id);
        var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(employmentHistoryId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + employmentHistoryId + " not found"));
        employmentHistoryService.update(employmentHistory.getId(),dto);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmploymentHistory(Long id, Long employmentHistoryId) {
        var employee = findById(id);
        var employmentHistory = employee.getEmploymentHistories()
                .stream()
                .filter(eh-> eh.getId().equals(employmentHistoryId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + employmentHistoryId + " not found"));
        employee.removeEmploymentHistory(employmentHistory);
        employmentHistoryService.delete(employmentHistory);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee addResource(Long id, MultipartFile file, String url) {
        var employee = findById(id);
        var resource = resourceService.toEntity(file,url);
        employee.addResource(resource);
        return save(employee);
    }

    @Override
    @Transactional
    public Employee updateResource(Long id, Long resourceId, MultipartFile file) {
        var employee = findById(id);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(employee);
    }

    @Override
    @Transactional
    public Employee deleteResource(Long id, Long resourceId) {
        var employee = findById(id);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + resourceId + " not found"));
        employee.removeResource(resource);
        resourceService.delete(resource);
        return save(employee);
    }

    @Override
    public Employee save(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found"));
    }
}