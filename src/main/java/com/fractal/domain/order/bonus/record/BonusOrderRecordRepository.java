package com.fractal.domain.order.bonus.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BonusOrderRecordRepository extends JpaRepository<BonusOrderRecord, Long> {

    List<BonusOrderRecord> findAllByBonusOrderId(Long orderId);

    Optional<BonusOrderRecord> findByBonusOrderIdAndId(Long orderId, Long id);
}
