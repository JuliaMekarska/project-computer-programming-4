package pl.jmekarska.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    private BigDecimal balance;
    public CreditCard(String cardNumber) {
    }

    public void assignLimit(BigDecimal creditAmount) {
        if (creditAmount.compareTo(BigDecimal.valueOf(100)) < 1) {
            throw new CreditBelowThresholdException();
        }
        this.balance = creditAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
