package com.fractal.domain.learning_develpment.learning.platform;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.learning_develpment.learning.platform.type.OnlinePlatformType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "online_platform", schema = "ld_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OnlinePlatform extends Dictionary {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="online_platform_type_id",referencedColumnName = "id")
    private OnlinePlatformType onlinePlatformType;
}
