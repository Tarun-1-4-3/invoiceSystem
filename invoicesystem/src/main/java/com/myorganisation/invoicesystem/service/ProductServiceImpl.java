package com.myorganisation.invoicesystem.service;

import com.myorganisation.invoicesystem.dto.ProductInputDto;
import com.myorganisation.invoicesystem.dto.ProductOutputDto;
import com.myorganisation.invoicesystem.entity.Product;
import com.myorganisation.invoicesystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements  ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductOutputDto getProduct(Long barcode){
        Product product = productRepository.getProductById((barcode));

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setBarcode(product.getBarcode());
        productOutputDto.setName(product.getName());
        productOutputDto.setMrp(product.getMrp());

    return productOutputDto;

    }

    @Override
    public List<ProductOutputDto> getAllProducts() {
       List<Product> productList = new ArrayList<>(productRepository.getProducts().values());

       List<ProductOutputDto> productOutputDtoList = new ArrayList<>();

       for(Product product : productList){
           ProductOutputDto productOutputDto = new ProductOutputDto();

           productOutputDto.setBarcode(product.getBarcode());
           productOutputDto.setName(product.getName());
           productOutputDto.setMrp(product.getMrp());

           productOutputDtoList.add(productOutputDto);
       }
       return productOutputDtoList;
    }

    @Override
    public ProductOutputDto addProduct(ProductInputDto productInputDto) {
        Product product = new Product();

        product.setBarcode(productRepository.generateBarcode());
        product.setName(productInputDto.getName());
        product.setMrp(productInputDto.getMrp());

        productRepository.addProducts(product);

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setBarcode(product.getBarcode());
        productOutputDto.setName(product.getName());
        productOutputDto.setMrp(product.getMrp());

        return productOutputDto;
    }

    @Override
    public ProductOutputDto updateProduct(Long id, ProductInputDto productInputDto) {
        Product product = new Product();

        product.setBarcode(productRepository.generateBarcode());
        product.setName(productInputDto.getName());
        product.setMrp(productInputDto.getMrp());

        productRepository.addProducts(product);

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setBarcode(product.getBarcode());
        productOutputDto.setName(product.getName());
        productOutputDto.setMrp(product.getMrp());

        return productOutputDto;
    }

    @Override
    public String removeProduct(Long barcode) {
        String productName = productRepository.getProductById(barcode).getName();

        productRepository.removeProductById(barcode);

        return "Product: " + productName + "and their Barcode: " + barcode + " has been removed successfully!";
    }
}
