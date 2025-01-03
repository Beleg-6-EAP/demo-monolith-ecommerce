package demo.monolith.service;

import demo.monolith.model.Order;
import demo.monolith.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    public Order create(Order order) {
        final Order savedOrder = orderRepository.save(order);
        paymentService.processPayment(savedOrder.getId());

        return savedOrder;
    }
}
