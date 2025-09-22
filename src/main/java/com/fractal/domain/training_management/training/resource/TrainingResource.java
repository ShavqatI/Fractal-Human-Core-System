package com.fractal.domain.training_management.training.resource;


import com.fractal.domain.resource.Resource;
import com.fractal.domain.training_management.training.Training;
import com.fractal.domain.training_management.training.resource.type.TrainingResourceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "training_resource",schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class TrainingResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_resource_type_id", referencedColumnName = "id")
    private TrainingResourceType trainingResourceType;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

}
