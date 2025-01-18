package com.myorganisation.invoicesystem.service;

import com.myorganisation.invoicesystem.dto.InvoiceInputDto;
import com.myorganisation.invoicesystem.dto.InvoiceOutputDto;
import com.myorganisation.invoicesystem.entity.Invoice;
import com.myorganisation.invoicesystem.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public InvoiceOutputDto getInvoice(Long barcode) {

        Invoice invoice = invoiceRepository.getInvoiceById(barcode);

        InvoiceOutputDto invoiceOutputDto = new InvoiceOutputDto();
        invoiceOutputDto.setBarcode(invoice.getBarcode());
        invoiceOutputDto.setDate(invoice.getDate());
        invoiceOutputDto.setShop(invoice.getShop());
        invoiceOutputDto.setCustomer(invoice.getCustomer());
        invoiceOutputDto.setProduct(invoice.getProduct());
        invoiceOutputDto.setQuantity(invoice.getQuantity());
        invoiceOutputDto.setTotal(invoice.getTotal());

        return invoiceOutputDto;

    }

    @Override
    public List<InvoiceOutputDto> getAllInvoice() {
       List<Invoice> invoiceList = new ArrayList<>(invoiceRepository.getInvoice().values());

       List<InvoiceOutputDto> invoiceOutputDtoList = new ArrayList<>();

       for(Invoice invoice : invoiceList){
           InvoiceOutputDto invoiceOutputDto = new InvoiceOutputDto();

           invoiceOutputDto.setBarcode(invoice.getBarcode());
           invoiceOutputDto.setDate(invoice.getDate());
           invoiceOutputDto.setShop(invoice.getShop());
           invoiceOutputDto.setCustomer(invoice.getCustomer());
           invoiceOutputDto.setProduct(invoice.getProduct());
           invoiceOutputDto.setQuantity(invoice.getQuantity());
           invoiceOutputDto.setTotal(invoice.getTotal());

           invoiceOutputDtoList.add((invoiceOutputDto));
       }
       return invoiceOutputDtoList;
    }

    @Override
    public InvoiceOutputDto addProduct(InvoiceInputDto invoiceInputDto) {
       Invoice invoice = new Invoice();

        invoice.setBarcode(invoiceRepository.generateBarcode());
        invoice.setShop(invoiceInputDto.getShop());
        invoice.setCustomer(invoiceInputDto.getCustomer());
        invoice.setCustomer(invoiceInputDto.getCustomer());
        invoice.setQuantity(invoiceInputDto.getQuantity());

        invoiceRepository.addInvoice(invoice);

        InvoiceOutputDto invoiceOutputDto = new InvoiceOutputDto();

        invoiceOutputDto.setBarcode(invoice.getBarcode());
        invoiceOutputDto.setShop(invoice.getShop());
        invoiceOutputDto.setCustomer(invoice.getCustomer());
        invoiceOutputDto.setQuantity(invoice.getQuantity());

        return invoiceOutputDto;

    }

    @Override
    public InvoiceOutputDto updateProduct(Long id, InvoiceInputDto invoiceInputDto) {
       Invoice invoice = new Invoice();

       invoice.setBarcode(invoiceRepository.generateBarcode());
       invoice.setShop(invoiceInputDto.getShop());
       invoice.setCustomer(invoiceInputDto.getCustomer());
       invoice.setQuantity(invoiceInputDto.getQuantity());

       invoiceRepository.addInvoice((invoice));

       InvoiceOutputDto invoiceOutputDto = new InvoiceOutputDto();

       invoiceOutputDto.setBarcode(invoice.getBarcode());
       invoiceOutputDto.setDate(invoice.getDate());
       invoiceOutputDto.setShop(invoice.getShop());
       invoiceOutputDto.setCustomer(invoice.getCustomer());
       invoiceOutputDto.setProduct(invoice.getProduct());
       invoiceOutputDto.setQuantity(invoice.getQuantity());
       invoiceOutputDto.setTotal(invoice.getTotal());

       return invoiceOutputDto;
    }

    @Override
    public String removeProduct(Long barcode) {
        String invoiceName = invoiceRepository.getInvoiceById(barcode).getCustomer();

        invoiceRepository.removeInvoiceById(barcode);

        return "Invoice : " + invoiceName + "and their Barcode : " + barcode + "has been remove successfully! ";
    }
}
