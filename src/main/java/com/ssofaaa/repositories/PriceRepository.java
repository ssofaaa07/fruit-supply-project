package com.ssofaaa.repositories;

import com.ssofaaa.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT price FROM Prices " +
            "WHERE supplier_id = :supplier_id " +
            "AND fruit_id = :fruit_id " +
            "AND :date BETWEEN start_date AND end_date", nativeQuery = true)
    BigDecimal getPriceBySupplierIdAndFruitIdAndDate(
            @Param("supplier_id") Long supplierId,
            @Param("fruit_id") Long fruitId,
            @Param("date") Date date);

}