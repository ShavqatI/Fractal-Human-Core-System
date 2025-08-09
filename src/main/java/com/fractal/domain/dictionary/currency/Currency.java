package com.fractal.domain.dictionary.currency;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "currency", schema = "dictionary_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Currency extends Dictionary {

    @Column(name ="numeric_code",length = 5)
    private Integer numericCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
