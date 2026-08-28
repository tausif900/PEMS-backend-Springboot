package com.pems.backend.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.PurchaseRequestDto;
import com.pems.backend.entity.PurchaseRequest;
import com.pems.backend.repositoriy.PurchaseRequestRepository;
import com.pems.backend.service.PurchaseRequestService;

@Service
public class PurchaseRequestServiceImple implements PurchaseRequestService {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addPurchaseRequest(PurchaseRequestDto purchaseRequestDto) {
		PurchaseRequest purchaseRequest = new PurchaseRequest();

		purchaseRequest.setProductName(purchaseRequestDto.getProductName());
		purchaseRequest.setProductCode(purchaseRequestDto.getProductCode());
		purchaseRequest.setCurrentQuantity(purchaseRequestDto.getCurrentQuantity());
		purchaseRequest.setRequestedQuantity(purchaseRequestDto.getRequestedQuantity());
		purchaseRequest.setRequestDate(LocalDate.now());
		purchaseRequest.setStatus("Pending");
		purchaseRequest.setProductDescription(purchaseRequestDto.getProductDescription());
		purchaseRequest.setReason(purchaseRequestDto.getReason());

		purchaseRequestRepository.save(purchaseRequest);

		return "Purchase request Saved Successfully";
	}

}
