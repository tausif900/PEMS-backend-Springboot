package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.PurchaseRequestDto;
import com.pems.backend.entity.PurchaseRequest;

public interface PurchaseRequestService {

	String addPurchaseRequest(PurchaseRequestDto purchaseRequestDto);

	List<PurchaseRequest> getPendingPurchaseRequest();

	PurchaseRequestDto approvePurchaseRequest(Integer purchaseId);

	List<PurchaseRequestDto> getApprovedPurchaseRequests();
}
