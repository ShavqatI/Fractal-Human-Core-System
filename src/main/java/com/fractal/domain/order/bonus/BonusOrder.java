package com.fractal.domain.order.bonus;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.bonus.record.BonusOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bonus_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BonusOrder extends Order {

    @OneToMany(mappedBy = "bonusOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BonusOrderRecord> records = new ArrayList<>();

    public void addRecord(BonusOrderRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setBonusOrder(this);
        records.add(record);
    }

    public void removeRecord(BonusOrderRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }

}
