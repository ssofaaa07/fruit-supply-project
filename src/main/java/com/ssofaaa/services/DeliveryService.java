package com.ssofaaa.services;

import com.ssofaaa.entities.Delivery;
import com.ssofaaa.entities.DeliveryItem;
import com.ssofaaa.entities.Fruit;
import com.ssofaaa.entities.Supplier;
import com.ssofaaa.forms.DeliveryForm;
import com.ssofaaa.repositories.DeliveryItemRepository;
import com.ssofaaa.repositories.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private final DeliveryItemRepository deliveryItemRepository;

    private final SupplierService supplierService;
    private final FruitService fruitService;
    private final PriceService priceService;

    public void saveDelivery(DeliveryForm deliveryForm) {
        if(deliveryForm.getDeliveryDate() != null) {
            Delivery delivery = new Delivery();
            Supplier supplier = supplierService.getSupplierById(deliveryForm.getSupplier());
            Date deliveryDate = deliveryForm.getDeliveryDate();

            delivery.setDeliveryDate(deliveryDate);
            delivery.setSupplier(supplier);
            deliveryRepository.save(delivery);

            BigDecimal sumPrice = new BigDecimal(0);
            for (Map.Entry<Long, Integer> entry : deliveryForm.getCountOfFruits().entrySet()) {
                if (entry.getValue() != null) {
                    DeliveryItem deliveryItem = new DeliveryItem();
                    Fruit fruit = fruitService.getFruitById(entry.getKey());
                    Integer countOfFruits = entry.getValue();
                    BigDecimal unitPrice = priceService.getPrice(supplier, fruit, deliveryDate);
                    if (unitPrice == null) {
                        deliveryRepository.delete(delivery);
                        return;
                    }
                    deliveryItem.setDelivery(delivery);
                    deliveryItem.setFruit(fruit);
                    deliveryItem.setCountOfFruits(countOfFruits);
                    deliveryItem.setUnitPrice(unitPrice);
                    deliveryItem.setSumPrice(getSumPrice(unitPrice, countOfFruits));
                    deliveryItemRepository.save(deliveryItem);

                    sumPrice = sumPrice.add(getSumPrice(unitPrice, countOfFruits));
                }
            }

            delivery.setSumPrice(sumPrice);
            deliveryRepository.save(delivery);
        }
    }

    private BigDecimal getSumPrice(BigDecimal unitPrice, Integer count) {
        BigDecimal countBig = new BigDecimal(count);
        return unitPrice.multiply(countBig);
    }
    public List<Delivery> listDeliveries() {
        return deliveryRepository.findAll();
    }
    public List<DeliveryItem> listDeliveryItemsByDeliveryId(Long id) {
        return deliveryItemRepository.findAllByDeliveryId(id);
    }
    public List<Delivery> listDeliveriesByDeliveryDateBetween(Date startDate, Date endDate) {
        return deliveryRepository.getAllByDeliveryDateBetween(startDate, endDate);
    }

    public long count() {
        return deliveryRepository.count();
    }
}
