package com.myorganisation.invoicesystem.repository;

import com.myorganisation.invoicesystem.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class ProductRepository {
    private Map<Long, Product> products = new HashMap<>();

    private Long barcode = 202501140L;

    public Map<Long, Product> getProducts() {
        return this.products;
    }
    public  Product getProductById(Long id){
        return this.products.get(id);
    }

    public void addProducts(Product product) {
        this.products.put(product.getBarcode(), product);
    }
    public void removeProductById(Long id){
        this.products.remove(id);
    }

    public Long getBarcode(){
        return this.barcode;
    }
    public  Long generateBarcode(){
        return ++barcode;
    }
}
