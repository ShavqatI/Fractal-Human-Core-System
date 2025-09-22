package com.fractal.domain.training_management.training.location.offline.external;

import com.fractal.domain.training_management.training.location.TrainingLocation;
import com.fractal.domain.training_management.training.location.offline.external.address.ExternalTrainingLocationAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "external_training_location", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalTrainingLocation extends TrainingLocation {

    @OneToMany(mappedBy = "externalTrainingLocation", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ExternalTrainingLocationAddress> addresses = new ArrayList<>();

    public void addAddress(ExternalTrainingLocationAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setExternalTrainingLocation(this);
        addresses.add(address);
    }
    public void removeAddress(ExternalTrainingLocationAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }
    }
}
