package com.pems.backend.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer poId;

	private String poNumber;

	private LocalDate poDate;

	@OneToMany
	private List<PurchaseRequest> purchaseRequest;

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
