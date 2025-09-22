package com.fractal.domain.training_management.training.location;


import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.training_management.training.Training;
import com.fractal.domain.training_management.training.location.type.TrainingLocationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "training_location", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class TrainingLocation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_location_type_id",referencedColumnName = "id")
    protected TrainingLocationType trainingLocationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    protected Training training;

    protected Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    protected Status status;
}
