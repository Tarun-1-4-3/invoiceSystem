package com.myorganisation.invoicesystem.dto;

import lombok.Data;

@Data
public class ProductOutputDto {
    private Long barcode;
    private String name;
    private Double mrp;
}
