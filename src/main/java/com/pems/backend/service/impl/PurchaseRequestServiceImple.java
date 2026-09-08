package com.pems.backend.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

	@Override
	public List<PurchaseRequest> getPendingPurchaseRequest() {
		List<PurchaseRequest> pendingStatus = purchaseRequestRepository.findByStatus("Pending");

		return pendingStatus;
	}

	@Override
	public PurchaseRequestDto approvePurchaseRequest(Integer purchaseId) {
		PurchaseRequest purchaseRequest = purchaseRequestRepository.findById(purchaseId)
				.orElseThrow(() -> new RuntimeException("request not found"));
		purchaseRequest.setStatus("Approved");
		purchaseRequestRepository.save(purchaseRequest);
		PurchaseRequestDto purchaseRequestDto = modelMapper.map(purchaseRequest, PurchaseRequestDto.class);
		return purchaseRequestDto;
	}

	@Override
	public List<PurchaseRequestDto> getApprovedPurchaseRequests() {
		List<PurchaseRequest> listOfApprovedRequest = purchaseRequestRepository.findByStatus("Approved");
		List<PurchaseRequestDto> requestDto = listOfApprovedRequest.stream().map((r) -> {
			PurchaseRequestDto purchaseRequestDto = modelMapper.map(r, PurchaseRequestDto.class);
			return purchaseRequestDto;
		}).toList();
		return requestDto;
	}

}
