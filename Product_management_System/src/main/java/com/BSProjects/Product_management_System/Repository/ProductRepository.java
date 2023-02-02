package com.BSProjects.Product_management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSProjects.Product_management_System.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findById(int id);

    //void save(Product product);
    
}
