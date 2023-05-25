package com.retailstore.controller;

import com.retailstore.constants.ReturnResult;
import com.retailstore.modal.RetailStore;
import com.retailstore.service.RetailStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/rms")
public class RetailStoreController {

    @Autowired
    RetailStoreService retailStoreService;

    @GetMapping(path = "/retailStores")
    public List<RetailStore> getAllRetailStoreInfo() {
        return retailStoreService.getAllRetailStoreInfo();
    }

    @GetMapping(path = "/retailStore/{storeId}")
    public RetailStore getRetailStoreById(@PathVariable("storeId") int storeId) {
        return retailStoreService.getRetailStoreById(storeId);
    }

    @DeleteMapping(path = "/retailStore/{storeId}")
    public ReturnResult deleteRetailStore(@PathVariable("storeId") int storeId) {
        return retailStoreService.deleteRetailStore(storeId);
    }

    @PostMapping(path = "/retailStore", consumes = "application/json")
    public ReturnResult addRetailStore(RetailStore retailStore) {
        return retailStoreService.addRetailStore(retailStore);
    }

    @PutMapping(path = "/retailStore/{storeId}")
    public ReturnResult updateRetailStore(@PathVariable("storeId") int storeId,
                                          @RequestBody RetailStore retailStore) {
        return retailStoreService.updateRetailStore(storeId, retailStore);
    }
}
