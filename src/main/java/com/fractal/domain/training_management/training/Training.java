package com.fractal.domain.training_management.training;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.training_management.training.expense.TrainingExpense;
import com.fractal.domain.training_management.training.location.TrainingLocation;
import com.fractal.domain.training_management.training.participation.participant.TrainingParticipation;
import com.fractal.domain.training_management.training.participation.trainer.TrainerAssignment;
import com.fractal.domain.training_management.training.resource.TrainingResource;
import com.fractal.domain.training_management.training.type.TrainingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training", schema = "training_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Training extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_type_id", referencedColumnName = "id")
    private TrainingType trainingType;

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TrainerAssignment> trainerAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TrainingParticipation> participations = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TrainingResource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TrainingExpense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TrainingLocation> locations = new ArrayList<>();

    public void addTrainerAssignment(TrainerAssignment trainerAssignment) {
        if (trainerAssignments == null) trainerAssignments = new ArrayList<>();
        trainerAssignment.setTraining(this);
        trainerAssignments.add(trainerAssignment);
    }
    public void removeTrainerAssignment(TrainerAssignment trainerAssignment) {
        if (trainerAssignments != null && !trainerAssignments.isEmpty())
            trainerAssignments.remove(trainerAssignment);
    }

    public void addTrainingParticipation(TrainingParticipation trainingParticipation) {
        if (participations == null) participations = new ArrayList<>();
        trainingParticipation.setTraining(this);
        participations.add(trainingParticipation);
    }
    public void removeTrainingParticipation(TrainingParticipation trainingParticipation) {
        if (participations != null && !participations.isEmpty())
            participations.remove(trainingParticipation);
    }


    public void addResource(TrainingResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setTraining(this);
        resources.add(resource);
    }
    public void removeResource(TrainingResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

    public void addExpense(TrainingExpense expense) {
        if (expenses == null) expenses = new ArrayList<>();
        expense.setTraining(this);
        expenses.add(expense);
    }
    public void removeExpense(TrainingExpense expense) {
        if (expenses != null && !expenses.isEmpty())
            expenses.remove(expense);
    }
    public void addLocation(TrainingLocation location) {
        if (locations == null) locations = new ArrayList<>();
        location.setTraining(this);
        locations.add(location);
    }
    public void removeLocation(TrainingLocation location) {
        if (locations != null && !locations.isEmpty())
            locations.remove(location);
    }

}
