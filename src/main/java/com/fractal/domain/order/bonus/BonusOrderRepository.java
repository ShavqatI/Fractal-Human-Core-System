package com.fractal.domain.order.bonus;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusOrderRepository extends JpaRepository<BonusOrder, Long> {


}
