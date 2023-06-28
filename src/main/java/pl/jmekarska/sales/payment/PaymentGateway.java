package pl.jmekarska.sales.payment;

public interface PaymentGateway {
    PaymentData register(RegisterPaymentRequest request);
}