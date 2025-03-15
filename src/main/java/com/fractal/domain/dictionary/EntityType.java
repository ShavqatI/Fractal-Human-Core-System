package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "entity_type", schema = "dictionary_schema", catalog = "fractal")
public class EntityType extends AbstractDictionary {

    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
