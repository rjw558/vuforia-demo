package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

public class DeliveryData {
    private String deliveryMethod;
    private String courierRoundId;
    private String parcelshopId;
    private String parcelshopName;

    public DeliveryData(DeliveryDataBuilder builder) {
        this.deliveryMethod = builder.deliveryMethod;
        this.courierRoundId = builder.courierRoundId;
        this.parcelshopId = builder.parcelshopId;
        this.parcelshopName = builder.parcelshopName;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getCourierRoundId() {
        return courierRoundId;
    }

    public String getParcelshopId() {
        return parcelshopId;
    }

    public String getParcelshopName() {
        return parcelshopName;
    }


    public static class DeliveryDataBuilder {
        private final String deliveryMethod;
        private String courierRoundId;
        private String parcelshopId;
        private String parcelshopName;

        public DeliveryDataBuilder(String deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
        }

        public DeliveryDataBuilder courierRoundId(String courierRoundId) {
            this.courierRoundId = courierRoundId;
            return this;
        }

        public DeliveryDataBuilder parcelshopId(String parcelshopId) {
            this.parcelshopId = parcelshopId;
            return this;
        }

        public DeliveryDataBuilder parcelshopName(String parcelshopName) {
            this.parcelshopName = parcelshopName;
            return this;
        }

        public DeliveryData build() {
            return new DeliveryData(this);
        }
    }
}
