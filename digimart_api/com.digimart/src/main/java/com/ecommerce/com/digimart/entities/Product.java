package com.ecommerce.com.digimart.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name = "products")
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private String category;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "tax_percentage")
    private double taxPercentage;

    @Column(name = "img_url")
    private int imgUrl;

}
