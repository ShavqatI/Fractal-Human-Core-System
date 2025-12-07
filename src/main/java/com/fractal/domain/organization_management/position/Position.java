package com.fractal.domain.organization_management.position;

import com.fractal.domain.abstraction.Lifecycle;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.grade.Grade;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "position", schema = "organization_schema", catalog = "fractal")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Position extends Lifecycle {

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @Column(name = "supervisory")
    private Boolean supervisory;

    private LocalDate cancelDate;
    private String cancelReason;
    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    protected User canceledUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

}
