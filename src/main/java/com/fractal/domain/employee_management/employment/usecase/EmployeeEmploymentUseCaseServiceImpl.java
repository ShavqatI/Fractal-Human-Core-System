package com.fractal.domain.employee_management.employment.usecase;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.Hire;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentUseCaseServiceImpl implements EmployeeEmploymentUseCaseService {
    private final EmployeeEmploymentService employeeEmploymentService;
    private final InternalEmploymentService internalEmploymentService;
    private final EmploymentService employmentService;
    private final StatusService statusService;
    private final PositionService positionService;
    private final EmployeeUseCaseService employeeUseCaseService;


    @Override
    public Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee) {
        List<EmployeeEmployment> employeeEmployments = employeeEmploymentService.getAllByEmployeeId(employee.getId());
        var response = employeeEmployments.stream().map(employeeEmployment -> (EmployeeEmployment) Hibernate.unproxy(employeeEmployment))
                .map(employeeEmployment -> employmentService.getById(employeeEmployment.getEmployment().getId()) )
                .map(employment -> (Employment) Hibernate.unproxy(employment))
                .filter(employment -> employment.getEndDate() == null
                                && statusService.getById(employment.getStatus().getId()).getCode().equals("ACTIVE")
                                && employment instanceof InternalEmployment
                ).findFirst().map(employment-> internalEmploymentService.toDTO((InternalEmployment) employment));
        return response;
    }

    @Override
    public Employee getHrHeadEmployee() {
       return getEmployeeByPosition("HR_HEAD");
    }

    @Override
    public Employee getCEOEmployee() {
        return getEmployeeByPosition("CEO");
    }

    private Employee getEmployeeByPosition(String positionCode){
        var employee = employeeEmploymentService.getAllActive().stream().filter(
                        employeeEmployment -> filterInternalEmployment(employeeEmployment))
                .filter(employeeEmployment ->
                        filterPosition(getInternalEmployment(employeeEmployment),positionCode)
                ).map(employeeEmployment -> employeeEmployment.getEmployee());
        return employee.findFirst().get();
    }

    private boolean filterInternalEmployment(EmployeeEmployment employeeEmployment) {
        employeeEmployment = (EmployeeEmployment) Hibernate.unproxy(employeeEmployment);
        var employment = (Employment) Hibernate.unproxy(employmentService.getById(employeeEmployment.getEmployment().getId()));
        if(employment instanceof InternalEmployment) return true;
        else return false;
    }
    private boolean filterPosition(InternalEmployment employment,String positionCode) {
        var position = positionService.getById(employment.getPosition().getId());
        return position.getCode().equals(positionCode) ? true : false;
    }

    private boolean filterActiveInternalEmployment(InternalEmployment employment){
        if (employment.getEndDate() == null && statusService.getById(employment.getStatus().getId()).getCode().equals("ACTIVE"))
            return true;
        return false;
    }

    private InternalEmployment getInternalEmployment(EmployeeEmployment employeeEmployment){
        if(filterInternalEmployment(employeeEmployment)) {
            var employment = (Employment) Hibernate.unproxy(employmentService.getById(employeeEmployment.getEmployment().getId()));
            return internalEmploymentService.getById(employment.getId());
        }
        return null;
    }

    @Override
    public void hire(Long employeeId, Hire dto) {
        employeeEmploymentService.create(employeeId,
                new InternalEmploymentRequest(
                        dto.getOrganizationId(),
                        dto.getDepartmentId(),
                        dto.getPositionId(),
                        dto.getEmploymentTypeId(),
                        dto.getStartDate(),
                        dto.getEndDate(),
                        List.of(),
                        List.of(),
                        dto.getCompensationComponents(),
                        statusService.getByCode("CREATED").getId()
                )
        );
    }
}
