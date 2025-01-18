package com.myorganisation.invoicesystem.dto;

import lombok.Data;

@Data
public class InvoiceInputDto {
    private  Long Barcode;
    private  String shop;
    private String customer;
    private Long quantity;
}
