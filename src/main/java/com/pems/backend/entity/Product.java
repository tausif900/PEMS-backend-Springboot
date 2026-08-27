package com.pems.backend.entity;

import java.math.BigDecimal;
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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	private String productName;

	private String productCode;

	private Long quantity;

	private BigDecimal purchasePrice;

	private BigDecimal sellingPrice;

	private String productLocation;

	private String supplier;

	private LocalDate deliveryDate;
	
	private String productDescription;

}
