package com.BSProjects.Product_management_System.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProjects.Product_management_System.DTO.ProductDTO;
import com.BSProjects.Product_management_System.Entity.Product;
import com.BSProjects.Product_management_System.Repository.ProductRepository;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product mapping(ProductDTO productDTO,Product product ) throws ParseException{
        
        if(productDTO.getBrand()!=null){
            product.setBrand(productDTO.getBrand());
        }
        if(productDTO.getCategory()!=null){
            product.setCategory(productDTO.getCategory());
        }
        if(productDTO.getDescription()!=null){
            product.setDescription(productDTO.getDescription());
        }
        if(productDTO.getProductName()!=null){
            product.setProductName(productDTO.getProductName());
        }
        if(productDTO.getQuantity()!=0){
            product.setQuantity(productDTO.getQuantity());
        }
        if(productDTO.getUnitPrice()!=0){
            product.setUnitPrice(productDTO.getUnitPrice());}

        if(productDTO.getCreatedDate()!=null){
            String sDate1=productDTO.getCreatedDate();  
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
            product.setCreatedDate(date1);
        }
        if(productDTO.getManufacturedDate()!=null){
            String sDate2=productDTO.getManufacturedDate(); 
            Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2); 
            product.setManufacturedDate(date2);
        }
        if(productDTO.getExpiredDate()!=null){
            String sDate3=productDTO.getExpiredDate(); 
            Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3); 
            product.setExpiredDate(date3);
        }

        return product;

    }
    public ProductDTO inverseMapping(Product product){

        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand());
        productDTO.setCategory(product.getCategory());
        productDTO.setDescription(product.getDescription());
        productDTO.setProductName(product.getProductName());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setUnitPrice(product.getUnitPrice());

        Date date1 = product.getCreatedDate(); 
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate1 = dateFormat1.format(date1);  
        productDTO.setCreatedDate(strDate1);

        Date date2 = product.getManufacturedDate();
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate2 = dateFormat2.format(date2);  
        productDTO.setManufacturedDate(strDate2);

        Date date3 = product.getManufacturedDate();
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate3 = dateFormat3.format(date3);  
        productDTO.setManufacturedDate(strDate3);

        return productDTO;
    }
    public void postProduct(ProductDTO productDTO) throws ParseException{
       Product uProduct=new Product(); 
       Product product = mapping(productDTO,uProduct);
       productRepository.save(product);
    }

    public ProductDTO getProduct(int id){
        Product product = productRepository.findById(id);
        return inverseMapping(product);


    }

    public List<ProductDTO> getProducts(){
        List<ProductDTO> productDTOs=new ArrayList<>();
        for( Product product:productRepository.findAll()){
            productDTOs.add(inverseMapping(product));
        }
        return productDTOs;
    }
    public void updateProduct(int id,ProductDTO productDTO) throws ParseException{
       Product product = productRepository.findById(id);
       Product updatedProduct=mapping(productDTO, product);
       productRepository.save(updatedProduct);
    }
    public void deleteProduct(int id){
        Product product = productRepository.findById(id);
        productRepository.delete(product);
    }

    
}
