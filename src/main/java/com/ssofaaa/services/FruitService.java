package com.ssofaaa.services;

import com.ssofaaa.repositories.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;
}
