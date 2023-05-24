package pl.jmekarska.sales;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Reservation {
    @Id
    String id;
    BigDecimal total;
    String paymentId;


    public Reservation() {
        this.id = id;
        this.total = total;
        this.paymentId = paymentId;
    }
}
