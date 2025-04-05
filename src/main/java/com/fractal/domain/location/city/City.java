package com.fractal.domain.location.city;


import com.fractal.domain.location.Location;
import com.fractal.domain.location.region.Region;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "city", schema = "location_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City extends Location {

    @ManyToOne
    @JoinColumn(name ="region_id", referencedColumnName = "id")
    private Region region;
}
