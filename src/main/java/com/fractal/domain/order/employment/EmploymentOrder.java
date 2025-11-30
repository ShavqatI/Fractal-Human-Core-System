package com.fractal.domain.order.employment;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.employment.record.EmploymentOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employment_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentOrder extends Order {

    @OneToMany(mappedBy = "employmentOrder", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<EmploymentOrderRecord> records = new ArrayList<>();

    public void addRecord(EmploymentOrderRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setEmploymentOrder(this);
        records.add(record);
    }

    public void removeRecord(EmploymentOrderRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }

}
