package com.devsuperior.firstchallenge.services;

import com.devsuperior.firstchallenge.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double basic = order.getBasic();

        double shipment = shippingService.shipment(order);
        double discountValue = basic * (order.getDiscount() / 100);

        return basic + shipment - discountValue;
    }
}
