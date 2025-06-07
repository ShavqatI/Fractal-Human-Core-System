package com.fractal.domain.employee_management.military_service.resource;


import com.fractal.domain.employee_management.military_service.MilitaryService;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "military_service_resource",schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class MilitaryServiceResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "military_service_id", referencedColumnName = "id")
    private MilitaryService militaryService;

}
