package com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode;

/**
 * Created by colinanderson on 27/02/2018.
 */

public class MultimediaContent {
    private String contentUri1;
    private String contentUri2;

    private MultimediaContent(MultimediaContentBuilder builder) {
        this.contentUri1 = builder.contentUri1;
        this.contentUri2 = builder.contentUri2;
    }

    public String getContentUri1() {
        return contentUri1;
    }

    public String getContentUri2() {
        return contentUri2;
    }

    public static class MultimediaContentBuilder {
        private String contentUri1;
        private String contentUri2;

        public MultimediaContentBuilder contentUri1(String contentUri1) {
            this.contentUri1 = contentUri1;
            return this;
        }

        public MultimediaContentBuilder contentUri2(String contentUri2) {
            this.contentUri2 = contentUri2;
            return this;
        }

        public MultimediaContent build() {
            return new MultimediaContent(this);
        }
    }
}
