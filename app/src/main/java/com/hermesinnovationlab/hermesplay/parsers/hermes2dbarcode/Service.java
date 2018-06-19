package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 21/02/2018.
 */

class Service {
    private final String name;

    private Service(ServiceBuilder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static class ServiceBuilder {
        private final String name;

        public ServiceBuilder(String name) {
            this.name = name;
        }

        public Service build() {
            return new Service(this);
        }
    }
}
