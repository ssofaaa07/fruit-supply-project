package com.ssofaaa.repositories;

import com.ssofaaa.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Long, Price> {
}