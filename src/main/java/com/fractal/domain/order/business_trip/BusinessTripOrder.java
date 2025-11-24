package com.fractal.domain.order.business_trip;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_trip_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTripOrder extends Order {

    @Column(name = "start_date")
    protected LocalDate startDate;

    @Column(name = "end_date")
    protected LocalDate endDate;

    @Column(name = "days")
    protected Integer days;

    @OneToMany(mappedBy = "businessTripOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BusinessTripOrderRecord> records = new ArrayList<>();

    public void addRecord(BusinessTripOrderRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setBusinessTripOrder(this);
        records.add(record);
    }

    public void removeRecord(BusinessTripOrderRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }

}
