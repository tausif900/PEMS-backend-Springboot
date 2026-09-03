package com.pems.backend.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pems.backend.entity.PurchaseRequest;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Integer> {

	List<PurchaseRequest> findByStatus(String status);

}
