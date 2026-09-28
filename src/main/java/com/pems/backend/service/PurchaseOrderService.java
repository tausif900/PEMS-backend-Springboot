package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.PurchaseOrderDto;

public interface PurchaseOrderService {

	PurchaseOrderDto createPO(PurchaseOrderDto purchaseOrderDto);

	PurchaseOrderDto getPoById(Integer poId);

	List<PurchaseOrderDto> getAllOpenPO();

}
