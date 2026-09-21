package com.pems.backend.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.SupplierDto;
import com.pems.backend.entity.Supplier;
import com.pems.backend.repositoriy.SupplierRepository;
import com.pems.backend.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SupplierDto addSupplier(SupplierDto supplierDto) {
		Supplier supplier = new Supplier();

		supplier.setSupplierName(supplierDto.getSupplierName());
		supplier.setSupplierCode(supplierDto.getSupplierCode());
		supplier.setContactPerson(supplierDto.getContactPerson());
		supplier.setPhoneNumber(supplierDto.getPhoneNumber());
		supplier.setEmail(supplierDto.getEmail());
		supplier.setGstNumber(supplierDto.getGstNumber());
		supplier.setStatus(supplierDto.getStatus());
		supplier.setAddress(supplierDto.getAddress());

		Supplier savedSupplier = supplierRepository.save(supplier);

		return modelMapper.map(savedSupplier, SupplierDto.class);

	}

	@Override
	public List<SupplierDto> getAllSuppliers() {
		List<Supplier> suppliers = supplierRepository.findAll();

		List<SupplierDto> responseDto = suppliers.stream().map((s) -> {
			SupplierDto supplierDto = modelMapper.map(s, SupplierDto.class);
			return supplierDto;
		}).toList();

		return responseDto;
	}

}
