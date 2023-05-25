package com.retailstore.dao;

import com.retailstore.constants.ReturnResult;
import com.retailstore.modal.RetailStore;
import com.retailstore.service.RetailStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.retailstore.constants.ReturnResultStatus.*;


@Component
public class RetailStoreServiceImpl implements RetailStoreService {

    @Autowired
    RetailStoreJpaRepository repository;

    @Override
    public List<RetailStore> getAllRetailStoreInfo() {
        return repository.findAll();
    }

    @Override
    public ReturnResult addRetailStore(RetailStore retailStore) {
        ReturnResult result;
        try {
            repository.save(retailStore);
            result = new ReturnResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ReturnResult(ERROR, "Internal Server Error");
        }
        return result;
    }

    @Override
    public ReturnResult updateRetailStore(int storeId, RetailStore retailStore) {
        RetailStore retailStoreFromDb = getRetailStoreById(storeId);
        if(retailStoreFromDb == null) {
            return new ReturnResult(ERROR, "Retail Store  Found for Id "+storeId);
        }

        if(!Objects.equals(retailStoreFromDb.getSku(), retailStore.getSku())) {
            retailStoreFromDb.setSku(retailStore.getSku());
        }

        if(!Objects.equals(retailStoreFromDb.getDate(), retailStore.getDate())) {
            retailStoreFromDb.setDate(retailStore.getDate());
        }

        if(retailStoreFromDb.getPrice() != retailStore.getPrice()) {
            retailStoreFromDb.setPrice(retailStore.getPrice());
        }

        if(!Objects.equals(retailStoreFromDb.getProductName(), retailStore.getProductName())) {
            retailStoreFromDb.setProductName(retailStore.getProductName());
        }
        repository.save(retailStore);
        return new ReturnResult(SUCCESS);
    }

    @Override
    public ReturnResult deleteRetailStore(int storeId) {
        ReturnResult result;
        try {
            RetailStore retailStore = getRetailStoreById(storeId);
            if(retailStore == null) {
                result = new ReturnResult(ERROR, "Retail Store  Found for Id "+storeId);
                return result;
            }
            repository.delete(retailStore);
            result = new ReturnResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ReturnResult(ERROR, "Internal Server Error");
        }
        return result;
    }

    @Override
    public RetailStore getRetailStoreById(int storeId) {
        return repository.findByStoreId(storeId).orElse(null);
    }
}
