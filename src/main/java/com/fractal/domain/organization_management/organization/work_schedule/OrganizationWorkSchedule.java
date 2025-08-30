package com.fractal.domain.organization_management.organization.work_schedule;


import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.work_schedule.WorkSchedule;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "work_schedule",schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class OrganizationWorkSchedule extends WorkSchedule {

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

}
