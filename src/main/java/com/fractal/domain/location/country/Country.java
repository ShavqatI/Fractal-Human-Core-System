package com.fractal.domain.location.country;

import com.fractal.domain.location.Location;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country", schema = "location_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country extends Location {

    @Column(name ="code",unique = true,length = 5)
    private String code;

    @Column(name ="iso_code",unique = true)
    private String isoCode;

    @Column(name = "phone_prefix")
    private String phonePrefix;

}
