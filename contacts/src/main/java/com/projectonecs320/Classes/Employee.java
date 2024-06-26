package com.projectonecs320.Classes;

import com.projectonecs320.Enums.PayBasis;
import com.projectonecs320.Enums.Permissions;

/**
 * Represents an Employee.
 */

public class Employee extends User {

    private final String socialSecurityNumber;
    private final String position;
    private final double payrate;
    private final PayBasis paybasis;
    private final double baseEarnings;
    private final Session contactInformation;

    protected Employee(EmployeeBuilder<?> builder) {
        super(builder);
        this.socialSecurityNumber = builder.socialSecurityNumber;
        this.position = builder.position;
        this.payrate = builder.payrate;
        this.paybasis = builder.paybasis;
        this.baseEarnings = builder.baseEarnings;
        this.contactInformation = builder.contactInformation;
    }

    public static class EmployeeBuilder<T extends EmployeeBuilder<T>> extends UserBuilder<T> {

        private String socialSecurityNumber = "000-00-0000";
        private String position = "DEFAULT_HIRE";
        private double payrate = 0.0;
        private PayBasis paybasis = PayBasis.VOLUNTEER;
        private double baseEarnings = 0.0;
        private Session contactInformation;

        public EmployeeBuilder(String id, Permissions permissions) {
            super(id, permissions);
        }

        public T socialSecurityNumber(String value) {
            this.socialSecurityNumber = value;
            return self();
        }

        public T position(String value) {
            this.position = value;
            return self();
        }

        public T payrate(double value) {
            this.payrate = value;
            return self();
        }

        public T paybasis(PayBasis value) {
            this.paybasis = value;
            return self();
        }

        public T baseEarnings(double value) {
            this.baseEarnings = value;
            return self();
        }

        public T contactInformation(Session value) {
            this.contactInformation = value;
            return self();
        }

        @Override
        protected T self() {
            return (T) this;
        }

        @Override
        public Employee buildUser() {
            return new Employee(this);
        }
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getPosition() {
        return position;
    }

    public double getPayrate() {
        return payrate;
    }

    public PayBasis getPaybasis() {
        return paybasis;
    }

    public double getBaseEarnings() {
        return baseEarnings;
    }

    public Session getContactInformation() {
        return contactInformation;
    }
}
