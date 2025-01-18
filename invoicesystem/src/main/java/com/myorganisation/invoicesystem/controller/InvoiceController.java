package com.myorganisation.invoicesystem.controller;

import com.myorganisation.invoicesystem.dto.InvoiceInputDto;
import com.myorganisation.invoicesystem.dto.InvoiceOutputDto;
import com.myorganisation.invoicesystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{barcode}")
    public ResponseEntity<InvoiceOutputDto> getInvoice(@PathVariable Long barcode) {
        return new ResponseEntity<>(invoiceService.getInvoice(barcode), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InvoiceOutputDto>> getAllInvoices() {
        return new ResponseEntity<>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InvoiceOutputDto> addInvoice(@RequestBody InvoiceInputDto invoiceInputDto) {
        return new ResponseEntity<>(invoiceService.addProduct(invoiceInputDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceOutputDto> updateInvoice(@PathVariable Long barcode, @RequestBody InvoiceInputDto invoiceInputDto) {
        return new ResponseEntity<>(invoiceService.updateProduct(barcode .
                , invoiceInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/{barcode}")
    public ResponseEntity<String> removeInvoice(@PathVariable Long barcode) {
        return new ResponseEntity<>(invoiceService.removeProduct(barcode), HttpStatus.OK);
    }
}