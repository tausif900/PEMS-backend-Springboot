package com.pems.backend.service;

import com.pems.backend.dtos.PurchaseOrderDto;

public interface PurchaseOrderService {

	PurchaseOrderDto createPO(PurchaseOrderDto purchaseOrderDto);

}
