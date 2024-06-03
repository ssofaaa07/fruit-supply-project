package com.ssofaaa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "DeliveryItems")
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryItemId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "fruit_id")
    private Fruit fruit;

    private int countOfFruits;
}
