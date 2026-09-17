package com.pems.backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.PurchaseOrderItemsRequestDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;
import com.pems.backend.service.PurchaseOrderItemsService;

@RestController
@RequestMapping("order-items")
public class PurchaseOrderItemsController {

	@Autowired
	private PurchaseOrderItemsService purchaseOrderItemsService;

	@PostMapping("/add-items")
	public ResponseEntity<PurchaseOrderItemsResponseDto> addAndCalculateOrderItems(
			@RequestBody PurchaseOrderItemsRequestDto request) {
		return new ResponseEntity<PurchaseOrderItemsResponseDto>(
				purchaseOrderItemsService.addAndCalculateOrderItems(request), HttpStatus.CREATED);
	}

}
