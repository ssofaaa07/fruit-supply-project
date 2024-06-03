package com.ssofaaa.repositories;

import com.ssofaaa.entities.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryItemRepository extends JpaRepository<Long, DeliveryItem> {
}