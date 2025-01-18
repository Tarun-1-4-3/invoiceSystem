package com.myorganisation.invoicesystem.service;

import com.myorganisation.invoicesystem.dto.InvoiceInputDto;
import com.myorganisation.invoicesystem.dto.InvoiceOutputDto;

import java.util.List;

public interface InvoiceService {
    public InvoiceOutputDto getInvoice(Long barcode);
    List<InvoiceOutputDto> getAllInvoice();
    InvoiceOutputDto addProduct(InvoiceInputDto invoiceInputDto);
    InvoiceOutputDto updateProduct(Long id, InvoiceInputDto invoiceInputDto);
    String removeProduct(Long barcode);
}
