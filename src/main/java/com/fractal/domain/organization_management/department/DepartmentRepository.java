package com.fractal.domain.organization_management.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findFirstByOrderByIdDesc();
    Optional<Department> findByCode(String code);

    List<Department> findAllByOrganizationUnitCode(String code);

}
