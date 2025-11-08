package com.fractal.domain.integration.mapping.order_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DocumentTemplateManagerRepository extends JpaRepository<OrderTypeMapping,Long> {
    Optional<OrderTypeMapping> findById(Long id);
    Optional<OrderTypeMapping> findByCode(String code);
    List<OrderTypeMapping> findAll();
}
