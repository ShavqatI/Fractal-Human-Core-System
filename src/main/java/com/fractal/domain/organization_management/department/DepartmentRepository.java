package com.fractal.domain.organization_management.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department save(Department department);
    List<Department> findAll();
    Optional<Department> findByCode(String code);
    Optional<Department> findById(Long id);

}
