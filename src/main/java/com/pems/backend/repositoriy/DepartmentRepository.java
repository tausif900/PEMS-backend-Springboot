package com.pems.backend.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pems.backend.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
