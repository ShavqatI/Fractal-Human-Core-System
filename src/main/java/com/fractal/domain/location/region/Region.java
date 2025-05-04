package com.fractal.domain.location.region;


import com.fractal.domain.abstraction.Location;
import com.fractal.domain.location.city.City;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region", schema = "location_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Region extends Location {

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<City> cities = new ArrayList<>();

}
