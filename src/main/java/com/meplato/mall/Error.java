package com.meplato.mall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Error is a valid response from a service call
 * that returns error information from the server.
 */
public class Error {
    @SerializedName("error")
    private final ErrorInner error;

    public Error(ErrorInner error) {
        this.error = error;
    }

    public ErrorInner getError() {
        return error;
    }

    public static class ErrorInner {
        @SerializedName("code")
        private final int code;
        @SerializedName("message")
        private final String message;
        @SerializedName("details")
        private final List<String> details;

        public ErrorInner(int code, String message, List<String> details) {
            this.code = code;
            this.message = message;
            this.details = details;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public List<String> getDetails() {
            return details;
        }
    }
}
