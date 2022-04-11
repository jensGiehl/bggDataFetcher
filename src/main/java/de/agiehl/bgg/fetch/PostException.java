package de.agiehl.bgg.fetch;

public class PostException extends RuntimeException {
    public PostException(int statusCode, String body) {
        super(String.format("Login failed! Statuscode: %d Response: %s", statusCode, body));
    }
}
