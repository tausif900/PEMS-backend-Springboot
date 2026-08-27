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

	private Long quantity;

	private String productLocation;

	private String supplier;

	private String productDescription;

	private LocalDate deliveryDate;

//	This is generated bcuz of Repository "Custom Query"
	public ProductResponseDto(String productName, String productCode, String productDescription, Long quantity,
			String productLocation, String supplier) {
		super();

		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
		this.productLocation = productLocation;
		this.supplier = supplier;
		this.productDescription = productDescription;

	}

}
