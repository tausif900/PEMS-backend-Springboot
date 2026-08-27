package com.pems.backend.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pems.backend.dtos.ProductResponseDto;
import com.pems.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("""
			    SELECT new com.pems.backend.dtos.ProductResponseDto(
			        p.productName,
			        p.productCode,
			        p.productDescription,
			        SUM(p.quantity),
			        p.productLocation,
			        p.supplier
			    )
			    FROM Product p
			    GROUP BY
			        p.productName,
			        p.productCode,
			        p.productDescription,
			        p.productLocation,
			        p.supplier
			""")
	List<ProductResponseDto> getDistinctProducts();

}
