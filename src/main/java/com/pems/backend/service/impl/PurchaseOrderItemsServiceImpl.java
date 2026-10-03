package com.pems.backend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.PurchaseOrderItemsRequestDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;
import com.pems.backend.entity.PurchaseOrderItems;
import com.pems.backend.entity.PurchaseRequest;
import com.pems.backend.repositoriy.PurchaseOrderItemsRepository;
import com.pems.backend.repositoriy.PurchaseRequestRepository;
import com.pems.backend.service.PurchaseOrderItemsService;

@Service
public class PurchaseOrderItemsServiceImpl implements PurchaseOrderItemsService {

	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemsRepository;

	@Autowired
	private ModelMapper modelMapper;

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
		response.setRequestedQuantity(request.getRequestedQuantity());
		response.setUnitPrice(request.getUnitPrice());
		response.setDiscount(request.getDiscount());
		response.setGst(request.getGst());
		response.setTotalAmount(totalAmount);

		return response;
	}

	@Override
	public PurchaseOrderItemsResponseDto receivedQuantity(Integer orderId, PurchaseOrderItemsRequestDto request) {
		PurchaseOrderItems purchaseOrderItems = purchaseOrderItemsRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order item not found"));

		Integer totalReceivedQuantity = purchaseOrderItems.getReceivedQunatity() + request.getReceivedQuantity();

		purchaseOrderItems.setReceivedQunatity(totalReceivedQuantity);
		PurchaseOrderItems savedOrderItems = purchaseOrderItemsRepository.save(purchaseOrderItems);
		PurchaseOrderItemsResponseDto responseDto = modelMapper.map(savedOrderItems,
				PurchaseOrderItemsResponseDto.class);
		responseDto.setPendingQuantity(savedOrderItems.getRequestedQuantity() - savedOrderItems.getReceivedQunatity());
		responseDto.setReceivedQuantity(totalReceivedQuantity);
		return responseDto;
	}

}
