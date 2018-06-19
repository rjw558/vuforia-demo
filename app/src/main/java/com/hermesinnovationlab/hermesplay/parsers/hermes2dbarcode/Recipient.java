package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

public class Recipient {
    private String name;
    private Address address;
    private String mobilePhoneNumber;
    private String smsAlertGroup;
    private String pin;

    public Recipient(RecipientBuilder builder) {
        this.name = builder.name;
        this.address = builder.addressBuilder.build();
        this.mobilePhoneNumber = builder.mobilePhoneNumber;
        this.smsAlertGroup = builder.smsAlertGroup;
        this.pin = builder.pin;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getSmsAlertGroup() {
        return smsAlertGroup;
    }

    public String getPin() {
        return pin;
    }

    public static class RecipientBuilder {
        private final String name;
        private final Address.AddressBuilder addressBuilder;
        private String mobilePhoneNumber;
        private String smsAlertGroup;
        private String pin;

        public RecipientBuilder(String name, Address.AddressBuilder addressBuilder) {
            this.name = name;
            this.addressBuilder = addressBuilder;
        }

        public RecipientBuilder mobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public RecipientBuilder smsAlertGroup(String smsAlertGroup) {
            this.smsAlertGroup = smsAlertGroup;
            return this;
        }

        public RecipientBuilder pin(String pin) {
            this.pin = pin;
            return this;
        }

        public Recipient build() {
            return new Recipient(this);
        }
    }
}
