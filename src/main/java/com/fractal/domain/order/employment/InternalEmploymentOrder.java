package com.fractal.domain.order.employment;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.employment.record.InternalEmploymentOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "internal_employment_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentOrder extends Order {

    @OneToMany(mappedBy = "internalEmploymentOrder", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<InternalEmploymentOrderRecord> records = new ArrayList<>();

    public void addRecord(InternalEmploymentOrderRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setInternalEmploymentOrder(this);
        records.add(record);
    }

    public void removeRecord(InternalEmploymentOrderRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }

}
