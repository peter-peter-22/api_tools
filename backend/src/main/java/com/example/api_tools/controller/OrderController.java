package com.example.api_tools.controller;

import com.example.api_tools.dto.OrderCreateRequest;
import com.example.api_tools.model.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/orders")
@Validated
@Tag(name = "orders", description = "Order management APIs")
public class OrderController {

    private final List<Order> orders = new CopyOnWriteArrayList<>();
    private long idCounter = 1;

    @PostMapping
    @Operation(summary = "Create a new order")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderCreateRequest request) {
        Order user = new Order(idCounter++, request.itemId(), request.count(), request.userId());
        orders.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    @Operation(summary = "Get all orders")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orders);
    }
}
