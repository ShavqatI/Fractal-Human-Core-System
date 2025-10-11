package com.fractal.domain.learning_develpment.learning.session.location.online;

import com.fractal.domain.learning_develpment.learning.platform.OnlinePlatform;
import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "online_learning_location", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OnlineLearningLocation extends LearningLocation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "online_platform_id",referencedColumnName = "id")
    private OnlinePlatform onlinePlatform;

    @Column(name = "url")
    private String ulr;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
