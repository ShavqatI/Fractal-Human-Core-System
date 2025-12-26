package com.fractal.domain.learning_develpment.learning.session.location.offline.address;


import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "offline_learning_location_address", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OfflineLearningLocationAddress extends Address {

    @Column(name = "room_number")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "offline_learning_location_id", referencedColumnName = "id")
    private OfflineLearningLocation offlineLearningLocation;


}
