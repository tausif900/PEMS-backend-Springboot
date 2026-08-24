package com.pems.backend.service;

import com.pems.backend.dtos.ProductRequestDto;
import com.pems.backend.dtos.ProductResponseDto;

public interface ProductService {
	ProductResponseDto addProduct(ProductRequestDto productRequestDto);
}
