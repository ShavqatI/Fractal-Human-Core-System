package com.fractal.domain.training_management.training.location.offline.external.address;


import com.fractal.domain.location.address.Address;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.training_management.training.location.offline.external.ExternalTrainingLocation;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "external_trainer_location_address", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExternalTrainingLocationAddress extends Address {

    @ManyToOne
    @JoinColumn(name ="organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name ="external_training_location_id", referencedColumnName = "id")
    private ExternalTrainingLocation externalTrainingLocation;


}
