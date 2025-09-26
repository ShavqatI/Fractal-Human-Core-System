package com.fractal.domain.learning_develpment.learning.session.location.offline;

import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.OfflineLearningLocationAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offline_learning_location", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OfflineLearningLocation extends LearningLocation {

    @OneToMany(mappedBy = "offlineLearningLocation", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OfflineLearningLocationAddress> addresses = new ArrayList<>();

    public void addAddress(OfflineLearningLocationAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setOfflineLearningLocation(this);
        addresses.add(address);
    }
    public void removeAddress(OfflineLearningLocationAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }
    }
}
