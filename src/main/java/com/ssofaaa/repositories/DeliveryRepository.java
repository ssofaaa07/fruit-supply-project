package com.ssofaaa.repositories;

import com.ssofaaa.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Long, Delivery> {
}