package com.BSProjects.Product_management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    int id;
    String productName;
    String  description;
    String category;
    String brand;
    String expiredDate;
    String manufacturedDate;
    String createdDate;
    int quantity;
    int unitPrice;

    
}
