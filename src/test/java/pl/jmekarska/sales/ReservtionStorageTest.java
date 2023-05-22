package pl.jmekarska.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ReservtionStorageTest {

    @Autowired
    ReservationRepository reservationRepository;
    @Test
    void insert() {
        Reservation reservation = new Reservation(String id, BigDecimal total, String paymentId) {

        }
    }

    @Test
    void select() {
        }
    }

}
