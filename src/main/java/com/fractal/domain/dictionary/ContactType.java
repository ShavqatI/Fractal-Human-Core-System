package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_type", schema = "dictionary_schema", catalog = "fractal")
public class ContactType extends AbstractDictionary {
}
