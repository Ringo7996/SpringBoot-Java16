package vn.techmaster.hellojpa.demoOrder;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail {
    @EmbeddedId
    private  OrderDetailId orderDetailId;
    private int quantity;
    private float price;
    private float amount;
}
