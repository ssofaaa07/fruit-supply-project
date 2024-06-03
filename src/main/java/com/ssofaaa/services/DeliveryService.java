package com.ssofaaa.services;

import com.ssofaaa.repositories.DeliveryItemRepository;
import com.ssofaaa.repositories.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryItemRepository deliveryItemRepository;
}
