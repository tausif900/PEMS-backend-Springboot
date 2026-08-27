package com.pems.backend.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pems.backend.dtos.ProductRequestDto;
import com.pems.backend.dtos.ProductResponseDto;
import com.pems.backend.entity.Product;
import com.pems.backend.repositoriy.ProductRepository;
import com.pems.backend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
		Product product = new Product();

		product.setProductName(productRequestDto.getProductName());
		product.setProductCode(productRequestDto.getProductCode());
		product.setQuantity(productRequestDto.getQuantity());
		product.setPurchasePrice(productRequestDto.getPurchasePrice());
		product.setProductLocation(productRequestDto.getProductLocation());
		product.setSupplier(productRequestDto.getSupplier());
		product.setProductDescription(productRequestDto.getProductDescription());
		product.setDeliveryDate(LocalDate.now());

		BigDecimal tenPerOfPurPrice = productRequestDto.getPurchasePrice().multiply(BigDecimal.TEN)
				.divide(BigDecimal.valueOf(100));

		BigDecimal sellingPrice = productRequestDto.getPurchasePrice().add(tenPerOfPurPrice);

		product.setSellingPrice(sellingPrice);

		Product savedProduct = productRepository.save(product);

		ProductResponseDto responseDto = modelMapper.map(savedProduct, ProductResponseDto.class);

		return responseDto;
	}

	@Override
	public List<ProductResponseDto> getAllProducts() {
		List<Product> allProducts = productRepository.findAll();
		List<ProductResponseDto> listOfProducts = allProducts.stream().map((p) -> {
			ProductResponseDto responseDto = modelMapper.map(p, ProductResponseDto.class);
			return responseDto;
		}).toList();
		return listOfProducts;
	}

	@Override
	public List<ProductResponseDto> getDistinctProducts() {
		List<ProductResponseDto> distinctProducts = productRepository.getDistinctProducts();
		return distinctProducts;
	}

}
