package de.agiehl.bgg.httpclient;

import lombok.Getter;

@Getter
public class BggHttpClientException extends RuntimeException {

    private final String url;

    private final int statuscode;

    public BggHttpClientException(String msg, String url, int statuscode, Exception e) {
        super(msg, e);
        this.url = url;
        this.statuscode = statuscode;
    }

    public BggHttpClientException(String msg, Exception e) {
        this(msg, null, -1, e);
    }

    public BggHttpClientException(String msg, String url, int statuscode) {
        this(msg, url, statuscode, null);
    }
}
