package com.pems.backend.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.PurchaseOrderDto;
import com.pems.backend.dtos.PurchaseOrderItemsResponseDto;
import com.pems.backend.entity.PurchaseOrder;
import com.pems.backend.entity.PurchaseOrderItems;
import com.pems.backend.repositoriy.PurchaseOrderRepository;
import com.pems.backend.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PurchaseOrderDto createPO(PurchaseOrderDto purchaseOrderDto) {

		PurchaseOrder po = new PurchaseOrder();
		po.setPoNumber(purchaseOrderDto.getPoNumber());
		po.setPoDate(purchaseOrderDto.getPoDate());
		po.setSubTotal(purchaseOrderDto.getSubTotal());
		po.setDiscount(purchaseOrderDto.getDiscount());
		po.setCgst(purchaseOrderDto.getCgst());
		po.setSgst(purchaseOrderDto.getSgst());
		po.setGrandTotal(purchaseOrderDto.getGrandTotal());
		po.setSupplier(purchaseOrderDto.getSupplier());
		po.setSupplierContactPerson(purchaseOrderDto.getSupplierContactPerson());
		po.setPhoneNumber(purchaseOrderDto.getPhoneNumber());
		po.setGstNumber(purchaseOrderDto.getGstNumber());
		po.setSupplierAddress(purchaseOrderDto.getSupplierAddress());
		po.setExpectedDliveryDate(purchaseOrderDto.getExpectedDliveryDate());
		po.setDeliveryAddress(purchaseOrderDto.getDeliveryAddress());
		po.setPaymentTerms(purchaseOrderDto.getPaymentTerms());
		po.setPaymentDueDate(purchaseOrderDto.getPaymentDueDate());
		po.setTermsAndCondition(purchaseOrderDto.getTermsAndCondition());

		List<PurchaseOrderItemsResponseDto> items = purchaseOrderDto.getOrderItems();
		for (PurchaseOrderItemsResponseDto itemDto : items) {

			PurchaseOrderItems item = new PurchaseOrderItems();
			item.setProductName(itemDto.getProductName());
			item.setProductCode(itemDto.getProductCode());
			item.setRequestedQuantity(itemDto.getRequestedQuantity());
			item.setUnitPrice(itemDto.getUnitPrice());
			item.setDiscount(itemDto.getDiscount());
			item.setGst(itemDto.getGst());
			item.setTotalAmount(itemDto.getTotalAmount());

			item.setPurchaseOrder(po);

			po.getOrderItems().add(item);
		}

		PurchaseOrder savedPo = purchaseOrderRepository.save(po);

		return modelMapper.map(savedPo, PurchaseOrderDto.class);

	}

}
