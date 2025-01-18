package com.myorganisation.invoicesystem.entity;

import lombok.Data;

@Data
public class Product {

    private Long barcode;
    private String name;
    private Double mrp;


}
