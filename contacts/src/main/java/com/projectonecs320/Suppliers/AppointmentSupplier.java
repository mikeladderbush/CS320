package com.projectonecs320.Suppliers;

import java.util.function.Supplier;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Services.AppointmentService;

public class AppointmentSupplier implements Supplier<Appointment> {

    private AppointmentService appointmentService;

    public AppointmentSupplier(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    
    @Override
    public Appointment get() {
        return new Appointment (appointmentService.generateId());
    }
    
}
