package com.fractal.domain.location.country;

import com.fractal.domain.abstraction.Location;
import com.fractal.domain.location.region.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country", schema = "location_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Country extends Location {

    @Column(name = "iso3_code", unique = true, length = 3)
    private String iso3Code;

    @Column(name = "phone_prefix", nullable = false)
    private String phonePrefix;

    @Column(name = "numeric_code", unique = true)
    private Integer numericCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Region> regions = new ArrayList<>();

}
