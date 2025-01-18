package com.myorganisation.invoicesystem.repository;

import com.myorganisation.invoicesystem.entity.Invoice;
import com.myorganisation.invoicesystem.entity.Product;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class InvoiceRepository {

    @Getter
    private Map<Long, Invoice> invoice = new HashMap<>();

    private Long Barcode = 202501140L;

    public Map<Long, Invoice> getInvoice() {
        return this.invoice;
    }

    public  Invoice getInvoiceById(Long barcode){
        return this.invoice.get(barcode);
    }

    public void addInvoice(Invoice invoice) {
        this.invoice.put(invoice.getBarcode(), invoice);
    }
    public void removeInvoiceById(Long id){
        this.invoice.remove(Barcode);
    }

    public Long getBarcode(){
        return this.Barcode;
    }
    public  Long generateBarcode(){
        return ++Barcode;
    }
}
