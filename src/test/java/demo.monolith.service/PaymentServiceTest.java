package demo.monolith.service;

import demo.monolith.model.Payment;
import demo.monolith.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    void should_PersistPayment_When_ProcessingPayment() {
        final String uuid = UUID.randomUUID().toString();

        paymentService.processPayment(uuid);

        verify(paymentRepository, atLeastOnce()).save(any(Payment.class));

    }
}
