package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.abstraction.Integration;
import com.fractal.domain.order.type.OrderType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_type_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OrderTypeMapping extends Integration {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_type_id",updatable = false,referencedColumnName = "id")
    protected OrderType orderType;

}
