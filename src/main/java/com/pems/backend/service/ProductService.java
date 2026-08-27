package com.pems.backend.service;

import java.util.List;

import com.pems.backend.dtos.ProductRequestDto;
import com.pems.backend.dtos.ProductResponseDto;

public interface ProductService {
	ProductResponseDto addProduct(ProductRequestDto productRequestDto);

	List<ProductResponseDto> getAllProducts();

	List<ProductResponseDto> getDistinctProducts();
}
