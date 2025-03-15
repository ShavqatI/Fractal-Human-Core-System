package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.AbstractDictionary;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_template", schema = "dictionary_schema", catalog = "fractal")
public class NotificationTemplate extends AbstractDictionary {

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "key_words")
    private String keyWords;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
