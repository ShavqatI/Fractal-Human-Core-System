package com.fractal.domain.training_management.training.location.offline.internal;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.training_management.training.location.TrainingLocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_training_location", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalTrainingLocation extends TrainingLocation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id",referencedColumnName = "id")
    private Organization organization;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "floor_number")
    private String floorNumber;

    @Column(name = "room_number")
    private String roomNumber;
}
