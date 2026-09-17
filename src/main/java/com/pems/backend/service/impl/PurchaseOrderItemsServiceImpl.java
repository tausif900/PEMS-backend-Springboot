package com.pems.backend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pems.backend.dtos.PurchaseOrderItemsRequestDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;
import com.pems.backend.service.PurchaseOrderItemsService;

@Service
public class PurchaseOrderItemsServiceImpl implements PurchaseOrderItemsService {

	@Override
	public PurchaseOrderItemsResponseDto addAndCalculateOrderItems(PurchaseOrderItemsRequestDto request) {
//		unitPrice*Quantity=totalPrice
		BigDecimal subTotal = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getRequestedQuantity()));

//		discount calculation
		BigDecimal discount = subTotal.multiply(request.getDiscount()).divide(BigDecimal.valueOf(100));

//		GST Caluclation
		BigDecimal gst = subTotal.multiply(request.getGst()).divide(BigDecimal.valueOf(100));

//		Final Amount
		BigDecimal totalAmount = subTotal.subtract(discount).add(gst);

		PurchaseOrderItemsResponseDto response = new PurchaseOrderItemsResponseDto();
		response.setProductName(request.getProductName());
		response.setProductCode(request.getProductCode());
		response.setPurchaseOrder(request.getPurchaseOrder());
		response.setRequestedQuantity(request.getRequestedQuantity());
		response.setUnitPrice(request.getUnitPrice());
		response.setDiscount(request.getDiscount());
		response.setGst(request.getGst());
		response.setTotalAmount(totalAmount);
		return response;
	}

}
