package com.springboot.dataJpa;

import com.springboot.dataJpa.entities.ProductEntity;
import com.springboot.dataJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.repository.util.ClassUtils.ifPresent;

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
				.sku("books")
				.title("XYZ")
				.price(BigDecimal.valueOf(26))
				.quantity(18)
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
	@Test
	void findByCreatedAfter(){
		List<ProductEntity> pr = productRepository.findByCreatedAtAfter(LocalDate.of(2024,12,23));
	}
	@Test
	void findByPriceAndQuantity(){
		List<ProductEntity> products = productRepository.findAllByPriceAndQuantity(18,BigDecimal.valueOf(26));
	}
	@Test
	void findByTAndP(){
		Optional<ProductEntity> p = productRepository.findByTitleAndPrice("XYZ",BigDecimal.valueOf(26));
		p.ifPresent(System.out::println);
	}
	@Test
	void orderBy(){
		List<ProductEntity> prs = productRepository.findByTitleOrderByPrice("XYZ");
	}


}
