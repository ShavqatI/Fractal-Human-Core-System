package com.fractal.domain.military_service.resource;


import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "military_service_resource",schema = "military_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MilitaryServiceResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "military_service_id", referencedColumnName = "id")
    private MilitaryService militaryService;

}
