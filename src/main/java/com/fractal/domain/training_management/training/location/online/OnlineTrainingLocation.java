package com.fractal.domain.training_management.training.location.online;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.training_management.training.location.TrainingLocation;
import com.fractal.domain.training_management.training.location.online.platform.OnlinePlatform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "online_training_location", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OnlineTrainingLocation extends TrainingLocation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "online_platform_id",referencedColumnName = "id")
    private OnlinePlatform onlinePlatform;

    @Column(name = "building_name")
    private String link;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
