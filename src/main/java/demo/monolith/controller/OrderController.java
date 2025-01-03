package demo.monolith.controller;

import demo.monolith.model.Order;
import demo.monolith.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody Order orderMono) {
        orderService.create(orderMono);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
