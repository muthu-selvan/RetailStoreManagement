package com.retailstore.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "RETAIL_STORE")
@IdClass(RetailStore.class)
public class RetailStore  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STORE_ID")
    private int storeId;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "DATE")
    private Date date;


    public String getSku() {
        if(sku == null) {
            return null;
        }
        return sku.toUpperCase(Locale.ROOT).strip();
    }

    public String getProductName() {
        if(productName == null) {
            return null;
        }
        return productName.strip();
    }
}
