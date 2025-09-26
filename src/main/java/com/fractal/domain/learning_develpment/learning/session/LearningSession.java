package com.fractal.domain.learning_develpment.learning.session;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.learning_develpment.learning.Learning;
import com.fractal.domain.learning_develpment.learning.delivery_mode.LearningDeliveryMode;
import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import com.fractal.domain.learning_develpment.learning.session.enrollment.LearningSessionEnrollment;
import com.fractal.domain.learning_develpment.learning.session.expense.LearningSessionExpense;
import com.fractal.domain.learning_develpment.learning.session.instructor.InstructorAssignment;
import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResource;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "learning_session", schema = "ld_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class LearningSession extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_id",referencedColumnName = "id")
    protected Learning learning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_delivery_mode_id",referencedColumnName = "id")
    protected LearningDeliveryMode deliveryMode;

    protected LocalDateTime startTime;
    protected LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    protected Status status;

    @OneToMany(mappedBy = "learningSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InstructorAssignment> instructorAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "learningSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<LearningSessionEnrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "learningSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    public List<LearningSessionResource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "learningSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<LearningSessionExpense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "learningSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<LearningLocation> locations = new ArrayList<>();

    public void addInstructorAssignment(InstructorAssignment instructorAssignment) {
        if (instructorAssignments == null) instructorAssignments = new ArrayList<>();
        instructorAssignment.setLearningSession(this);
        instructorAssignments.add(instructorAssignment);
    }
    public void removeInstructorAssignment(InstructorAssignment instructorAssignment) {
        if (instructorAssignments != null && !instructorAssignments.isEmpty())
            instructorAssignments.remove(instructorAssignment);
    }

    public void addEnrollment(LearningSessionEnrollment enrollment) {
        if (enrollments == null) enrollments = new ArrayList<>();
        enrollment.setLearningSession(this);
        enrollments.add(enrollment);
    }
    public void removeEnrollment(LearningSessionEnrollment enrollment) {
        if (enrollments != null && !enrollments.isEmpty())
            enrollments.remove(enrollment);
    }

    public void addResource(LearningSessionResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setLearningSession(this);
        resources.add(resource);
    }
    public void removeResource(LearningSessionResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

    public void addExpense(LearningSessionExpense expense) {
        if (expenses == null) expenses = new ArrayList<>();
        expense.setLearningSession(this);
        expenses.add(expense);
    }
    public void removeExpense(LearningSessionExpense expense) {
        if (expenses != null && !expenses.isEmpty())
            expenses.remove(expense);
    }

    public void addLocation(LearningLocation location) {
        if (locations == null) locations = new ArrayList<>();
        location.setLearningSession(this);
        locations.add(location);
    }
    public void removeLocation(LearningLocation location) {
        if (locations != null && !locations.isEmpty())
            locations.remove(location);
    }
}
