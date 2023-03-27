package pl.jmekarska.creditcard;

import org.junit.jupiter.api.Test;
import pl.jmekarska.creditcard.CreditCard;
import pl.jmekarska.creditcard.ReassignLimitExceptions;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit() throws ReassignLimitExceptions {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");

        //Act
        card.assignLimit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignCreditLimits() throws ReassignLimitExceptions {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        //Act
        card1.assignLimit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
    }

    @Test
    void itCantAssignLimitBelow100(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");

        assertThrows(CreditBelowThresholdException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card2.assignLimit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card2.assignLimit(BigDecimal.valueOf(100)));
    }

    @Test
    void itCantAssignLimitBelow100V1() throws ReassignLimitExceptions {
        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignLimit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itCantAssignLimitTwice(){
        CreditCard card = new CreditCard("1234-1234");

        assertDoesNotThrow(() -> card.assignLimit(BigDecimal.valueOf(100)));
        assertThrows(ReassignLimitExceptions.class, () -> card.assignLimit(BigDecimal.valueOf(110)));
    }

    @Test
    void itAllowsToWithdraw() throws CantWithdrawTenTimesException, MoneyExceededLimitException, NotEnoughMoneyException, ReassignLimitExceptions {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900),card.getBalance());
    }

    @Test
    void itCantWithdrawOverTheLimit() throws ReassignLimitExceptions {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(100));
        card.assignCredit(BigDecimal.valueOf(500));

        assertThrows(MoneyExceededLimitException.class, () -> card.withdraw(BigDecimal.valueOf(101)));
    }

    @Test
    void itCantWithdrawWithNotEnoughMoney() throws ReassignLimitExceptions {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(100));
        card.assignCredit(BigDecimal.valueOf(500));

        assertThrows(NotEnoughMoneyException.class, () -> card.withdraw(BigDecimal.valueOf(501)));
    }

    @Test
    void itCantWithdrawMoreThanTenTimes() throws ReassignLimitExceptions, CantWithdrawTenTimesException, MoneyExceededLimitException, NotEnoughMoneyException {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(100));
        card.assignCredit(BigDecimal.valueOf(500));

        for (int i=0; i<10; i++){
            card.withdraw(BigDecimal.valueOf(10));
        }

        assertThrows(CantWithdrawTenTimesException.class, () -> card.withdraw(BigDecimal.valueOf(10)));
    }

    @Test
    void checkIfWithdrawsCorrectly() throws ReassignLimitExceptions, CantWithdrawTenTimesException, MoneyExceededLimitException, NotEnoughMoneyException {
        CreditCard card = new CreditCard("1234-5678");
        card.assignLimit(BigDecimal.valueOf(100));
        card.assignCredit(BigDecimal.valueOf(500));

        for (int i=0; i<10; i++){
            card.withdraw(BigDecimal.valueOf(10));
        }
        assert card.getBalance().equals(BigDecimal.valueOf(400));
    }
}