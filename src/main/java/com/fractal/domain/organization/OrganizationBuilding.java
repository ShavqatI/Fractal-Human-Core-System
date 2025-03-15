package com.fractal.domain.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.administration.LeaseInfo;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.user.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "organization_building", schema = "organization_schema", catalog = "fractal")
public class OrganizationBuilding extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "building_type_id", referencedColumnName = "id")
    private BuildingType buildingType;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "lease_info_id", referencedColumnName = "id")
    private LeaseInfo leaseInfo;

    @Column(name = "serial_number",length = 2000)
    private Integer serialNumber;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "area")
    private Double area;

    @Column(name = "area_info",length = 600)
    private String areaInfo;

    @Column(name = "year",length = 4)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "confirm_user_id", referencedColumnName = "id")
    private User confirmUser;

    @Column(name = "confirm_date")
    private Timestamp confirmDate;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organizationId) {
        this.organization = organizationId;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingTypeId) {
        this.buildingType = buildingTypeId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status statusId) {
        this.status = statusId;
    }

    public LeaseInfo getLeaseInfo() {
        return leaseInfo;
    }

    public void setLeaseInfo(LeaseInfo leaseInfoId) {
        this.leaseInfo = leaseInfoId;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public User getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(User confirmUser) {
        this.confirmUser = confirmUser;
    }

    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }
}
