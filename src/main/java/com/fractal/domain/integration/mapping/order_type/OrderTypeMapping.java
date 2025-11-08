package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.abstraction.Integration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_Type_mapping",schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OrderTypeMapping extends Integration {

}
