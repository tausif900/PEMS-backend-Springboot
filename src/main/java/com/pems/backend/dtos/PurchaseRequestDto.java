package com.pems.backend.dtos;

import java.time.LocalDate;

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

	private String status;

	private LocalDate requestDate;

	private String requestedBy;

	private String reason;

}
