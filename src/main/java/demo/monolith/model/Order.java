package demo.monolith.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Order {

    @Id
    private String id;
    private String userId;
    private double amount;
    private String status;
}
