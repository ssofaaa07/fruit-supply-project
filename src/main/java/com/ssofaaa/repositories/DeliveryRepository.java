package com.ssofaaa.repositories;

import com.ssofaaa.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDeliveryDateBetweenOrderByDeliveryDate(Date startDate, Date endDate);
    List<Delivery> findAllByOrderByIdDesc();
}