package com.fractal.domain.dictionary;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "status", schema = "dictionary_schema", catalog = "fractal")
public class Status extends Dictionary {


    private String description;
    private String group;


    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "`group`")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


}
