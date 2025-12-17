package com.fractal.domain.order.punishment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PunishmentOrderRepository extends JpaRepository<PunishmentOrder, Long> {

    List<PunishmentOrder> findAllByPunishmentId(Long punishmentId);

    Optional<PunishmentOrder> findByPunishmentIdAndId(Long punishmentId, Long id);
}
