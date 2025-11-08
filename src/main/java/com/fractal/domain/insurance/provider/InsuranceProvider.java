package com.fractal.domain.insurance.provider;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.insurance.provider.address.InsuranceProviderAddress;
import com.fractal.domain.insurance.provider.contact.InsuranceProviderContact;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insurance_provider", schema = "insurance_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InsuranceProvider extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "tin_number")
    private String tinNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "insuranceProvider", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InsuranceProviderContact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "insuranceProvider", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<InsuranceProviderAddress> addresses = new ArrayList<>();

    public void addContact(InsuranceProviderContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setInsuranceProvider(this);
        contacts.add(contact);
    }

    public void removeContact(InsuranceProviderContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

    @Transactional
    public void addAddress(InsuranceProviderAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setInsuranceProvider(this);
        addresses.add(address);
    }
    @Transactional
    public void removeAddress(InsuranceProviderAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }

    }
}
