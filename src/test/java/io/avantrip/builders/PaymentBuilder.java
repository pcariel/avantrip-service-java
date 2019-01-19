package io.avantrip.builders;

import java.math.BigDecimal;
import java.util.Date;

import io.avantrip.binding.FlightCreateRequest.Payment;

public class PaymentBuilder {

    private String name;
    private String number;
    private BigDecimal amount;
    private Date datePurchase;

    public PaymentBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PaymentBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public PaymentBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentBuilder withDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
        return this;
    }

    public Payment build() {
        Payment payment = new Payment();
        payment.setName(name);
        payment.setNumber(number);
        payment.setAmount(amount);
        payment.setDatePurchase(datePurchase);
        return payment;
    }

}