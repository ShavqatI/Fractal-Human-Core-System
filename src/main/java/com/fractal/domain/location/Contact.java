package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.ContactType;
import com.fractal.domain.dictionary.EntityType;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "contact", schema = "location_schema", catalog = "fractal")
public class Contact extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name ="entity_type_id", referencedColumnName = "id")
    private EntityType entityType;

    @Column(name = "entity_id")
    private Integer entity;

    @ManyToOne
    @JoinColumn(name ="contact_type_id", referencedColumnName = "id")
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(name ="status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "value")
    private String value;

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
