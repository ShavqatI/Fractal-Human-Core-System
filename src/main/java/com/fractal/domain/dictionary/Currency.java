package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import com.fractal.domain.location.Country;
import jakarta.persistence.*;

@Entity
@Table(name = "currency", schema = "dictionary_schema", catalog = "fractal")
public class Currency extends AbstractDictionary {

    @Column(name ="short_name",length = 5)
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country countryId) {
        this.country = countryId;
    }
}
