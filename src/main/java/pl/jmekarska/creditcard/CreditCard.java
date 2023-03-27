package pl.jmekarska.creditcard;

import pl.jmekarska.creditcard.*;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal limit;
    private String cardNumber;
    private int billingCycles;

    public CreditCard(String cardNumber){
        this.cardNumber=cardNumber;
        this.billingCycles=0;
    }
    public void assignCredit(BigDecimal creditAmount) {
        this.balance = creditAmount;
    }
    public void assignLimit(BigDecimal creditAmount) throws ReassignLimitExceptions {
        if(isLimitAlreadyAssigned()){
            throw new ReassignLimitExceptions();
        }

        if (isCreditBelowThreshold(creditAmount)) {
            throw new CreditBelowThresholdException();
        }

        this.limit = creditAmount;
    }

    private boolean isLimitAlreadyAssigned() {
        return balance != null;
    }
    private boolean isCreditBelowThreshold(BigDecimal creditAmount){
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;//checking if the given creditAmount is lower than 100PLN, bc limit can't be lower than 100PLN
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getLimit(){
        return this.limit;
    }

    public int getBillingCycles(){
        return this.billingCycles;
    }
    public void withdraw(BigDecimal money) throws MoneyExceededLimitException, NotEnoughMoneyException, CantWithdrawTenTimesException {
        if (getBalance().compareTo(money) < 0) {
            throw new NotEnoughMoneyException();
        }

        if (getLimit().compareTo(money) < 0) {
            throw new MoneyExceededLimitException();
        }

        if (getBillingCycles() > 9) {
            throw new CantWithdrawTenTimesException();
        }

        this.balance = balance.subtract(money);
        this.billingCycles+=1;
    }
}