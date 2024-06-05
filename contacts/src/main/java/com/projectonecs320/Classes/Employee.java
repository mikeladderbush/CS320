package com.projectonecs320.Classes;

import com.projectonecs320.Enums.PayBasis;
import com.projectonecs320.Enums.Permissions;

/**
 * Represents an Admin.
 */

 // Update to allow for inheritance of generics.
public class Employee extends User {

    private final String socialSecurityNumber;
    private final String position;
    private final double payrate;
    private final PayBasis paybasis;
    private final double baseEarnings;
    private final Contact contactInformation;

    private Employee(EmployeeBuilder builder) {
        super(builder);
        this.socialSecurityNumber = builder.socialSecurityNumber;
        this.position = builder.position;
        this.payrate = builder.payrate;
        this.paybasis = builder.paybasis;
        this.baseEarnings = builder.baseEarnings;
        this.contactInformation = builder.contactInformation;
    }

    public static class EmployeeBuilder extends User.UserBuilder<EmployeeBuilder> {

        private String socialSecurityNumber = "000-00-0000";
        private String position = "DEFAULT_HIRE";
        private double payrate = 0.0;
        private PayBasis paybasis = PayBasis.VOLUNTEER;
        private double baseEarnings = 0.0;
        private Contact contact;

        public EmployeeBuilder(String id, Permissions permissions) {
            super(id, permissions);
        }

        public EmployeeBuilder socialSecurityNumber(String value) {
            this.socialSecurityNumber = value;
            return self();
        }

        public EmployeeBuilder position(String value) {
            this.position = value;
            return self();
        }

        public EmployeeBuilder payrate(double value) {
            this.payrate = value;
            return self();
        }

        public EmployeeBuilder paybasis(PayBasis value) {
            this.paybasis = value;
            return self();
        }

        public EmployeeBuilder baseEarnings(double value) {
            this.baseEarnings = value;
            return self();
        }

        public EmployeeBuilder contactInformation(Contact value) {
            this.contactInformation = value;
            return self();
        }

        @Override
        protected EmployeeBuilder self() {
            return this;
        }

        @Override
        public Employee buildUser() {
            return new Employee(this);
        }
    }
}
