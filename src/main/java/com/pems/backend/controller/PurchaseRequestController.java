package com.pems.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.PurchaseRequestDto;
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

}
