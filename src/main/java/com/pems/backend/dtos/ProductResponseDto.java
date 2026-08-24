package com.pems.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
	private Integer productId;

	private String productName;

	private String productCode;

	private BigDecimal purchasePrice;

	private BigDecimal sellingPrice;

	private Integer quantity;

	private String productLocation;

	private String supplier;
	
	private String productDescription;
	
	private LocalDate deliveryDate;
}
