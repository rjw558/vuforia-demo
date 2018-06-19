package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colinanderson on 21/02/2018.
 */

public class Hermes2DBarcodeParser {
    public static final String MESSAGE_HEADER = "[)";
    public static final String MESSAGE_FOOTER = "(]";
    private static final String GROUP_SEPERATOR = "\\+\\+";
    private static final String FIELD_SEPERATOR = "\\|\\|";
    private static final int EXPECTED_NUMBER_OF_ATTRIBUTE_GROUPS = 11;
    private static final int VERSION_GROUP_IDX = 0;
    private static final int BARCODE_GROUP_IDX = 1;
    private static final int CLIENTDATA_GROUP_IDX = 2;
    private static final int CUSTOMERDATA_GROUP_IDX = 3;
    private static final int SERVICE_GROUP_IDX = 4;
    private static final int RECIPIENT_GROUP_IDX = 5;
    private static final int PARCEL_GROUP_IDX = 6;
    private static final int DELIVERY_MESSAGE_GROUP_IDX = 7;
    private static final int DELIVERYDATA_GROUP_IDX = 8;
    private static final int MULTIMEDIA_CONTENT_GROUP_IDX = 9;
    private static final int RETURN_GROUP_IDX = 10;

    public static boolean isHermes2DBarcode(String barcodeData) {
        return barcodeDataHasAHeader(barcodeData) && barcodeDataHasAFooter(barcodeData);
    }

    @Nullable
    public static Hermes2DBarcode parseBarcodeData(String barcodeData) {
        if (barcodeDataIsValid(barcodeData)) {
            String[] items = barcodeData.split(GROUP_SEPERATOR);
            if (barcodeDataHasTheCorrectNumberOfAttributeGroups(items.length)) {
                Hermes2DBarcode.Hermes2DBarcodeBuilder builder = new Hermes2DBarcode.Hermes2DBarcodeBuilder(items[VERSION_GROUP_IDX],
                        items[BARCODE_GROUP_IDX],
                        parseClientData(items[CLIENTDATA_GROUP_IDX]),
                        parseServiceData(items[SERVICE_GROUP_IDX]),
                        parseRecipientData(items[RECIPIENT_GROUP_IDX]),
                        parseParcelData(items[PARCEL_GROUP_IDX]),
                        parseDeliveryDataData(items[DELIVERYDATA_GROUP_IDX])
                        )
                        .customerDataBuilder(parseCustomerData(items[CUSTOMERDATA_GROUP_IDX]))
                        .deliveryMessage(parseDeliveryMessageData(items[DELIVERY_MESSAGE_GROUP_IDX]))
                        .mutimediaContent(parseMultimediaContentData(items[MULTIMEDIA_CONTENT_GROUP_IDX]))
                        .returnData(parseReturnData(items[RETURN_GROUP_IDX]));
                return builder.build();
            }
            return null;
        } else {
            return null;
        }
    }

    private static ClientData.ClientDataBuilder parseClientData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        return new ClientData.ClientDataBuilder(itemFields[0])
                .childClientId(itemFields[1]);
    }

    private static CustomerData.CustomerDataBuilder parseCustomerData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        return new CustomerData.CustomerDataBuilder()
                .customerRef1(itemFields[0])
                .customerRef2(itemFields[1]);
    }

    private static List<Service> parseServiceData(String item) {
        List<Service> services = new ArrayList<>();
        String[] itemFields = item.split(FIELD_SEPERATOR);
        for (String itemField: itemFields) {
            services.add(new Service.ServiceBuilder(itemField).build());
        }
        return services;
    }

    private static Recipient.RecipientBuilder parseRecipientData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        Address.AddressBuilder addressBuilder = new Address.AddressBuilder(itemFields[7], itemFields[8])
        .addressLine1(itemFields[1])
                .addressLine2(itemFields[2])
                .addressLine3(itemFields[3])
                .addressLine4(itemFields[4])
                .addressLine5(itemFields[5])
                .addressLine6(itemFields[6]);
        return new Recipient.RecipientBuilder(itemFields[0], addressBuilder)
                .mobilePhoneNumber(itemFields[9])
                .smsAlertGroup(itemFields[10])
                .pin(itemFields[11]);
    }

    private static Parcel.ParcelBuilder parseParcelData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        return new Parcel.ParcelBuilder(Integer.parseInt(itemFields[0]),
                Integer.parseInt(itemFields[1]),
                Integer.parseInt(itemFields[2]),
                Integer.parseInt(itemFields[3]),
                Integer.parseInt(itemFields[4]),
                itemFields[5])
                .type(itemFields[6]);
    }

    private static String parseDeliveryMessageData(String item) {
        return item;
    }

    private static DeliveryData.DeliveryDataBuilder parseDeliveryDataData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        return new DeliveryData.DeliveryDataBuilder(itemFields[0])
                .courierRoundId(itemFields[1])
                .parcelshopId(itemFields[2])
                .parcelshopName(itemFields[3]);
    }

    private static MultimediaContent.MultimediaContentBuilder parseMultimediaContentData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        return new MultimediaContent.MultimediaContentBuilder()
                .contentUri1(itemFields[0])
                .contentUri2(itemFields[1]);
    }

    private static Return.ReturnBuilder parseReturnData(String item) {
        String[] itemFields = item.split(FIELD_SEPERATOR);
        Address.AddressBuilder addressBuilder = new Address.AddressBuilder(itemFields[7])
                .addressLine1(itemFields[1])
                .addressLine2(itemFields[2])
                .addressLine3(itemFields[3])
                .addressLine4(itemFields[4])
                .addressLine5(itemFields[5])
                .addressLine6(itemFields[6]);
        return new Return.ReturnBuilder()
                .addressBuilder(addressBuilder);
    }

    private static boolean barcodeDataIsValid(String barcodeData) {
        return barcodeDataHasAHeader(barcodeData) && barcodeDataHasAFooter(barcodeData);
    }

    private static boolean barcodeDataHasAHeader(String barcodeData) {
        return barcodeData.startsWith(MESSAGE_HEADER);
    }

    private static boolean barcodeDataHasAFooter(String barcodeData) {
        return barcodeData.endsWith(MESSAGE_FOOTER);
    }

    private static boolean barcodeDataHasTheCorrectNumberOfAttributeGroups(int length) {
        return length == EXPECTED_NUMBER_OF_ATTRIBUTE_GROUPS;
    }
}
