package demo.monolith.service;

import demo.monolith.model.Order;
import demo.monolith.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final ShipmentService shipmentService;

    public Order create(Order order) {
        final Order savedOrder = orderRepository.save(order);
        paymentService.processPayment(savedOrder.getId());
        shipmentService.handleShipping(savedOrder.getId());

        return savedOrder;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
