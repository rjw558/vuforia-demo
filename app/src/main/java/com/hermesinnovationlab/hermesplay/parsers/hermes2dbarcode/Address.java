package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class Address {
    public static final String DEFAULT_COUNTRY_CODE = "GB";
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String addressLine6;
    private String postcode;
    private String countryCode;

    private Address(AddressBuilder builder) {
        this.postcode = builder.postcode;
        this.countryCode = builder.countryCode;
        this.addressLine1 = builder.addressLine1;
        this.addressLine2 = builder.addressLine2;
        this.addressLine3 = builder.addressLine3;
        this.addressLine4 = builder.addressLine4;
        this.addressLine5 = builder.addressLine5;
        this.addressLine6 = builder.addressLine6;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public String getAddressLine5() {
        return addressLine5;
    }

    public String getAddressLine6() {
        return addressLine6;
    }


    public static class AddressBuilder {
        private final String postcode;
        private final String countryCode;
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String addressLine4;
        private String addressLine5;
        private String addressLine6;

        public AddressBuilder(String postcode) {
            this(postcode, DEFAULT_COUNTRY_CODE);
        }

        public AddressBuilder(String postcode, String countryCode) {
            this.postcode = postcode;
            this.countryCode = countryCode;
        }

        public AddressBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public AddressBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public AddressBuilder addressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        public AddressBuilder addressLine4(String addressLine4) {
            this.addressLine4 = addressLine4;
            return this;
        }

        public AddressBuilder addressLine5(String addressLine5) {
            this.addressLine5 = addressLine5;
            return this;
        }

        public AddressBuilder addressLine6(String addressLine6) {
            this.addressLine6 = addressLine6;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
