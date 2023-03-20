package pl.jmekarska.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("8765-4321");

        //Act
        card.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itCantAssignLimitBelow100(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("3234-9897");
        CreditCard card3 = new CreditCard("1492-9305");

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(
                () -> card3.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void itCantAssignLimitBelow100V1(){
        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itDenyToAssignCreditLimitTwice(){
        CreditCard card = new CreditCard("7463-8535");
        card.assignCredit(BigDecimal.valueOf(1000));

    }

    @Test
    void itAllowsToWithdraw(){
        CreditCard card = new CreditCard("6653-8622");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }
}
