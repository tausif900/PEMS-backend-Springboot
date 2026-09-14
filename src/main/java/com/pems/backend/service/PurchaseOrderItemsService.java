package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.PurchaseOrderItemsRequestDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;

public interface PurchaseOrderItemsService {

	List<PurchaseOrderItemsResponseDto> addAndCalculateOrderItems(List<PurchaseOrderItemsRequestDto> requests);

}
