package com.fractal.domain.organization_management.organization;

import com.fractal.domain.abstraction.Lifecycle;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.domain.organization_management.organization.contact.OrganizationContact;
import com.fractal.domain.organization_management.organization.work_schedule.OrganizationWorkSchedule;
import com.fractal.domain.organization_management.unit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Organization extends Lifecycle {

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "tin_number")
    private String tinNumber;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Organization parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Organization> children = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrganizationAddress> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrganizationContact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrganizationWorkSchedule> workSchedules = new ArrayList<>();


    public void addAddress(OrganizationAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setOrganization(this);
        addresses.add(address);
    }

    public void removeAddress(OrganizationAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }
    }

    public void addContact(OrganizationContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setOrganization(this);
        contacts.add(contact);
    }

    public void removeContact(OrganizationContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

    public void addChild(Organization organization) {
        if (children == null) children = new ArrayList<>();
        organization.setParent(this);
        children.add(organization);
    }

    public void removeChild(Organization organization) {
        if (children != null && !children.isEmpty())
            children.remove(organization);
    }

    public void addWorkSchedule(OrganizationWorkSchedule workSchedule) {
        if (workSchedules == null) workSchedules = new ArrayList<>();
        workSchedule.setOrganization(this);
        workSchedules.add(workSchedule);
    }

    public void removeWorkSchedule(OrganizationWorkSchedule workSchedule) {
        if (workSchedules != null && !workSchedules.isEmpty())
            workSchedules.remove(workSchedule);
    }

}
