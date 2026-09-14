package com.pems.backend.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pems.backend.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}
