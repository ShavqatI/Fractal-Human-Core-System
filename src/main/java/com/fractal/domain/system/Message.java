package com.fractal.domain.system;

import com.fractal.domain.localization.language.Language;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.MessageType;
import jakarta.persistence.*;

@Entity
@Table(name = "message", schema = "system_schema", catalog = "fractal")
public class Message extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "message_type_id", referencedColumnName = "id")
    private MessageType messageType;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code",unique = true)
    private String code;
    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
