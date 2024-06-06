package com.projectonecs320.Services;

import com.projectonecs320.Interfaces.ServiceInterface;

public class EmployeeService implements ServiceInterface {
    
    public String generateId() {
        return ServiceInterface.super.generateId();
    }

}
