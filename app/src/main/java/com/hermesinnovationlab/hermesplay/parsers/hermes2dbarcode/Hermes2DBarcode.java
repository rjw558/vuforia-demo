package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

import java.util.List;

/**
 * Created by colinanderson on 21/02/2018.
 */

public class Hermes2DBarcode {
    private final String version;
    private final String barcode;
    private final ClientData clientData;
    private final CustomerData customerData;
    private final List<Service> services;
    private final Recipient recipient;
    private final Parcel parcelData;
    private final String deliveryMessage;
    private final DeliveryData deliveryData;
    private final MultimediaContent multimediaContent;
    private final Return returnData;

    private Hermes2DBarcode(Hermes2DBarcodeBuilder builder) {
        this.version = builder.version;
        this.barcode = builder.barcode;
        this.clientData = builder.clientDataBuilder.build();
        this.services = builder.services;
        this.recipient = builder.recipientBuilder.build();
        this.parcelData = builder.parcelBuilder.build();
        this.deliveryData = builder.deliveryDataBuilder.build();
        this.deliveryMessage = builder.deliveryMessage;
        this.customerData = builder.customerDataBuilder.build();
        this.multimediaContent = builder.multimediaContentBuilder.build();
        this.returnData = builder.returnBuilder.build();
    }

    public String getVersion() {
        return version;
    }

    public String getBarcode() {
        return barcode;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public List<Service> getServices() {
        return services;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Parcel getParcelData() {
        return parcelData;
    }

    public String getDeliveryMessage() {
        return deliveryMessage;
    }

    public DeliveryData getDeliveryData() {
        return deliveryData;
    }

    public MultimediaContent getMultimediaContent() {
        return multimediaContent;
    }

    public Return getReturnData() {
        return returnData;
    }

    public static class Hermes2DBarcodeBuilder {
        private final String version;
        private final String barcode;
        private final ClientData.ClientDataBuilder clientDataBuilder;
        private final List<Service> services;
        private final Recipient.RecipientBuilder recipientBuilder;
        private final Parcel.ParcelBuilder parcelBuilder;
        private final DeliveryData.DeliveryDataBuilder deliveryDataBuilder;
        private String deliveryMessage;
        private CustomerData.CustomerDataBuilder customerDataBuilder;
        private MultimediaContent.MultimediaContentBuilder multimediaContentBuilder;
        private Return.ReturnBuilder returnBuilder;

        public Hermes2DBarcodeBuilder(String version, String barcode, ClientData.ClientDataBuilder clientDataBuilder,
                                      List<Service> services, Recipient.RecipientBuilder recipientBuilder,
                                      Parcel.ParcelBuilder parcelBuilder, DeliveryData.DeliveryDataBuilder deliveryDataBuilder) {
            this.version = version;
            this.barcode = barcode;
            this.clientDataBuilder = clientDataBuilder;
            this.services = services;
            this.recipientBuilder = recipientBuilder;
            this.parcelBuilder = parcelBuilder;
            this.deliveryDataBuilder = deliveryDataBuilder;
        }

        public Hermes2DBarcodeBuilder deliveryMessage(String deliveryMessage) {
            this.deliveryMessage = deliveryMessage;
            return this;
        }

        public Hermes2DBarcodeBuilder customerDataBuilder(CustomerData.CustomerDataBuilder customerDataBuilder) {
            this.customerDataBuilder = customerDataBuilder;
            return this;
        }

        public Hermes2DBarcodeBuilder mutimediaContent(MultimediaContent.MultimediaContentBuilder multimediaContentBuilder) {
            this.multimediaContentBuilder = multimediaContentBuilder;
            return this;
        }

        public Hermes2DBarcodeBuilder returnData(Return.ReturnBuilder returnBuilder) {
            this.returnBuilder = returnBuilder;
            return this;
        }

        public Hermes2DBarcode build() {
            return new Hermes2DBarcode(this);
        }
    }
}
