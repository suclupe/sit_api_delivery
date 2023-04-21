package com.delivery.api_delivery.controller;

import com.delivery.api_delivery.entities.Food;
import com.delivery.api_delivery.entities.Order;
import com.delivery.api_delivery.services.OrderService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;
    private List<Food> menu;

    public OrderController() {
        menu = new ArrayList<>();
        menu.add(new Food("Hamburguesa", "Hamburguesa de carne con lechuga, tomate y queso", 10.0));
        menu.add(new Food("Pizza", "Pizza con salsa de tomate, queso y pepperoni", 12.0));
        menu.add(new Food("Ensalada", "Ensalada mixta con pollo, tomate, pepino y aderezo ranch", 8.0));
        orderService = new OrderService(new ArrayList<>());
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Food>> getMenu() {
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Assign an id and creation time to the order
        order.setId(orderService.getAllOrders().size() + 1);
        order.setCreationTime(new Date());

        // Set an estimated delivery time 30 minutes from now
        Date estimatedDeliveryTime = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        order.setEstimatedDeliveryTime(estimatedDeliveryTime);

        // Add the order to the order service
        orderService.addOrder(order);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
