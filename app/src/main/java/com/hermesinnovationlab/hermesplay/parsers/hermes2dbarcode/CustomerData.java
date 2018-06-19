package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class CustomerData {
    private final String customerRef1;
    private final String customerRef2;

    private CustomerData(CustomerDataBuilder builder) {
        this.customerRef1 = builder.customerRef1;
        this.customerRef2 = builder.customerRef2;
    }

    public String getCustomerRef1() {
        return customerRef1;
    }

    public String getCustomerRef2() {
        return customerRef2;
    }

    public static class CustomerDataBuilder {
        private String customerRef1;
        private String customerRef2;

        public CustomerDataBuilder customerRef1(String customerRef1) {
            this.customerRef1 = customerRef1;
            return this;
        }

        public CustomerDataBuilder customerRef2(String customerRef2) {
            this.customerRef2 = customerRef2;
            return this;
        }

        public CustomerData build() {
            return new CustomerData(this);
        }
    }
}
