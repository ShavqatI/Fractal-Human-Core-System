package com.fractal.domain.education.language_skill.proficiency;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "language_proficiency", schema = "education_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class LanguageProficiency extends Dictionary {
}
