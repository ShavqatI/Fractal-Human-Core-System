package com.fractal.domain.location.city;


import com.fractal.domain.abstraction.Location;
import com.fractal.domain.location.district.District;
import com.fractal.domain.location.gender.AreaType;
import com.fractal.domain.location.region.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "city", schema = "location_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class City extends Location {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="region_id", referencedColumnName = "id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="area_type_id", referencedColumnName = "id")
    private AreaType areaType;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<District> districts = new ArrayList<>();
}
