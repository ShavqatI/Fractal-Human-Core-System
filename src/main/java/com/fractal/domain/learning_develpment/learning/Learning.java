package com.fractal.domain.learning_develpment.learning;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.learning_develpment.learning.category.LearningCategory;
import com.fractal.domain.learning_develpment.learning.delivery_mode.LearningDeliveryMode;
import com.fractal.domain.learning_develpment.learning.level.LearningLevel;
import com.fractal.domain.learning_develpment.learning.session.LearningSession;
import com.fractal.domain.learning_develpment.learning.type.LearningType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "learning", schema = "ld_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Learning extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String code;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_type_id", referencedColumnName = "id")
    private LearningType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_category_id", referencedColumnName = "id")
    private LearningCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_level_id", referencedColumnName = "id")
    private LearningLevel level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_delivery_mode_id", referencedColumnName = "id")
    private LearningDeliveryMode deliveryMode;

    private Boolean mandatory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "learning", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LearningSession> sessions = new ArrayList<>();

    public void addSession(LearningSession session) {
        if (sessions == null) sessions = new ArrayList<>();
        session.setLearning(this);
        sessions.add(session);
    }

    public void removeSession(LearningSession session) {
        if (sessions != null && !sessions.isEmpty())
            sessions.remove(session);
    }
}
