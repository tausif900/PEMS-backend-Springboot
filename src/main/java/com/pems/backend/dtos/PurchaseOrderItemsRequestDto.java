package com.pems.backend.dtos;

import java.math.BigDecimal;

import com.pems.backend.entity.Product;
import com.pems.backend.entity.PurchaseOrder;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemsRequestDto {

	private Integer orderId;

	@ManyToOne
	private Product product;

	private Integer quantity;

	private BigDecimal unitPrice;

	private BigDecimal discount;

	private BigDecimal gst;

	private BigDecimal totalAmount;

	@ManyToOne
	private PurchaseOrder purchaseOrder;
	
}
