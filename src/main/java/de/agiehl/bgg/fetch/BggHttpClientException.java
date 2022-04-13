package de.agiehl.bgg.fetch;

public class BggHttpClientException extends RuntimeException {
    public BggHttpClientException(String msg, Exception e) {
        super(msg, e);
    }

    public BggHttpClientException(String message) {
        super(message);
    }
}
