package com.quark.guavatech.employee.repository;

import com.quark.guavatech.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
