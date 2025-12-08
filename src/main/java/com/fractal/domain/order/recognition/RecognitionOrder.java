package com.fractal.domain.order.recognition;

import com.fractal.domain.order.Order;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recognition_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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
