package com.fractal;

import com.fractal.domain.organization_management.department.Department;

import java.util.List;

class DepartmentServiceTest {

    public static void main(String[] args) {
        Department department =
                Department.builder()
                        .organizationUnit(null)
                        .levelMap(null)
                        .name("Dep#1")
                .build();
        Department child =
                Department.builder()
                        .organizationUnit(null)
                        .levelMap(null)
                        .name("Dep#2")
                        .build();

        Department child2 =
                Department.builder()
                        .organizationUnit(null)
                        .levelMap(null)
                        .name("Dep#3")
                        .build();
        child.setChildren(List.of(child2));
        department.setChildren(List.of(child));




        //assignLevelMap(department);

    }



}