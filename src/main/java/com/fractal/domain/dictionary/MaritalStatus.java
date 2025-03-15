package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "marital_status", schema = "dictionary_schema", catalog = "fractal")
public class MaritalStatus extends AbstractDictionary {



}
