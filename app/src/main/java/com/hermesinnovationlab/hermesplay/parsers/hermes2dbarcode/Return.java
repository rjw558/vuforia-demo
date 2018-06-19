package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class Return {
    private String name;
    private Address address;

    private Return(ReturnBuilder builder) {
        this.name = name;
        this.address = builder.addressBuilder.build();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public static class ReturnBuilder {
        private String name;
        private Address.AddressBuilder addressBuilder;

        public ReturnBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ReturnBuilder addressBuilder(Address.AddressBuilder addressBuilder) {
            this.addressBuilder = addressBuilder;
            return this;
        }

        public Return build() {
            return new Return(this);
        }
    }
}
