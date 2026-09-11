package com.pems.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurchaseOrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
