package com.springboot.dataJpa;

import com.springboot.dataJpa.entities.ProductEntity;
import com.springboot.dataJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

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
				.sku("Cosmetics9")
				.title("COSMETIC SECTION New")
				.price(BigDecimal.valueOf(267))
				.quantity(100)
				.build();
		ProductEntity savedEntity = productRepository.save(productEntity);
		System.out.println(savedEntity);
	}

}
