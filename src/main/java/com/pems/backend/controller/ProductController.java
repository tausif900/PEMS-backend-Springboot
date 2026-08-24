package com.pems.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pems.backend.dtos.ProductRequestDto;
import com.pems.backend.dtos.ProductResponseDto;
import com.pems.backend.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add-product")
	public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
		return new ResponseEntity<ProductResponseDto>(productService.addProduct(productRequestDto), HttpStatus.CREATED);
	}

}
