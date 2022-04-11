package de.agiehl.bgg.fetch;

public class BggFetchException extends RuntimeException {
    public BggFetchException(String msg, Exception e) {
        super(msg, e);
    }
}
