package pl.jmekarska.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal limit;
    private String cardNumber;
    private int billingCycles;
    private Boolean isAssigned;

    public CreditCard(String cardNumber){
        this.cardNumber=cardNumber;
        this.billingCycles=0;
        this.isAssigned=false;
    }
    public void assignCredit(BigDecimal creditAmount) {
        this.balance = creditAmount;
    }
    public void assignLimit(BigDecimal creditAmount) {
        if(isLimitAlreadyAssigned()){
            throw new ReassignLimitExceptions();
        }

        if (isCreditBelowThreshold(creditAmount)) {
            throw new CreditBelowThresholdException();
        }

        this.limit = creditAmount;
        this.isAssigned = true;
    }

    private boolean isLimitAlreadyAssigned() {
        return isAssigned == true;
    }
    private boolean isCreditBelowThreshold(BigDecimal creditAmount){
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
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
    public void withdraw(BigDecimal money) {
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