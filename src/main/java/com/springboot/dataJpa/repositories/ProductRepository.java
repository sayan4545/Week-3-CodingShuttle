package com.springboot.dataJpa.repositories;

import com.springboot.dataJpa.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByCreatedAtAfter(LocalDate after);

    List<ProductEntity> findAllByPriceAndQuantity(int quantity, BigDecimal price);
    //Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
    @Query("select e from ProductEntity e where e.title =?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
    List<ProductEntity> findByTitleOrderByPrice(String title);
    List<ProductEntity> findByOrderByPrice();
}
