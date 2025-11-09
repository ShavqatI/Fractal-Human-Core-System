package com.fractal.domain.integration.mapping.order_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderTypeMappingRepository extends JpaRepository<OrderTypeMapping,Long> {

}
