package com.fractal.domain.employee_management.vacation;

import com.fractal.domain.dictionary.Status;
import com.fractal.domain.dictionary.VacationCategory;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.VacationType;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "vacation", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "successor_employee_id", referencedColumnName = "id")
    private Employee successorEmployee;

    @ManyToOne
    @JoinColumn(name = "vacation_category_id", referencedColumnName = "id")
    private VacationCategory vacationCategory;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id", referencedColumnName = "id")
    private VacationType vacationType;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "description")
    private String description;

}
