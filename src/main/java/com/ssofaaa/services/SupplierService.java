package com.ssofaaa.services;

import com.ssofaaa.entities.Supplier;
import com.ssofaaa.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> listSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
