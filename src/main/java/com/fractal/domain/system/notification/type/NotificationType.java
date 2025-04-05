package com.fractal.domain.system.notification.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notification_type", schema = "system_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationType extends Dictionary {

    @Column(name = "description")
    private String description;

}
