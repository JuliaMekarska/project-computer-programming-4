package pl.jmekarska.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ReservationStorageTest {

    @Autowired
    ReservationRepository reservationRepository;
    @Test
    void insert() {
        Reservation reservation = new Reservation();
    }

}
