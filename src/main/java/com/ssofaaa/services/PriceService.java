package com.ssofaaa.services;

import com.ssofaaa.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
}
