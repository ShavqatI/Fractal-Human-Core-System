package com.fractal.domain.dictionary;


import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "boolean_type", schema = "dictionary_schema", catalog = "fractal")
public class BooleanType extends AbstractDictionary {

    @Column(name = "value")
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
