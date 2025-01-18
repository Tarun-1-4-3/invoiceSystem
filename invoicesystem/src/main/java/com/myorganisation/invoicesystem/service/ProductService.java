package com.myorganisation.invoicesystem.service;

import com.myorganisation.invoicesystem.dto.ProductInputDto;
import com.myorganisation.invoicesystem.dto.ProductOutputDto;

import java.util.List;

public interface ProductService {
    public ProductOutputDto getProduct(Long id);
    public List<ProductOutputDto> getAllProducts();
    public ProductOutputDto addProduct(ProductInputDto productInputDto);
    public ProductOutputDto updateProduct(Long id, ProductInputDto productInputDto);
    public String removeProduct(Long id);
}
