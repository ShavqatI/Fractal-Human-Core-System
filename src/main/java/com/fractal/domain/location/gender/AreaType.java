package com.fractal.domain.location.gender;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.abstraction.Location;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "area_type", schema = "location_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class AreaType extends Location {

}
