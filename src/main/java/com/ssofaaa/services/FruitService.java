package com.ssofaaa.services;

import com.ssofaaa.entities.Fruit;
import com.ssofaaa.repositories.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> listFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElse(null);
    }
}
