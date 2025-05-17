package com.fractal.domain.employee_management.relative.address;


import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "relative_address", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelativeAddress extends Address {

    @ManyToOne
    @JoinColumn(name ="relative_id", referencedColumnName = "id")
    private Relative relative;
}
