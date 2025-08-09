package com.fractal.domain.dictionary.status;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.status.category.StatusCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "status", schema = "dictionary_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Status extends Dictionary {

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_category_id", referencedColumnName = "id")
    private StatusCategory statusCategory;
}
