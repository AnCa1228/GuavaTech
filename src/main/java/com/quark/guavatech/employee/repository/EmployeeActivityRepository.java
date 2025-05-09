package com.quark.guavatech.employee.repository;

import com.quark.guavatech.employee.model.EmployeeActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeActivityRepository extends JpaRepository<EmployeeActivity, Long> {
}
