package com.fractal.domain.insurance.provider.address;


import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "insurance_provider_address", schema = "insurance_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class InsuranceProviderAddress extends Address {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="insurance_provider_id", referencedColumnName = "id")
    private InsuranceProvider insuranceProvider;
}
