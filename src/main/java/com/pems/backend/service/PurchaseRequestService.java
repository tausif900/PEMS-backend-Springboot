package com.pems.backend.service;

import java.util.List;


import com.pems.backend.dtos.PurchaseRequestDto;

public interface PurchaseRequestService {

	String addPurchaseRequest(PurchaseRequestDto purchaseRequestDto);

	List<PurchaseRequestDto> getPendingPurchaseRequest();


}
