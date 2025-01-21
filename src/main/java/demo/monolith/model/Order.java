package demo.monolith.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {

    @Id
    private String id;
    private String userId;
    private double amount;
    private String status;
}
