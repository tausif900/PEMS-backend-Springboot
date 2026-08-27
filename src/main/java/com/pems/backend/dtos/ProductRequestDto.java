package com.pems.backend.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
	private Integer productId;

	private String productName;

	private String productCode;

	private BigDecimal purchasePrice;

	private Long quantity;
	
	private String productLocation;

	private String supplier;
	
	private String productDescription;
}
