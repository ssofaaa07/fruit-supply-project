package com.ssofaaa.controllers;

import com.ssofaaa.entities.Delivery;
import com.ssofaaa.entities.DeliveryItem;
import com.ssofaaa.entities.Fruit;
import com.ssofaaa.entities.Supplier;
import com.ssofaaa.forms.DeliveryForm;
import com.ssofaaa.services.DeliveryService;
import com.ssofaaa.services.FruitService;
import com.ssofaaa.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SupplyController {

    private final FruitService fruitService;
    private final SupplierService supplierService;
    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("title", "Приемка поставок");
        List<Delivery> deliveries = deliveryService.listDeliveries();
        model.addAttribute("deliveries", deliveries);
        List<Supplier> suppliers = supplierService.listSuppliers();
        model.addAttribute("suppliers", suppliers);
        List<Fruit> fruits = fruitService.listFruits();
        model.addAttribute("fruits", fruits);
        model.addAttribute("deliveryForm", new DeliveryForm());
        return "index";
    }

    @PostMapping("/take")
    public String deliveryForm(@ModelAttribute("deliveryForm") DeliveryForm deliveryForm) {
        deliveryService.saveDelivery(deliveryForm);
        return "redirect:/";
    }
}
