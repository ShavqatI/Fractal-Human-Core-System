package com.fractal.domain.localization.language;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "language", schema = "localization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Language extends AbstractEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

}
