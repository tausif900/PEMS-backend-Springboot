package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.SupplierDto;

public interface SupplierService {
	SupplierDto addSupplier(SupplierDto supplierDto);

	List<SupplierDto> getAllSuppliers();
}
