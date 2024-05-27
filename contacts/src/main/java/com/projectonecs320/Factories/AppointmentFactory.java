package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Services.AppointmentService;

public class AppointmentFactory {

    private static final AppointmentService appointmentService = new AppointmentService();

    // Method to create a Appointment with default values
    public static Appointment createAppointment() {
        String id = appointmentService.generateId();
        return new Appointment.AppointmentBuilder(id).buildAppointment();
    }

    public static Appointment createAppointment(Consumer<Appointment.AppointmentBuilder> consumer) {
        String id = appointmentService.generateId();
        Appointment.AppointmentBuilder builder = new Appointment.AppointmentBuilder(id);
        consumer.accept(builder);
        return builder.buildAppointment();
    }
}
