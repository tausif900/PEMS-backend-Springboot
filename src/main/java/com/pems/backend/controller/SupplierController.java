package com.pems.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.SupplierDto;
import com.pems.backend.service.SupplierService;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/add-supplier")
	public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto) {
		return new ResponseEntity<SupplierDto>(supplierService.addSupplier(supplierDto), HttpStatus.CREATED);
	}

	@GetMapping("/all-suppliers")
	public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
		return ResponseEntity.ok(supplierService.getAllSuppliers());
	}
}
