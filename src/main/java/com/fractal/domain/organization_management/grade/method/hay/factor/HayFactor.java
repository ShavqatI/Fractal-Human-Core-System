package com.fractal.domain.organization_management.grade.method.hay.factor;


import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.dictionary.measurement_unit.MeasurementUnit;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.HayFactorType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hay_factor", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class HayFactor extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hay_factor_type_id", referencedColumnName = "id")
    private HayFactorType hayFactorType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", referencedColumnName = "id")
    private MeasurementUnit measurementUnit;

    private String code;
    private String name;
    private String description;

    private Double minPoint;
    private Double maxPoint;
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


}
