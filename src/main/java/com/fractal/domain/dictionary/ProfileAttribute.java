package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile_attribute", schema = "dictionary_schema", catalog = "fractal")
public class ProfileAttribute extends Dictionary {

}
