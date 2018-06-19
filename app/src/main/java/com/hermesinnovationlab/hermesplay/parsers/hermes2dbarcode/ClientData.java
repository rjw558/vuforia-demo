package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class ClientData {
    private final String clientId;
    private final String childClientId;

    private ClientData(ClientDataBuilder builder) {
        this.clientId = builder.clientId;
        this.childClientId = builder.childClientId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getChildClientId() {
        return childClientId;
    }

    public static class ClientDataBuilder {
        private final String clientId;
        private String childClientId;

        public ClientDataBuilder(String clientId) {
            this.clientId = clientId;
        }

        public ClientDataBuilder childClientId(String childClientId) {
            this.childClientId = childClientId;
            return this;
        }

        public ClientData build() {
            return new ClientData(this);
        }
    }
}
