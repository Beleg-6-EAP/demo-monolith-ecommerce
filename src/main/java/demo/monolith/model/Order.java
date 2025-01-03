package demo.monolith.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@RequiredArgsConstructor
public class Order {

    @Id
    private String id;
    private String userId;
    private double amount;
    private String status;
}
