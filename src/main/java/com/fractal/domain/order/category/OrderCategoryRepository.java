package com.fractal.domain.order.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface OrderCategoryRepository extends JpaRepository<OrderCategory, Long> {
    Optional<OrderCategory> findByCode(String code);

}
