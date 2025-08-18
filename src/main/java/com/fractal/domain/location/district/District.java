package com.fractal.domain.location.district;

import com.fractal.domain.abstraction.Location;
import com.fractal.domain.location.city.City;
import com.fractal.domain.location.gender.AreaType;
import com.fractal.domain.location.region.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "district", schema = "location_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class District extends Location {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="region_id", referencedColumnName = "id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="area_type_id", referencedColumnName = "id")
    private AreaType areaType;
}
