package com.fractal.domain.employee_management.business_trip.location;


import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.location.address.BusinessTripLocationAddress;
import com.fractal.domain.employee_management.business_trip.location.type.BusinessTripLocationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_trip_location", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessTripLocation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_location_type_id",referencedColumnName = "id")
    protected BusinessTripLocationType businessTripLocationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_id", referencedColumnName = "id")
    protected BusinessTrip businessTrip;

    protected LocalDateTime startTime;

    protected LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    protected Status status;

    @OneToMany(mappedBy = "businessTripLocation", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BusinessTripLocationAddress> addresses = new ArrayList<>();

    public void addAddress(BusinessTripLocationAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setBusinessTripLocation(this);
        addresses.add(address);
    }
    public void removeAddress(BusinessTripLocationAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }
    }
}
