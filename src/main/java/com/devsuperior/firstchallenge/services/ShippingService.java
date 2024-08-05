package com.devsuperior.firstchallenge.services;

import com.devsuperior.firstchallenge.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basic = order.getBasic();

        if (basic < 100D) {
            return 20D;
        } else if (basic >= 100D && basic <= 200D) {
            return 12D;
        } else {
            return 0D;
        }
    }
}
