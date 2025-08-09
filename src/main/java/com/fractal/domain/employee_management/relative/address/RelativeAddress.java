package com.fractal.domain.employee_management.relative.address;


import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "relative_address", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class RelativeAddress extends Address {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="relative_id", referencedColumnName = "id")
    private Relative relative;
}
