package com.pems.backend.service;


import com.pems.backend.dtos.PurchaseOrderItemsRequestDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;

public interface PurchaseOrderItemsService {

	PurchaseOrderItemsResponseDto addAndCalculateOrderItems(PurchaseOrderItemsRequestDto request);

}
