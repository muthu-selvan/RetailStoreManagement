package com.retailstore.dao;

import com.retailstore.modal.RetailStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetailStoreJpaRepository extends JpaRepository<RetailStore,Integer> {
    Optional<RetailStore> findByStoreId(int storeId);
}
