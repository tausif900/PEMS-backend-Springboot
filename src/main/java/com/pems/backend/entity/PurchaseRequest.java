package com.pems.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurchaseRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requestId;

	private String productCode;

	private String productName;

	private String productDescription;

	private Integer currentQuantity;

	private Integer requestedQuantity;

	private LocalDate requestDate;

	private String status;
	
	private String reason;
}
