package com.meplato.mall;

/**
 * ServiceException thrown while communicating with a service.
 */
public class ServiceException extends Throwable {
    private final Error error;

    public ServiceException(String message, Error error, Throwable ex) {
        super(message, ex);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public static ServiceException fromResponse(Response response) {
        if (response == null) {
            return new ServiceException("Request failed", null, null);
        }

        Error error = response.getBodyJSON(Error.class);
        if (error == null) {
            return new ServiceException("Request failed", null, null);
        }
        if (error.getError() == null) {
            return new ServiceException("Request failed", error, null);
        }
        return new ServiceException(error.getError().getMessage(), error, null);
    }
}
