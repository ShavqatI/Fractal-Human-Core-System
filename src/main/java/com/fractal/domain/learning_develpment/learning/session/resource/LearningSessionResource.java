package com.fractal.domain.learning_develpment.learning.session.resource;


import com.fractal.domain.learning_develpment.learning.session.LearningSession;
import com.fractal.domain.learning_develpment.learning.session.resource.type.LearningSessionResourceType;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "learning_session_resource",schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class LearningSessionResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_session_resource_type_id", referencedColumnName = "id")
    private LearningSessionResourceType learningSessionResourceType;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_session_id", referencedColumnName = "id")
    private LearningSession learningSession;

}
