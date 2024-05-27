package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.PaymentOption;
import com.projectonecs320.Interfaces.ServiceInterface;

//TODO edit the functions to use the serviceInterface
public class PaymentOptionService implements ServiceInterface {

    private List<PaymentOption> paymentOptions;

    public PaymentOptionService() {
        this.paymentOptions = new ArrayList<>();
    }

    public void addPaymentOption(PaymentOption paymentOption) {
        paymentOptions.add(paymentOption);
    }

    public String generateId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int j = random.nextInt(chars.length());
            char randomChar = chars.charAt(j);
            randomString.append(randomChar);
        }
        return randomString.toString();
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
