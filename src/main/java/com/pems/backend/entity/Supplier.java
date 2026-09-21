package com.pems.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer supplierId;

	@Column(nullable = false)
	private String supplierName;

	@Column(nullable = false)
	private String supplierCode;

	@Column(nullable = false)
	private String contactPerson;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String gstNumber;

	private String status;

	@Column(nullable = false)
	private String address;

}
