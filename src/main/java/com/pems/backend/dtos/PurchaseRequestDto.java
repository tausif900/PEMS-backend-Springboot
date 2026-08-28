package com.pems.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDto {
	
	private String productCode;

	private String productName;

	private String productDescription;

	private Integer currentQuantity;

	private Integer requestedQuantity;

	private String reason;
	
}
