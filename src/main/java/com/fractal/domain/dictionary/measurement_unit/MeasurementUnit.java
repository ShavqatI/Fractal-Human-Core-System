package com.fractal.domain.dictionary.measurement_unit;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "measurement_unit", schema = "dictionary_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MeasurementUnit extends Dictionary {

}
