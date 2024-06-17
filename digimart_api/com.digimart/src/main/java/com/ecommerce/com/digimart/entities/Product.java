package com.ecommerce.com.digimart.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "tax_percentage")
    private double taxPercentage;


}
