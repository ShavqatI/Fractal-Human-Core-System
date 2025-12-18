package com.fractal.domain.system.message;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.language.Language;
import com.fractal.domain.system.message.type.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "message", schema = "system_schema", catalog = "fractal")
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Message extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_type_id", referencedColumnName = "id")
    private MessageType messageType;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;
}
