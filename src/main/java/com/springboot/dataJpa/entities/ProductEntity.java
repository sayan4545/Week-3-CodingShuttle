package com.springboot.dataJpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(name ="unique_sku",columnNames = {"sku"}),
                @UniqueConstraint(name="unique_title_price",columnNames ={"productTitle","price"})

        },
        indexes = @Index(name ="sku_index",columnList = "sku")

)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;
    @Column(nullable = false,length = 20)
    private String sku;
    @Column(name = "productTitle")
    private String title;
    private BigDecimal price;
    private Integer quantity;
    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDate createdAt;
    @Column(name = "updateAt")
    @UpdateTimestamp
    private LocalTime updateAt;

}
