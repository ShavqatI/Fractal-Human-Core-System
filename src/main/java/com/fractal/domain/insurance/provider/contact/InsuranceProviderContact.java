package com.fractal.domain.insurance.provider.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "insurance_provider_contact", schema = "insurance_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InsuranceProviderContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_provider_id", referencedColumnName = "id")
    private InsuranceProvider insuranceProvider;

}
