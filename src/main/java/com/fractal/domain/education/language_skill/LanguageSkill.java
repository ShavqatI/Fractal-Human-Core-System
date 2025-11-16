package com.fractal.domain.education.language_skill;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.education.language_skill.proficiency.LanguageProficiency;
import com.fractal.domain.localization.language.Language;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "language_skill", schema = "education_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class LanguageSkill extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    protected Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_proficiency_id", referencedColumnName = "id")
    protected LanguageProficiency languageProficiency;
}
