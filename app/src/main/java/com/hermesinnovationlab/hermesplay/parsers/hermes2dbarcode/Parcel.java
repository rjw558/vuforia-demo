package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class Parcel {
    private int weight;
    private int length;
    private int width;
    private int depth;
    private int value;
    private String currency;
    private String type;

    private Parcel(ParcelBuilder builder) {
        this.weight = builder.weight;
        this.length = builder.length;
        this.width = builder.width;
        this.depth = builder.depth;
        this.value = builder.value;
        this.currency = builder.currency;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public static class ParcelBuilder {
        private final int weight;
        private final int length;
        private final int width;
        private final int depth;
        private final int value;
        private final String currency;
        private String type;

        public ParcelBuilder(int weight, int length, int width, int depth, int value, String currency) {
            this.weight = weight;
            this.length = length;
            this.width = width;
            this.depth = depth;
            this.value = value;
            this.currency = currency;
        }

        public ParcelBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Parcel build() {
            return new Parcel(this);
        }
    }
}
