package com.projectonecs320.Classes;

import com.projectonecs320.Enums.Permissions;

/**
 * Represents an Admin.
 */
public class Administrator extends Employee {

    private final String adminLevel;

    private Administrator(AdministratorBuilder builder) {
        super(builder);
        this.adminLevel = builder.adminLevel;
    }

    public static class AdministratorBuilder extends EmployeeBuilder<AdministratorBuilder> {

        private String adminLevel = "DEFAULT ADMIN";

        public AdministratorBuilder(String id, Permissions permissions) {
            super(id, permissions);
        }

        public AdministratorBuilder adminLevel(String value) {
            this.adminLevel = value;
            return self();
        }

        @Override
        protected AdministratorBuilder self() {
            return this;
        }

        @Override
        public Administrator buildUser() {
            return new Administrator(this);
        }
    }

    public String getAdminLevel() {
        return adminLevel;
    }
}
