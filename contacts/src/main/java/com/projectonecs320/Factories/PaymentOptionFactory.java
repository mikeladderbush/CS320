package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.PaymentOption;
import com.projectonecs320.Services.PaymentOptionService;

public class PaymentOptionFactory {

    private static final PaymentOptionService paymentOptionService = new PaymentOptionService();

    // Method to create a PaymentOption with default values
    public static PaymentOption createPaymentOption() {
        String id = paymentOptionService.generateId();
        return new PaymentOption.PaymentOptionBuilder(id).buildPaymentOption();
    }

    public static PaymentOption createPaymentOption(Consumer<PaymentOption.PaymentOptionBuilder> consumer) {
        String id = paymentOptionService.generateId();
        PaymentOption.PaymentOptionBuilder builder = new PaymentOption.PaymentOptionBuilder(id);
        consumer.accept(builder);
        return builder.buildPaymentOption();
    }
}
