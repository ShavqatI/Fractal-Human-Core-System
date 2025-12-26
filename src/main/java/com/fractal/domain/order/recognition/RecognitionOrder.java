package com.fractal.domain.order.recognition;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recognition_order", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RecognitionOrder extends Order {

    @OneToMany(mappedBy = "recognitionOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecognitionOrderRecord> records = new ArrayList<>();

    public void addRecord(RecognitionOrderRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setRecognitionOrder(this);
        records.add(record);
    }

    public void removeRecord(RecognitionOrderRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }

}
