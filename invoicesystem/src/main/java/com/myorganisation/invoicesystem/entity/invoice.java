package com.myorganisation.invoicesystem.entity;

import lombok.Data;

import java.util.Date;
@Data
public class invoice {
    private  Long id;
    private Date date;
    private  String shop;
    private String customer;
    private Product product;
    private Long quantity;
    private Double total;
}
