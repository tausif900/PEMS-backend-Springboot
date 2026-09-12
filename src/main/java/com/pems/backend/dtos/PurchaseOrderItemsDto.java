package com.pems.backend.dtos;

import java.math.BigDecimal;

import com.pems.backend.entity.Product;
import com.pems.backend.entity.PurchaseOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemsDto {
	private Integer orderId;

	private Product product;

	private Integer quantity;

	private BigDecimal unitPrice;

	private BigDecimal discount;

	private BigDecimal gst;

	private BigDecimal totalAmount;

	private PurchaseOrder purchaseOrder;
}
