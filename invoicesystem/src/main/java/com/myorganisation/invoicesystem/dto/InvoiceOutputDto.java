package com.myorganisation.invoicesystem.dto;

import com.myorganisation.invoicesystem.entity.Product;
import lombok.Data;

import java.util.Date;
@Data
public class InvoiceOutputDto {
    private  Long id;
    private Date date;
    private  String shop;
    private String customer;
    private Product product;
    private Long quantity;
    private Double total;
}
