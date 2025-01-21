package demo.monolith.service;

import demo.monolith.model.Shipment;
import demo.monolith.repository.ShipmentRepository;
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
public class ShipmentServiceTest {

    @InjectMocks
    private ShipmentService shipmentService;

    @Mock
    private ShipmentRepository shipmentRepository;

    @Test
    void should_PersistShipment_When_HandlingShipping() {
        final String uuid = UUID.randomUUID().toString();

        shipmentService.handleShipping(uuid);

        verify(shipmentRepository, atLeastOnce()).save(any(Shipment.class));

    }
}
