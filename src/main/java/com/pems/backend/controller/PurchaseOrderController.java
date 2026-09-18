package com.pems.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.PurchaseOrderDto;
import com.pems.backend.service.PurchaseOrderService;

@RestController
@RequestMapping("purchase-order")
@CrossOrigin
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

//	POST - "purchase-order/create-PO"
	@PostMapping("/create-PO")
	public ResponseEntity<PurchaseOrderDto> createPO(@RequestBody PurchaseOrderDto purchaseOrderDto) {
		return new ResponseEntity<PurchaseOrderDto>(purchaseOrderService.createPO(purchaseOrderDto),
				HttpStatus.CREATED);
	}

}
