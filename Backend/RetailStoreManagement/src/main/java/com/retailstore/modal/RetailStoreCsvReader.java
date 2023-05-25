package com.retailstore.modal;

import com.retailstore.parser.CSVCell;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RetailStoreCsvReader implements Serializable {
    @CSVCell(label = "Store ID")
    private int storeId;

    @CSVCell(label = "SKU")
    private String sku;

    @CSVCell(label = "Product Name")
    private String productName;

    @CSVCell(label = "Price")
    private double price;

    @CSVCell(label = "Date")
    private String date;

    public RetailStore getRetailStore() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(getDate());

        return new RetailStore(getStoreId(),getSku(),getProductName(),getPrice(),date);
    }
}
