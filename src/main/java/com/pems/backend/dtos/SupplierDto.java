package com.pems.backend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

	private Integer supplierId;

	@NotNull(message = "Name cann't be blank")
	private String supplierName;

	@NotNull
	private String supplierCode;

	@NotNull
	private String contactPerson;

	@NotNull
	private String phoneNumber;

	@NotNull
	private String email;

	@NotNull
	private String gstNumber;

	private String status;

	@NotNull
	private String address;
}
