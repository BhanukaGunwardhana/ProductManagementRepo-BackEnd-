package com.BSProjects.Product_management_System.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    int id;
    String productName;
    String  description;
    String category;
    String brand;
    Date expiredDate;
    Date manufacturedDate;
    Date createdDate;
    int quantity;
    int unitPrice;

}
