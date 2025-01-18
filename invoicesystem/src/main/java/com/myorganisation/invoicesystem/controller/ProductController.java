package com.myorganisation.invoicesystem.controller;

import com.myorganisation.invoicesystem.dto.ProductInputDto;
import com.myorganisation.invoicesystem.dto.ProductOutputDto;
import com.myorganisation.invoicesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/server")
    public ResponseEntity<String> serverStatus() {
        return new ResponseEntity<>("Server is live!", HttpStatus.OK);
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<ProductOutputDto> getProduct(@PathVariable Long Barcode) {
        return new ResponseEntity<>(productService.getProduct(Barcode), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductOutputDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductOutputDto> addMember(@RequestBody ProductInputDto productInputDto) {
        return new ResponseEntity<>(productService.addProduct(productInputDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOutputDto> updateMember(@PathVariable Long Barcode, @RequestBody ProductInputDto productInputDto) {
        return new ResponseEntity<>(productService.updateProduct(Barcode, productInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMember(@RequestParam Long Barcode) {
        return new ResponseEntity<>(productService.removeProduct(Barcode), HttpStatus.OK);


    }
}
