package com.BSProjects.Product_management_System.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BSProjects.Product_management_System.DTO.ProductDTO;
import com.BSProjects.Product_management_System.Service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("api/getproducts")
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/api/getproductbyid/{id}")
    public ProductDTO getProduct(int id){
        return productService.getProduct(id);
    }

    @PostMapping("/api/addproducts")
    public void addProducts(@RequestBody ProductDTO productDTO) {
        try {
            productService.postProduct(productDTO);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @PutMapping("/api/updateproduct/{id}")
    public void updatedProduct(@PathVariable int id,@RequestBody ProductDTO productDTO){
        try {
            productService.updateProduct(id, productDTO);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @DeleteMapping("api/deleteproduct/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    
}
