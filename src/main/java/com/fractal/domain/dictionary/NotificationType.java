package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_type", schema = "dictionary_schema", catalog = "fractal")
public class NotificationType extends AbstractDictionary {

    @Basic
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
