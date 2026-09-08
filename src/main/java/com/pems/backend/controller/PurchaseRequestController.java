package com.pems.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.PurchaseRequestDto;
import com.pems.backend.entity.PurchaseRequest;
import com.pems.backend.service.PurchaseRequestService;

@RestController
@RequestMapping("/purchase-request")
@CrossOrigin
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestService purchaseRequestService;

	@PostMapping()
	public ResponseEntity<String> addPurchaseRequest(@RequestBody PurchaseRequestDto purchaseRequestDto) {
		return new ResponseEntity<String>(purchaseRequestService.addPurchaseRequest(purchaseRequestDto),
				HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<PurchaseRequest>> getPendingPurchaseRequest() {
		return ResponseEntity.ok(purchaseRequestService.getPendingPurchaseRequest());
	}

	@PutMapping("/approve/{purchaseId}")
	public ResponseEntity<PurchaseRequestDto> approvePurchaseRequest(@PathVariable Integer purchaseId) {
		return ResponseEntity.ok(purchaseRequestService.approvePurchaseRequest(purchaseId));
	}

	@GetMapping("/approved-requests")
	public ResponseEntity<List<PurchaseRequestDto>> getApprovedPurchaseRequests() {
		return ResponseEntity.ok(purchaseRequestService.getApprovedPurchaseRequests());
	}

}
