package com.pems.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.pems.backend.entity.PurchaseOrderItems;
import com.pems.backend.entity.PurchaseRequest;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDto {

	private Integer poId;

	private String poNumber;

	private LocalDate poDate;

	private List<PurchaseRequestDto> purchaseRequestDto;

	private List<PurchaseOrderItemsResponseDto> orderItems;

	private BigDecimal subTotal;

	private BigDecimal discount;

	private BigDecimal cgst;

	private BigDecimal sgst;

	private BigDecimal grandTotal;

	private String supplier;

	private String supplierContactPerson;

	private String phoneNumber;

	private String gstNumber;

	private String supplierAddress;

	private LocalDate expectedDliveryDate;

	private String deliveryAddress;

	private String paymentTerms;

	private LocalDate paymentDueDate;

	private String termsAndCondition;
}
