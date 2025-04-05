package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "currency", schema = "dictionary_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends Dictionary {

    @Column(name ="short_name",length = 5)
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
