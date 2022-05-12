package de.agiehl.bgg.httpclient;

public class BggHttpClientException extends RuntimeException {
    public BggHttpClientException(String msg, Exception e) {
        super(msg, e);
    }

    public BggHttpClientException(String message) {
        super(message);
    }
}
