package com.fractal.domain.employee_management.relative;


import com.fractal.domain.abstraction.Person;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.relative.address.RelativeAddress;
import com.fractal.domain.employee_management.relative.contact.RelativeContact;
import com.fractal.domain.employee_management.relative.type.RelationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "relative", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Relative extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relation_type_id", referencedColumnName = "id")
    private RelationType relationType;

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelativeAddress> addresses   = new ArrayList<>();

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelativeContact> contacts   = new ArrayList<>();

    public void addAddress(RelativeAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setRelative(this);
        addresses.add(address);
    }
    public void removeAddress(RelativeAddress address) {
        if (addresses != null && !addresses.isEmpty())
            addresses.remove(address);
    }

    public void addContact(RelativeContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setRelative(this);
        contacts.add(contact);
    }
    public void removeContact(RelativeContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }


}
