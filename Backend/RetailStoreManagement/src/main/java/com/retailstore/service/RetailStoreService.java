package com.retailstore.service;


import com.retailstore.constants.ReturnResult;
import com.retailstore.modal.RetailStore;

import java.util.List;

public interface RetailStoreService {
    List<RetailStore> getAllRetailStoreInfo();
    ReturnResult addRetailStore(RetailStore retailStore);
    ReturnResult updateRetailStore(int storeId, RetailStore retailStore);
    ReturnResult deleteRetailStore(int storeId);
    RetailStore getRetailStoreById(int storeId);
}
