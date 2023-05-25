package com.retailstore.constants;

public enum RetailStoreConstants {
    RESTORE("restore");

    private final String value ;

    RetailStoreConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
