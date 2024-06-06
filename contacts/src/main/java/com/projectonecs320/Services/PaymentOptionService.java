package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.projectonecs320.Classes.PaymentOption;
import com.projectonecs320.Interfaces.ServiceInterface;

public class PaymentOptionService implements ServiceInterface {

    private List<PaymentOption> paymentOptions;

    public PaymentOptionService() {
        this.paymentOptions = new ArrayList<>();
    }

    public void addPaymentOption(PaymentOption paymentOption) {
        paymentOptions.add(paymentOption);
    }

    public String generateId() {
        return ServiceInterface.super.generateId();
    }

    public void deletePaymentOption(String cardNumber) {
        Iterator<PaymentOption> iterator = paymentOptions.iterator();
        while (iterator.hasNext()) {
            PaymentOption paymentOption = iterator.next();
            if (paymentOption.getCardNumber().equals(cardNumber)) {
                iterator.remove();
            }
        }
    }

    public List<PaymentOption> getAllPaymentOptions() {
        return paymentOptions;
    }

    public PaymentOption findPaymentOptionByCardNumber(String cardNumber) {
        for (PaymentOption paymentOption : paymentOptions) {
            if (paymentOption.getCardNumber().equals(cardNumber)) {
                return paymentOption;
            }
        }
        return null;
    }

}
