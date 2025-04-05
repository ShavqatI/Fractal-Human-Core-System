package com.fractal.domain.system.service_provider.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_provider_type", schema = "system_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderType extends Dictionary {

    @Column(name = "description")
    private String description;
}
