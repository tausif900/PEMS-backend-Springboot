package com.pems.backend.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pems.backend.entity.PurchaseOrderItems;

public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItems, Integer> {

}
