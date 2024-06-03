package com.ssofaaa.repositories;

import com.ssofaaa.entities.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Long, Fruit> {
}