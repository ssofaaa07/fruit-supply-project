package com.ssofaaa.services;

import com.ssofaaa.entities.Fruit;
import com.ssofaaa.entities.Price;
import com.ssofaaa.entities.Supplier;
import com.ssofaaa.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public BigDecimal getPrice(Supplier supplier, Fruit fruit, Date date) {
        return priceRepository.getPriceBySupplierIdAndFruitIdAndDate(supplier.getId(), fruit.getId(), date);
    }
}
