package com.pems.backend.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pems.backend.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
