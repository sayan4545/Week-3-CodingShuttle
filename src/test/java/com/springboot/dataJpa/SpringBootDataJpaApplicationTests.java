package com.springboot.dataJpa;

import com.springboot.dataJpa.entities.ProductEntity;
import com.springboot.dataJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(classes = com.springboot.dataJpa.SpringBootDataJpaApplication.class)

class SpringBootDataJpaApplicationTests {
	@Autowired
	ProductRepository productRepository;

    @Test
	void contextLoads() {
	}
	@Test
	void TestRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("Cosmetics10")
				.title("COSMETIC SECTION Old")
				.price(BigDecimal.valueOf(2679))
				.quantity(1001)
				.build();
		ProductEntity savedEntity = productRepository.save(productEntity);
		System.out.println(savedEntity);
	}
	@Test
	void fetchProductById(){
		List<ProductEntity> products = productRepository.findAll();
		System.out.println(products);
	}
	@Test
	void findByTitle(){
		List<ProductEntity> prods = productRepository.findByTitle("COSMETIC SECTION Old");
	}

}
